package model;

import view.Peanut;

public class Character {
	public static final int INIT_LIFE = 3;

	private int x;
	private int y;
	private short life;

	public Character() {
		initLife();
	}
	
	public void initLife() {
		life = INIT_LIFE;
		x = 0;
		y = 0;
	}

	public void crash() {
		life--;
	}

	public void lifeUp() {
		life++;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public short getLife() {
		return life;
	}

	public void moveLeft() {
		if (x > 0) {
			x = x - 50;
		}
	}

	public void moveRight() {
		if (x < (Peanut.WIDTH_WINDOW - 100 )) {
		x = x + 50;
		}
	}

	public void moveUp() {
		if (y > 0) {
			y = y - 50;
		}
	}

	public void moveDown() {
		if (y < (Peanut.HEIGHT_WINDOW - 100)) {
			y = y + 50;
		}
	}
}
