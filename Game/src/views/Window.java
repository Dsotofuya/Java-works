package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import models.Game;
import presenters.Presenter;


public class Window extends JFrame{

	private static final long serialVersionUID = 1L;

	private PanelGame panelGame;

	public Window(Presenter presenter, Game game) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelGame = new PanelGame(game);
		add(panelGame, BorderLayout.CENTER);
		
		addKeyListener(presenter);
		setVisible(true);
	}
	
	public void update(Game game) {
		panelGame.update(game);
	}
}
