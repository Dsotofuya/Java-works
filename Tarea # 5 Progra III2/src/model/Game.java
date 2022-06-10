package model;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game {

	private static final int SCORE_POINTS = 100;
	private static final String MUSIC_PATH = "src/data/music.wav";
	private static final int WIDTH = 15;
	private static final int HEIGHT = 11;
	private static final int VAR_O = 0;
	public static final int SIZE_RECT = 50;
	private static final int OBJECT_1 = 1;
	private static final int OBJECT_2 = 2;
	private static final int OBJECT_3 = 3;

	private ConcurrentHashMap<Integer, Object> fireObjects;
	private Character character;
	private Random random;
	private Clip audio;
	private boolean gameOver;
	private int count;
	private int score;

	public Game() {
		fireObjects = new ConcurrentHashMap<Integer, Object>();
		character = new Character();
		count = VAR_O;
		score = VAR_O;
		random = new Random();
		startMusic();
		fireObjects.put(count,
				new Object(random.nextInt(WIDTH) * SIZE_RECT, random.nextInt(HEIGHT) * SIZE_RECT, OBJECT_3));
		count++;
	}

	public void start() {
		Thread startThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (character.getLife() > VAR_O) {
					score++;
					checkCollisions();
					addFire();
					gameOver = false;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gameOver = true;
				}
			}
		});
		startThread.start();
	}

	public void startMusic() {
		Thread musicThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					audio = AudioSystem.getClip();
					File file = new File(MUSIC_PATH);
					audio.open(AudioSystem.getAudioInputStream(file));
					audio.start();
					audio.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		musicThread.start();
	}

	private void checkCollisions() {
		Rectangle characterRect = new Rectangle(character.getX(), character.getY(), SIZE_RECT, SIZE_RECT);
		for (Integer id : fireObjects.keySet()) {
			Object fire = fireObjects.get(id);
			if (fire != null) {
				Rectangle obgectRectangle = new Rectangle(fire.getX(), fire.getY(), SIZE_RECT, SIZE_RECT);
				if (fire.getType() == OBJECT_1) {
					if (obgectRectangle.intersects(characterRect)) {
						character.crash();
					}
				} else if (fire.getType() == OBJECT_2) {
					if (obgectRectangle.intersects(characterRect)) {
						updateScore();
						fireObjects.remove(id);
					}
				} else if (fire.getType() == OBJECT_3) {
					if (obgectRectangle.intersects(characterRect)) {
						clean();
						fireObjects.remove(id);
						fireObjects.put(VAR_O, new Object(random.nextInt(WIDTH) * SIZE_RECT,
								random.nextInt(HEIGHT) * SIZE_RECT, OBJECT_3));
					}
				}
			}
		}
	}

	public void restart() {
		score = VAR_O;
		fireObjects.put(VAR_O, new Object(random.nextInt(15) * SIZE_RECT, random.nextInt(11) * SIZE_RECT, OBJECT_3));
		character.revive();
		clean();
		gameOver = false;
		start();
	}

	private void addFire() {
		int x = random.nextInt(WIDTH) * SIZE_RECT;
		int y = random.nextInt(HEIGHT) * SIZE_RECT;
		if (fireObjects.size() % WIDTH == VAR_O) {
			fireObjects.put(count, new Object(x, y, OBJECT_2));
			count++;
		} else {
			fireObjects.put(count, new Object(x, y, OBJECT_1));
			count++;
		}
	}

	private void clean() {
		for (int i = 1; i < fireObjects.size(); i++) {
			fireObjects.remove(i);
		}
	}

	private void updateScore() {
		score = score + SCORE_POINTS;
	}

	public void pauseMusic() {
		audio.stop();
	}

	public void reanudeMusic() {
		audio.start();
	}

	public void removeFire() {
		for (Integer id : fireObjects.keySet()) {
			fireObjects.remove(id);
		}
	}

	public Character getCharacter() {
		return character;
	}

	public ConcurrentHashMap<Integer, Object> getFireObjects() {
		return fireObjects;
	}

	public int getScore() {
		return score;
	}

	public Clip getAudio() {
		return audio;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
