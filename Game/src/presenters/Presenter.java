package presenters;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import models.Game;
import views.Window;

public class Presenter implements KeyListener{

	private Game game;
	private Window window;
	
	public Presenter() {
		game = new Game();
		window = new Window(this, game);
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.update(game);
			}
		});
		timer.start();
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		game.getHero().jump();
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	public static void main(String[] args) {
		new Presenter();
	}
}
