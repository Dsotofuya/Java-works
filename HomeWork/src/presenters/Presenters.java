package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import models.Game;
import models.Node;
import models.RunEnum;
import models.Tree;
import views.MyJFrameContainer;

public class Presenters extends KeyAdapter implements TreeSelectionListener, ActionListener {

	private MyJFrameContainer container;
	private Game game;

	public Presenters() {
		game = new Game();
		Tree tree = game.getTree();
		generateLevels(5,2);
		container = new MyJFrameContainer(game.getOvni(), game.getEnemy(), tree, this);
		container.paintTree(tree.getRoot());
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				container.updateGame(game.getOvni(), game.getEnemy());
				boolean isContac = game.isContact();
				if (isContac) {
					container.paintTree(tree.getRoot());
				}
			}
		});
		timer.start();
		container.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD:
			generateLevels(container.generateLevels(), container.generateRoads());
			container.paintTree(game.getTree().getRoot());
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (getCode(e) != null) {
			container.moveOvni(getCode(e));
			container.updateGame(game.getOvni(), game.getEnemy());
		}
	}

	public RunEnum getCode(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case 87:
			return RunEnum.UP;
		case 83:
			return RunEnum.DOWN;
		case 68:
			return RunEnum.RIGHT;
		case 65:
			return RunEnum.LEFT;
		}
		return null;
	}

	private void generateLevels(int leves, int road) {
		generateLevels(game.getTree().getRoot(), leves, road);
	}

	private void generateLevels(Node node, int leves, int road) {
		for (int i = 0; i < road; i++) {
			Node addLevel = game.addLevel(node, i);
			if (leves == 1) {
				continue;
			}
			generateLevels(addLevel, leves - 1, road);
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		ArrayList<Node> levels = game.getLevels(e.getPath().toString());
		Node node = game.search(e.getPath().getLastPathComponent().toString());
		System.out.println(game.searchPath(node));
		game.levels(levels);
		game.initGame();
		container.paintLevels(levels);
		container.focusPanel(this);
	}

	public static void main(String[] args) {
		new Presenters();
	}

}
