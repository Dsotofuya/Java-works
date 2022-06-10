package models;

import java.awt.Rectangle;

public class Enemy extends Rectangle {

	private static final long serialVersionUID = 1L;

	public static final int SIZE = 120;

	public Enemy() {
		super(10, 10, SIZE, SIZE);
	}

	public void moveEnemy(int x, int y) {
		if (this.x < x) {
			this.x = this.x + 5;
		} else if (this.x > x) {
			this.x = this.x - 5;
		} else if (this.y < y) {
			this.y = this.y + 5;
		} else if (this.y > y) {
			this.y = this.y - 5;
		}
	}

}