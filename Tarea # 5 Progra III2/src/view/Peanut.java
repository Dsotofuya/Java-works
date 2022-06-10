package view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Game;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -8343009008814258002L;
	public static final String ICON_PATH = "src/data/monkey.png";
	
	private InGameCanvas gameCanvas;
	private	ScorePanel scorePanel;
	private ScreenshotsPanel screenshotsPanel;
	private GameOverPanel gameOverPanel;
	private MenuPane menuPane;
	private ResourceBundle bundle;
	private int count;
	private Game game;
	private KeyListener controlKey;
	private ActionListener control;
	
	public Peanut(ActionListener control, KeyListener controlKey, Game game) throws IOException {
		super("Amazonas Game");
		this.control = control;
		this.game = game;
		this.controlKey = controlKey;
		count = 0;
		bundle =  ResourceBundle.getBundle("languaje");
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(765,640);
		setResizable(false);
		setLocationRelativeTo(null);
		menuPane = new MenuPane(control, bundle);
		add(menuPane, BorderLayout.CENTER);
		screenshotsPanel = new ScreenshotsPanel();
		addKeyListener(controlKey);
		setVisible(true);
	}
		
	public void takeScreenShot() throws IOException, HeadlessException, AWTException {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		paint(img.getGraphics());
		File outputfile = new File("src/data/Screen"+ count + ".png");
		ImageIO.write(img, "png", outputfile);
		count ++;
		}
	
	public void starGame() {
		menuPane.setVisible(false);
		gameCanvas = new InGameCanvas(game, controlKey, bundle);
		add(gameCanvas, BorderLayout.CENTER);
	}

	public void ShowScores() throws IOException {
		menuPane.setVisible(false);
		scorePanel = new ScorePanel(bundle, control);
		add(scorePanel, BorderLayout.CENTER);
	}
	
	public void showMenu() {
		if (gameCanvas != null) {
			gameCanvas.setVisible(false);
		}if (scorePanel !=null) {
			scorePanel.setVisible(false);
		}if (screenshotsPanel != null) {
			screenshotsPanel.setVisible(false);
		}if (gameOverPanel != null) {
			gameOverPanel.setVisible(false);
		}
		menuPane.setVisible(true);
	}
	
	public void showGameOver() {
		gameCanvas.setVisible(false);
		gameOverPanel = new GameOverPanel(control, bundle);
		add(gameOverPanel, BorderLayout.CENTER);
	}

	public InGameCanvas getGameCanvas() {
		return gameCanvas;
	}
	
	public void showAbout() {
		JDialog about = new JDialog(this);
		about.setTitle(bundle.getString("about"));
		about.setSize(new Dimension(250, 150));
		about.setLocationRelativeTo(null);
		about.setLayout(new GridLayout(2,1));
		about.getContentPane().setBackground(Color.decode("#7fc0c7"));
		about.add(new JLabel("Elaborado Por Daniel Soto Fuya", SwingConstants.CENTER));
		about.add(new JLabel("cod: 201621288", SwingConstants.CENTER));
		about.setVisible(true);
	}
	
	public void howToPlay() {
		JDialog about = new JDialog(this);
		about.setTitle(bundle.getString("howPlay"));
		about.setSize(new Dimension(350, 150));
		about.setLocationRelativeTo(null);
		about.setLayout(new GridLayout(3,1));
		about.getContentPane().setBackground(Color.decode("#7fc0c7"));
		about.add(new JLabel("Use las flechas del teclado para moverse", SwingConstants.CENTER));
		about.add(new JLabel("M para pausar/despausar musica", SwingConstants.CENTER));
		about.add(new JLabel("B para tomar una captura de pantalla", SwingConstants.CENTER));
		about.setVisible(true);
	}
	
	public ScorePanel getScorePanel() {
		return scorePanel;
	}
	
	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}
}
