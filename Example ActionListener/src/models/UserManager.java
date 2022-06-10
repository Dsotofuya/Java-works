package models;

import java.util.ArrayList;

public class UserManager {
	
	ArrayList<User> userList;
	
	public UserManager() {
		userList = new ArrayList<>();
	}
	
	public static User createUser(String name) {
		return new User(name);
	}
	
	public void addUser(User user) {
		userList.add(user);
	}

}
