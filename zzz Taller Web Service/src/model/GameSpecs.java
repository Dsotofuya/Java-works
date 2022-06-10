package model;

public class GameSpecs {

	private String img;
	private String description;
	private String minimumReqs;
	
	public GameSpecs(String img, String description, String minimum) {
		this.img = img;
		this.description = description;
		this.minimumReqs = minimum;
	}

	public String getImg() {
		return img;
	}

	public String getDescription() {
		return description;
	}

	public String getMinimumReqs() {
		return minimumReqs;
	}

	@Override
	public String toString() {
		return "GameSpecs \n URL imagen: " + img + "\n description: " + description + "\n minimumReqs: " + minimumReqs;
	}
	
	
}
