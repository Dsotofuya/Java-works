package model;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Game implements Runnable {

	public static final int SIZE_RECT = 50;

	private Character character;
	private ConcurrentHashMap<Integer, Fire> fireObjects;
	private Thread thread;
	private int count;
	
	public Game() {
		character = new Character();
		fireObjects = new ConcurrentHashMap<Integer, Fire>();
		count = 0;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (character.getLife() > 0) {
			addFire();
			checkCollisions();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void checkCollisions() {
		Rectangle characterRect = new Rectangle(character.getX(), character.getY(), SIZE_RECT, SIZE_RECT);
		for (Integer id : fireObjects.keySet()) {
			Fire fire = fireObjects.get(id);
			Rectangle enemyRect = new Rectangle(fire.getX(), fire.getY(), SIZE_RECT, SIZE_RECT);
			if (enemyRect.intersects(characterRect)) {
				System.out.println("crash");
				character.crash();
			}
		}
	}
//15*11
	private void addFire() {
		fireObjects.put(count, new Fire((new Random().nextInt(15) * SIZE_RECT), (new Random().nextInt(11) * SIZE_RECT )));
		count++;
	}

	public void removeFire() {
		for (Integer id : fireObjects.keySet()) {
			fireObjects.remove(id);
		}
	}
	
	public Character getCharacter() {
		return character;
	}
	
	public ConcurrentHashMap<Integer, Fire> getFireObjects() {
		return fireObjects;
	}

}
