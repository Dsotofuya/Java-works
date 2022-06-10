package models;

import java.awt.Rectangle;
import java.util.concurrent.ConcurrentHashMap;

public class Game implements Runnable{
	
	private static final int MAX_ENEMIES = 1;
	public static final int GROUND = 550;
	private Hero hero;
	private ConcurrentHashMap<Integer, Enemy> enemies;
	private Thread thread;
	
	public Game() {
		hero = new Hero();
		enemies = new ConcurrentHashMap<>();
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (hero.getHealth() > 0) {
			addEnemies();
			removeEnemies();
			checkCollisions();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void checkCollisions() {
		Rectangle heroRect = new Rectangle(hero.getX(),
				hero.getY(), Hero.SIZE, Hero.SIZE);
		for (Integer id : enemies.keySet()) {
			Enemy enemy = enemies.get(id);
			Rectangle enemyRect = new Rectangle(enemy.getX(),
					enemy.getY(), Hero.SIZE, enemy.getSize());
			if (enemyRect.intersects(heroRect)) {
				hero.contact();
			}
		}
	}

	private void addEnemies() {
		if (enemies.size() < MAX_ENEMIES) {
			enemies.put(enemies.size(), new Enemy());
		}
	}

	private void removeEnemies() {
		for (Integer id : enemies.keySet()) {
			if (enemies.get(id).getX() == 0) {
				enemies.remove(id);
			}
		}
	}

	public Hero getHero() {
		return hero;
	}

	public ConcurrentHashMap<Integer, Enemy> getEnemies() {
		return enemies;
	}

}