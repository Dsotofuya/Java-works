package model.dao;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class ImageDao implements Runnable{

	private Color[][] array;
	private int width, height; 
	
	@Override
	public void run() {
		try {
			InputStream input = new FileInputStream("src/data/icon.png");
			ImageInputStream imageStream = ImageIO.createImageInputStream(input);
			BufferedImage bufferedImage = ImageIO.read(imageStream);
				width = bufferedImage.getWidth(); height = bufferedImage.getHeight();
				array = new Color[width][height];
				Color colorAux; int mediaPixel;
				for (int i = 0; i < bufferedImage.getWidth(); i++) {
					for (int j = 0; j < bufferedImage.getHeight(); j++) {
						colorAux= new Color(bufferedImage.getRGB(i, j));
		                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
						array[i][j] = new Color((mediaPixel << 16) | (mediaPixel << 8) | mediaPixel);
						System.out.println("pocesando imagen");
					}
					Thread.sleep(50);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized Color[][] getArray() {
		return array;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
}