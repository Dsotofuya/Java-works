package model;

public class Song {

	private String name;
	private String urlImage;
	
	public Song(String name, String url) {
		this.name = name;
		this.urlImage = url;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrlImage() {
		return urlImage;
	}

	@Override
	public String toString() {
		return "Song [name=" + name + ", urlImage=" + urlImage + "]";
	}
}
