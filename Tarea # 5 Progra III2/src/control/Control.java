package control;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Timer;

import model.Game;
import model.dao.DataScoreDao;
import view.Peanut;

public class Control implements ActionListener, KeyListener {

	private ConcurrentHashMap<String, Integer> scoreList;
	private Peanut peanut;
	private DataScoreDao dao;
	private Game game;
	private Timer timer;

	public Control() {
		game = new Game();
		try {
			peanut = new Peanut(this, this, game);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dao = new DataScoreDao();
		scoreList = dao.listDates(dao.loadDates());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case STAR_GAME:
			game.restart();
			starGame();
			break;
		case HIGH_SCORES:
			showScores();
			break;
		case SCREENSHOTS:
			showScreens();
			break;
		case HOWPLAY:
			showHowPlay();
			break;
		case ABOUT:
			showAbout();
			break;
		case EXIT:
			System.exit(0);
			break;
		case ACCEPT:
			saveScore(peanut.getGameOverPanel().getUserText());
			break;
		case MENU:
			showMenu();
			break;
		case RESTART:
			starGame();
			break;
		default:
		}
	}

	private void showHowPlay() {
		peanut.howToPlay();
	}

	private void showMenu() {
		game.restart();
		peanut.showMenu();
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
		case KeyEvent.VK_M:
			controlleMusic();
			break;
		case KeyEvent.VK_B:
			takeScreen();
			break;
		default:
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void takeScreen() {
		try {
			peanut.takeScreenShot();
		} catch (HeadlessException | IOException | AWTException e) {
			e.printStackTrace();
		}
	}

	private void controlleMusic() {
		if (game.getAudio().isRunning() == true) {
			game.pauseMusic();
		} else if (game.getAudio().isRunning() == false) {
			game.reanudeMusic();
		}
	}

	private void showScreens() {
	}

	private void showScores() {
		try {
			peanut.ShowScores();
			if (scoreList != null) {
				peanut.getScorePanel().fillTable(scoreList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showAbout() {
		peanut.showAbout();
	}

	private void starGame() {
		game.start();
		peanut.starGame();
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				peanut.getGameCanvas().update(game);
				if (game.isGameOver() == true) {
					peanut.showGameOver();
					game.restart();
				}
			}
		});
		timer.start();
	}

	public void saveScore(String user) {
		scoreList.put(user, game.getScore());
		dao.writeDates(scoreList);
	}

	public static void main(String[] args) {
		new Control();
	}
}
