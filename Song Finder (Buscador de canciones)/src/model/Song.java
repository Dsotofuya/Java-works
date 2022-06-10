package model;

public class Song {

	private String name;
	private String urlImage;
	
	/** Constructor **/
	public Song(String name, String url) {
		this.name = name;
		this.urlImage = url;
	}
	
	
	/**Getters name  & url of the image**/
	public String getName() {
		return name;
	}
	
	public String getUrlImage() {
		return urlImage;
	}

	/**Tostring song**/
	@Override
	public String toString() {
		return "Song [name=" + name + ", urlImage=" + urlImage + "]";
	}
}
