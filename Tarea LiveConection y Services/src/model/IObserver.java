package model;

import java.util.ArrayList;

public interface IObserver {
	void updateState(String message);
	
	void updateList(ArrayList<User> userList);
}
