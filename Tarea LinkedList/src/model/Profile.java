package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Profile {
	private int id;
	private BufferedImage image;
	private String name;
	private String bornday;
	private String description;
	private int likes;
	
	public Profile(int id, BufferedImage image, String name, String bornday, String description) {
		this.id = id;
		this.image = getScaledImage(image, 200, 200);
		this.name = name;
		this.bornday = bornday;
		this.description = description;
		likes = 0;
	}
	
	private BufferedImage getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getBornday() {
		return bornday;
	}

	public String getDescription() {
		return description;
	}
	
	public int getId() {
		return id;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", image=" + image + ", name=" + name + ", bornday=" + bornday + ", description="
				+ description + ", likes=" + likes + "]";
	}
}
