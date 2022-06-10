package models;

import java.awt.Rectangle;

public class Ovni extends Rectangle {

	private static final long serialVersionUID = 1L;

	public static final int MAX_HEALT = 100;
	public static final int SIZE = 80;

	private volatile int health, points;
	private volatile boolean isDeath;
	private int angle;

	public Ovni() {
		super(650, 600, SIZE, SIZE);
		health = MAX_HEALT;
		angle = 0;
		points = 0;
		isDeath = false;
	}

	public void moveOvni(RunEnum runEnum) {
		switch (runEnum) {
		case DOWN:
			if (y > 700) {
				y = 0;
			}
			y = y + 5;
			break;
		case LEFT:
			if (x < 0) {
				x = 1250;
			}
			x = x - 5;
			break;
		case RIGHT:
			if (x > 1250) {
				x = 0;
			}
			x = x + 5;
			break;
		case UP:
			if (y < 0) {
				y = 700;
			}
			y = y - 5;
			break;
		}
	}

	public boolean isDeath() {
		if (health > 0) {
			isDeath = false;
		} else {
			isDeath = true;
		}
		return isDeath;
	}

	public int getPointX() {
		return x;
	}

	public int getPointY() {
		return y;
	}

	public int getHealt() {
		return health;
	}

	public int getAngle() {
		return angle;
	}

	public void contact() {
		if (health > 20) {
			health -= 1;
		} else {
			health -= 5;
		}
	}

	public void points() {
		points += 200;
	}

	public int getPoints() {
		return points;
	}

	public void setPositions(int i, int j) {
		this.x = i;
		this.y = j;
	}

	public void setDeath(boolean b) {
		isDeath = b;
	}

}
