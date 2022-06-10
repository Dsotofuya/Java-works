package models;

public class Guest {
	//attributes
	private int id;//objects id
	private static int count;//id counter, static trait keeps the new value once changed
	private String name;
	private String photoPath;//String with the location of the Person's photo

	public Guest(String name, String photoPath) {//parameters entered by the user
		this.id = count++;
		this.name = name;
		this.photoPath = photoPath;
	}

	public String getPhotoPath() {//gives photo location
		return photoPath;
	}

	public int getId() {//gives obj id
		return id;
	}

	@Override
	public String toString() {//in this class exclusively returns values with the specified text
		return "Person [id=" + id + ", name=" + name + ", photoPath=" + photoPath + "]";
	}
}