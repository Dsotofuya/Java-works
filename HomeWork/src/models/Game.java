package models;

import java.util.ArrayList;

public class Game implements Runnable {

	private Ovni ovni;
	private Thread thread;
	private Tree tree;
	private boolean isContact;
	private Enemy enemy;
	private ArrayList<Node> levels;
	private int sleep ;

	public Game() {
		this.tree = new Tree();
		this.ovni = new Ovni();
		isContact = false;
		this.enemy = new Enemy();
		sleep = 50;
	}

	@Override
	public void run() {
		while (!ovni.isDeath()) {
			enemy.moveEnemy(ovni.x, ovni.y);
			checkEnemyCollition();
			chechkCollitions();
			try {
				Thread.sleep(sleep);
				isContact = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void initGame() {
		ovni.setDeath(true);
		sleep = 50;
		this.enemy = new Enemy();
		this.ovni = new Ovni();
		thread = new Thread(this);
		thread.start();
	}

	private int numberRandom(int rang) {
		return (int) ((Math.random() * rang) + 1);
	}

	public Node addLevel(Node node, int id) {
		Node child = new Node(generateObs(), node.getId() + "." + (id + 1));
		node.addChild(child);
		return child;
	}

	private Level generateObs() {
		return new Level(numberRandom(1000), numberRandom(600), 200, 100);
	}

	public Ovni getOvni() {
		return ovni;
	}

	public Tree getTree() {
		return tree;
	}

	public boolean isContact() {
		return isContact;
	}

	public Node search(String id) {
		return tree.search(id);
	}

	public ArrayList<Node> getLevels(String path) {
		ArrayList<Node> levels = new ArrayList<Node>();
		String pathNode = path.replace(" ", "").replace("[", "").replace("]", "");
		String[] nodes = pathNode.split(",");
		for (int i = 0; i < nodes.length; i++) {
			levels.add(search(nodes[i]));
		}
		return levels;
	}

	public void levels(ArrayList<Node> levels) {
		this.levels = levels;
	}

	private void chechkCollitions() {
		if (levels != null) {
			for (Node obs : levels) {
				if (obs.getLevel().intersects(ovni)) {
					ovni.contact();
				}
			}
		}
	}

	private void checkEnemyCollition() {
		if (enemy.intersects(ovni)) {
			ovni.contact();
		}
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public Node searchDad(Node search) {
		return tree.searchDad(search);
	}

	public ArrayList<Node> searchPath(Node search) {
		return tree.path(search);
	}

}
