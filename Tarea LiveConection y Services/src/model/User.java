package model;

public class User {

	private String name, photo;
	private long number, id;
	
	public User(long id, String name, String photo, long number) {
		this.name = name;
		this.photo = photo;
		this.number = number;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPhoto() {
		return photo;
	}

	public long getNumber() {
		return number;
	}
	
	public long getId() {
		return id;
	}
}
