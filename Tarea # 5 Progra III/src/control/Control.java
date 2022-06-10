package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import model.Game;
import view.Peanut;

public class Control implements ActionListener, KeyListener {

	private Game game;
	private Peanut peanut;

	public Control() {
		game = new Game();
		peanut = new Peanut(this, this, game);
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				peanut.getGameCanvas().update(game);
			}
		});
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			game.getCharacter().moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			game.getCharacter().moveRight();
			break;
		case KeyEvent.VK_UP:
			game.getCharacter().moveUp();
			break;
		case KeyEvent.VK_DOWN:
			game.getCharacter().moveDown();
			break;
		default:
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public static void main(String[] args) {
		new Control();
	}

}
