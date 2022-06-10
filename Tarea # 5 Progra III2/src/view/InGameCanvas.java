package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Character;
import model.Game;

public class InGameCanvas extends JPanel {
	private static final String SAFE_ZONE_PNG = "src/data/safeZone.png ";
	private static final String MANGO_PNG = "src/data/mango.png ";
	private static final String FIRE_PNG = "src/data/fire.png ";
	private static final String BACKGROUND_PNG = "src/data/background.png";
	private static final String MONKEY_PNG = "src/data/monkey.png";
	private static final long serialVersionUID = -7635742076114627983L;
	public static final int HEIGHT_WINDOW = 600;
	public static final int WIDTH_WINDOW = 800;

	private Game game;
	private Image background;
	private BufferedImage img;
	private BufferedImage fire;
	private BufferedImage resizedCharacter;
	private BufferedImage resizedBackground;
	private BufferedImage resizedFire;
	private BufferedImage mango;
	private BufferedImage resizedMango;
	private BufferedImage safeZone;
	private BufferedImage resizedSafeZone;
	private int countPosition;
	private ResourceBundle resourceBundle;

	public InGameCanvas(Game game, KeyListener control, ResourceBundle bundle) {
		this.resourceBundle  = bundle;
		this.game = game;
		setPreferredSize(new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW));
		setFocusable(true);
		addKeyListener(control);
		loadImages();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		countPosition = 0;
		g.drawImage(resizedBackground, 0, 0, this);
		repaintScore(g);
		repaintCharacter(g);
		repaintFire(g);
		repaintLife(g);
		repaintGrid(g);
	}

	private void repaintGrid(Graphics g) {
		for (int i = 0; i < WIDTH_WINDOW - 50; i = i + Game.SIZE_RECT) {
			for (int j = 0; j < HEIGHT_WINDOW - 50; j = j + Game.SIZE_RECT) {
				g.drawRect(i, j + Game.SIZE_RECT, Game.SIZE_RECT, Game.SIZE_RECT);
			}
		}
	}

	private void repaintScore(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString(resourceBundle.getString("score") + String.valueOf(game.getScore()), 400, 40);
	}

	private void repaintCharacter(Graphics g) {
		Character character = game.getCharacter();
		g.drawImage(resizedCharacter, character.getX(), character.getY() + Game.SIZE_RECT, this);
	}

	private void repaintFire(Graphics g) {
		for (int i = 0; i < game.getFireObjects().size(); i++) {
			if (game.getFireObjects().get(i) != null) {
				if (game.getFireObjects().get(i).getType() == 1) {
					g.drawImage(resizedFire, game.getFireObjects().get(i).getX(),
							game.getFireObjects().get(i).getY() + Game.SIZE_RECT, Game.SIZE_RECT, Game.SIZE_RECT, this);
				}
				if (game.getFireObjects().get(i).getType() == 2) {
					g.drawImage(resizedMango, game.getFireObjects().get(i).getX(),
							game.getFireObjects().get(i).getY() + Game.SIZE_RECT, Game.SIZE_RECT, Game.SIZE_RECT, this);
				}
				if (game.getFireObjects().get(i).getType() == 3) {
					g.drawImage(resizedSafeZone, game.getFireObjects().get(i).getX(),
							game.getFireObjects().get(i).getY() + Game.SIZE_RECT, Game.SIZE_RECT, Game.SIZE_RECT, this);
				}
			}
		}
	}

	private void repaintLife(Graphics g) {
		for (int i = 0; i < game.getCharacter().getLife(); i++) {
			g.drawImage(resizedMango, 0 + countPosition, 0, Game.SIZE_RECT, Game.SIZE_RECT, this);
			countPosition = countPosition + Game.SIZE_RECT;
		}
	}

	private void loadImages() {
		try {
			img = ImageIO.read(new File(MONKEY_PNG));
			background = ImageIO.read(new File(BACKGROUND_PNG));
			fire = ImageIO.read(new File(FIRE_PNG));
			mango = ImageIO.read(new File(MANGO_PNG));
			safeZone = ImageIO.read(new File(SAFE_ZONE_PNG));
		} catch (IOException e) {
			e.printStackTrace();
		}
		resizedImages();
	}

	private void resizedImages() {
		resizedCharacter = getScaledImage(img, Game.SIZE_RECT, Game.SIZE_RECT);
		resizedBackground = getScaledImage(background, WIDTH_WINDOW, HEIGHT_WINDOW + 50);
		resizedFire = getScaledImage(fire, Game.SIZE_RECT, Game.SIZE_RECT);
		resizedMango = getScaledImage(mango, Game.SIZE_RECT, Game.SIZE_RECT);
		resizedSafeZone = getScaledImage(safeZone, Game.SIZE_RECT, Game.SIZE_RECT);
	}

	private BufferedImage getScaledImage(Image srcImg, int w, int h) {
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
