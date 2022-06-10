package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Character;
import model.Game;

public class InGameCanvas extends JPanel {
	private static final long serialVersionUID = -7635742076114627983L; 
	
	private Game game;
	private BufferedImage img;
	
	public InGameCanvas(Game game) {
		this.game = game;
		try {
			img = ImageIO.read(new File("src/data/monkey.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Character character = game.getCharacter();
		g.setColor(Color.green);
		g.drawImage(getScaledImage(img, 50, 50), character.getX(), character.getY(), this);
//		g.fillRect(character.getX(), character.getY(), Game.SIZE_RECT, Game.SIZE_RECT);
		g.setColor(Color.red);
		for (int i = 0; i < game.getFireObjects().size(); i++) {
			g.fillRect(game.getFireObjects().get(i).getX(), game.getFireObjects().get(i).getY(),
					Game.SIZE_RECT, Game.SIZE_RECT);
		}
		for (int i = 0; i < Peanut.WIDTH_WINDOW -50; i= i + 50) {
			for (int j = 0; j < Peanut.HEIGHT_WINDOW-50; j= j + 50) {
				g.setColor(Color.black);
				g.drawRect(i, j, 50, 50);
			}	
		}
	}
	
	private BufferedImage getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
	
	public void update(Game game) {
		this.game = game;
		repaint();
	}
	
}
