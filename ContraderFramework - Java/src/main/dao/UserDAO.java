package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

public class UserDAO {

	private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";

	public UserDAO() {
	}

	public boolean getUserByUsernameAndPassword(String username, String password) {
		System.out.println("siamo qui mirko");
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			return statement.executeQuery().next();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public User ruolo(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		ResultSet resultSet = null;
		try {

			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();

			User utente = null;

			if (resultSet.next()) {
				utente = new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getInt("role"));

			}

			return utente;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public int testaruolo(String username, String password) {
		System.out.println("siamo qui testa");
		Connection connection = ConnectionSingleton.getInstance();
		ResultSet rs = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			rs = statement.executeQuery();
			int pr = rs.getInt("role");
			return pr;
		} catch (SQLException e) {
			// GestoreEccezioni.getInstance().gestisciEccezione(e);
			return 0;
		}
	}

}