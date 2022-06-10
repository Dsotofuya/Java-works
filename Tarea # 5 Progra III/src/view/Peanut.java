package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import model.Game;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -8343009008814258002L;

	public static final int HEIGHT_WINDOW = 600;
	public static final int WIDTH_WINDOW = 800;
	
	private InGameCanvas gameCanvas;
	
	public Peanut(ActionListener control, KeyListener controlKey, Game game) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH_WINDOW,HEIGHT_WINDOW);
		setLocationRelativeTo(null);
		gameCanvas = new InGameCanvas(game);
		add(gameCanvas, BorderLayout.CENTER);
		addKeyListener(controlKey);
		setVisible(true);
	}
	
	public InGameCanvas getGameCanvas() {
		return gameCanvas;
	}
}
