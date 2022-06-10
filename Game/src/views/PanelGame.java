package views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.Game;
import models.Hero;

public class PanelGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private Game game;
	private BufferedImage img;
	
	public PanelGame(Game game) {
		this.game = game;
		try {
			img = ImageIO.read(new File("hero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Hero hero = game.getHero();
		g.drawImage(img, hero.getX(), hero.getY(),  this);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		
		g.drawString("" + hero.getHealth(), hero.getX(), hero.getY());
		g.drawLine(0, Game.GROUND, 500, Game.GROUND);
		for (Integer id : game.getEnemies().keySet()) {
			g.fillRect(game.getEnemies().get(id).getX(),
					game.getEnemies().get(id).getY(),
					Hero.SIZE, game.getEnemies().get(id).getSize());
		}
	}

	public void update(Game game) {
		this.game = game;
		repaint();
	}
}
