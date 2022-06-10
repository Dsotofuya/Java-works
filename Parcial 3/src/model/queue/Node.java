package model.queue;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Node {
	
	private BufferedImage image;
	private Node next;
	
	public Node(BufferedImage image) {
		this.image = getScaledImage(image, 300, 200);
	}
	
	public Node(BufferedImage image, Node next) {
		this.image = getScaledImage(image, 300, 200);
		this.next = next;
	}
	
	private BufferedImage getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public BufferedImage getImage() {
		return image;
	}
}