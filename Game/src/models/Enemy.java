package models;

public class Enemy implements Runnable{

	private volatile int x;
	private volatile int y;
	private volatile int size;
	private Thread thread;
	
	public Enemy() {
		thread = new Thread(this);
		thread.start();
		x = 1000;
		size = (int)(Math.random() * Game.GROUND);
		y = (int)(Math.random() * Game.GROUND);
	}
	
	@Override
	public void run() {
		while (x > 0) {
			x -= 5;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}
}