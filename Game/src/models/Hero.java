package models;

public class Hero implements Runnable{

	public static final int SIZE = 50;
	private static final int JUMP_DISTANCE = 5;
	private volatile int x;
	private volatile int y;
	private int health;
	private Thread thread;
	public static final int MAX_HEALT = 100;

	
	public Hero() {
		y = Game.GROUND - SIZE;
		health = MAX_HEALT;
		thread = new Thread(this);
		thread.start();
	}
	
	public void jump() {
		y -= JUMP_DISTANCE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHealth() {
		return health;
	}
	
	@Override
	public void run() {
		while (health > 0) {
			if (y < Game.GROUND - SIZE) {
				y++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void contact() {
		health--;
	}
}