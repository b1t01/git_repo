package main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

public class SuperDAO {

	private final String QUERY_ALL_GAMER = "select * from user where role=1";
	private final String QUERY_INSERT_GAMER = "insert into user (username,password,role) values (?,?,?)";
	private final String QUERY_DELETE_GAMER = "delete from user where username=?";
	private final String QUERY_UPDATE_GAMERPW = "update user set password=? ";
	private List<User> listagamer = new ArrayList<User>();

	public SuperDAO() {
	}

	public List<User> getAllGamers() {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedstatement = (PreparedStatement) connection.prepareStatement(QUERY_ALL_GAMER);
			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				User gamemaster = new User(resultset.getInt("id"), resultset.getString("username"),
						resultset.getString("password"), resultset.getInt("role"));
				this.listagamer.add(gamemaster);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.listagamer;

	}

	public void insertMaster(String username, String password) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedstatement = (PreparedStatement) connection.prepareStatement(QUERY_INSERT_GAMER);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			preparedstatement.setString(3, "1");
			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMasterPassword(String password) {
		Connection conn = ConnectionSingleton.getInstance();
		try (PreparedStatement ps = (PreparedStatement) conn.prepareStatement(QUERY_UPDATE_GAMERPW)) {
			ps.setString(1, password);
			ps.execute();
			System.out.println(" rows affected by the SQL statement: " + ps.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMaster(String username) {
		Connection conn = ConnectionSingleton.getInstance();
		try (PreparedStatement ps = (PreparedStatement) conn.prepareStatement(QUERY_DELETE_GAMER)) {
			ps.executeQuery();
			System.out.println(username + " rimosso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
//da fare delete