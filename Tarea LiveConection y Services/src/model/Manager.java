package model;

import java.util.ArrayList;

public class Manager {
	
	private ArrayList<User> userList;
	private int id;
	
	public Manager() {
		userList = new ArrayList<User>();
		id = 0;
	}
	
	public User createPost(String name, String photo, long number) {
		return new User(id++, name, photo, number);
	}
	
	public void addPost(User user) {
		userList.add(user);
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}
}
