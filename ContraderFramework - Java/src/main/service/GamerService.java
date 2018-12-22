package main.service;

import java.util.ArrayList;

import main.dao.SuperDAO;
import main.model.User;

public class GamerService {

	private SuperDAO superDAO;

	public GamerService() {

		this.superDAO = new SuperDAO();

	}

	public ArrayList<User> viewAllUser() {
		return (ArrayList<User>) superDAO.getAllGamers();
	}
	
	public void removeGamer(String username) {
		superDAO.deleteMaster(username);
	}
	
	public void updateGamerPassword(String password) {
		superDAO.updateMasterPassword(password);
	}
	
	public void insertGamer(String username,String password) {
		superDAO.insertMaster(username,password);
	}
}
