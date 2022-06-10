package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Post {

	private String title;
	private String description;
	private int contactNumber;
	private int id;
	private static int count;
	private String image;

	public Post(String title, String description, int contactNumber, String image) {
		this.id = count++;
		this.title = title;
		this.description = description;
		this.contactNumber = contactNumber;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "" + title + "," + description + "," + contactNumber + "," + id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
