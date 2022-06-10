package model;

import java.util.ArrayList;

import model.dao.DataUsersDao;

public class UserManager {

	private ArrayList<User> userList ;
	private DataUsersDao usersDao;
	
	
	public UserManager() {
		usersDao = new DataUsersDao();
		userList = usersDao.listDates(usersDao.loadDates());
		System.out.println(userList.toString());
	}
	
	public boolean validateUser(String userName) {
		boolean available = false;
		for (User user : userList) {
			if (userName.equalsIgnoreCase(user.getUser())) {
				available = false;
			} else {
				available = true;
			}
		}
		return available;
	}
	
	public User createUser(String user, String password, ArrayList<Archive> archiveList) {
		return new User(user, password, archiveList);
	}
	
	public void add(User user) {
		userList.add(user);
	}
	
	public User findUser(String userName) {
		User userFinded = null;
		for (User user : userList) {
			if (userName.equalsIgnoreCase(user.getUser())) {
				userFinded = user;
			}
		} return userFinded;
	}
	
	public void changePassword(String userName, String newPassword) {
		for (User user : userList) {
			if (userName.equalsIgnoreCase(user.getUser())) {
				user.setPassword(newPassword);
			}
		}
	}
	
	public void deleteUser(String userName) {
		for (User user : userList) {
			if (userName.equalsIgnoreCase(user.getUser())) {
				userList.remove(user);
			}
		}
	}
	
	public int getSizeUsedByUser(User user) {
		int size = 0;
		for (Archive archive : user.getArchiveList()) {
			size = (int) (size + archive.getSize());
		}
		return size;
	}

	public int datesToBar(int size) {
		int percentage = size/1048576;
		System.out.println(percentage);
		return percentage;
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}

	public DataUsersDao getUsersDao() {
		return usersDao;
	}
}