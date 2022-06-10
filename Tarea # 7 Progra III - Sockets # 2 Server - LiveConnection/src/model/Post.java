package model;

public class Post {

	private int id;
	private String title;
	private String photoPath;
	private String description;
	private int phone;

	public Post(int id, String tittle, String photoPhat, String description, int phone) {
		this.id = id;
		this.title = tittle;
		this.photoPath = photoPhat;
		this.description = description;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public String getDescription() {
		return description;
	}

	public int getPhone() {
		return phone;
	}
}