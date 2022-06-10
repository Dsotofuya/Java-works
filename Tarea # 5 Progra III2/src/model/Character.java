package model;

import java.util.Random;

import view.InGameCanvas;

public class Character {

	private static final int VAR = 100;
	public static final int INIT_LIFE = 3;
	private static final int VAR_O = 0;

	private Random random;
	private int x;
	private int y;
	private int life;

	public Character() {
		random = new Random();
		life = INIT_LIFE;
		x = random.nextInt(15) * Game.SIZE_RECT;
		y = random.nextInt(11) * Game.SIZE_RECT;
	}

	public void crash() {
		life--;
	}

	public void moveLeft() {
		if (x > VAR_O) {
			x = x - Game.SIZE_RECT;
		}
	}

	public void moveRight() {
		if (x < (InGameCanvas.WIDTH_WINDOW - VAR)) {
			x = x + Game.SIZE_RECT;
		}
	}

	public void moveUp() {
		if (y > VAR_O) {
			y = y - Game.SIZE_RECT;
		}
	}

	public void moveDown() {
		if (y < (InGameCanvas.HEIGHT_WINDOW - VAR)) {
			y = y + Game.SIZE_RECT;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLife() {
		return life;
	}
	
	public void revive() {
		life = INIT_LIFE;
		x = random.nextInt(15) * Game.SIZE_RECT;
		y = random.nextInt(11) * Game.SIZE_RECT;
	}
}
