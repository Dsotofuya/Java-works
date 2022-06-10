package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Events;

public class MenuPane extends JPanel {
	private static final long serialVersionUID = 7582315471827564252L;

	private static final String BTN_COLOR = "#32a852";
	private static final String BACKGROUND_PATH = "src/data/background.png";

	private JButton starGame;
	private JButton highScores;
	private JButton about;
	private JButton exit;
	private JButton screenshots;
	private JButton howToplay;
	private JLabel logo;
	private BufferedImage background;
	
	public MenuPane(ActionListener control, ResourceBundle bundle) throws IOException {
		setLayout(new FlowLayout(1, 20, 30));
		background = ImageIO.read(new File(BACKGROUND_PATH));
		logo = new JLabel();
		logo.setPreferredSize(new Dimension(700, 200));
		add(logo);
		starGame = new JButton(bundle.getString("star"));
		starGame.setBackground(Color.decode(BTN_COLOR));
		starGame.setForeground(Color.WHITE);
		starGame.setFocusable(false);
		starGame.setBorder(BorderFactory.createEmptyBorder());
		starGame.setPreferredSize(new Dimension(500, 25));
		starGame.addActionListener(control);
		starGame.setActionCommand(Events.STAR_GAME.toString());
		add(starGame);
		highScores = new JButton(bundle.getString("highScores"));
		highScores.setBackground(Color.decode(BTN_COLOR));
		highScores.setForeground(Color.WHITE);
		highScores.setFocusable(false);
		highScores.setBorder(BorderFactory.createEmptyBorder());
		highScores.setPreferredSize(new Dimension(500, 25));
		highScores.setActionCommand(Events.HIGH_SCORES.toString());
		highScores.addActionListener(control);
		add(highScores);
		screenshots = new JButton(bundle.getString("screenshots"));
		screenshots.setFocusable(false);
		screenshots.setBackground(Color.decode(BTN_COLOR));
		screenshots.setForeground(Color.WHITE);
		screenshots.setBorder(BorderFactory.createEmptyBorder());
		screenshots.setPreferredSize(new Dimension(500, 25));
		screenshots.setActionCommand(Events.SCREENSHOTS.toString());
		screenshots.addActionListener(control);
		add(screenshots);
		howToplay = new JButton(bundle.getString("howPlay"));
		howToplay.setFocusable(false);
		howToplay.setBackground(Color.decode(BTN_COLOR));
		howToplay.setForeground(Color.WHITE);
		howToplay.setBorder(BorderFactory.createEmptyBorder());
		howToplay.setPreferredSize(new Dimension(500, 25));
		howToplay.setActionCommand(Events.HOWPLAY.toString());
		howToplay.addActionListener(control);
		add(howToplay);
		about = new JButton(bundle.getString("about"));
		about.setFocusable(false);
		about.setBackground(Color.decode(BTN_COLOR));
		about.setForeground(Color.WHITE);
		about.setBorder(BorderFactory.createEmptyBorder());
		about.setPreferredSize(new Dimension(500, 25));
		about.setActionCommand(Events.ABOUT.toString());
		about.addActionListener(control);
		add(about);
		exit = new JButton(bundle.getString("exit"));
		exit.setFocusable(false);
		exit.setBackground(Color.decode(BTN_COLOR));
		exit.setForeground(Color.WHITE);
		exit.setBorder(BorderFactory.createEmptyBorder());
		exit.setPreferredSize(new Dimension(500, 25));
		exit.addActionListener(control);
		exit.setActionCommand(Events.EXIT.toString());
		add(exit);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(getScaledImage(background, InGameCanvas.WIDTH_WINDOW, InGameCanvas.HEIGHT_WINDOW + 50), 0, 0, this);
	}

	private BufferedImage getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}
}
