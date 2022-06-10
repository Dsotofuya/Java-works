package model;

public class Post {

	private long id;
	private String title;
	private String photoPath;
	private String description;
	private long phone;

	public Post(long id, String tittle, String photoPhat, String description, long phone) {
		this.id = id;
		this.title = tittle;
		this.photoPath = photoPhat;
		this.description = description;
		this.phone = phone;
	}

	public long getId() {
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

	public long getPhone() {
		return phone;
	}
}