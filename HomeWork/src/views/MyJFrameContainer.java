package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import models.Enemy;
import models.Node;
import models.Ovni;
import models.RunEnum;
import models.Tree;
import presenters.Events;
import presenters.Presenters;

public class MyJFrameContainer extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTree jTree;
	private DefaultTreeModel treeModel;
	private JPanelPlayGame panelGame;

	public MyJFrameContainer(Ovni ovni, Enemy enemy, Tree tree, Presenters presenter) {
		jTree = new JTree();
		jTree.addTreeSelectionListener(presenter);
		jTree.setFocusable(false);
		panelGame = new JPanelPlayGame(ovni, enemy);

		JMenuBar bar = new JMenuBar();
		JMenu jMenu = new JMenu("Opciones");
		JMenuItem item = new JMenuItem("Agregar");
		item.addActionListener(presenter);
		item.setActionCommand(Events.ADD.name());
		jMenu.add(item);
		bar.add(jMenu);

		setJMenuBar(bar);

		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(400, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JScrollPane jScrollPane = new JScrollPane(jTree);
		jScrollPane.setSize(200,0);
		
		add((jScrollPane), BorderLayout.WEST);
		add(panelGame, BorderLayout.CENTER);
	}

	public void paintTree(Node root) {
		DefaultMutableTreeNode visualRoot = new DefaultMutableTreeNode(root.getId());
		for (Node child : root.getChildren()) {
			addChild(visualRoot, child);
		}
		treeModel = new DefaultTreeModel(visualRoot);
		jTree.setModel(treeModel);
		expandAll();
		jTree.repaint();
	}

	private void addChild(DefaultMutableTreeNode father, Node base) {
		DefaultMutableTreeNode visualNode = new DefaultMutableTreeNode(base.getId());
		father.add(visualNode);
		for (Node child : base.getChildren()) {
			addChild(visualNode, child);
		}
	}

	private void expandAll() {
		for (int i = 0; i < jTree.getRowCount(); i++) {
			jTree.expandRow(i);
		}
	}

	public void updateGame(Ovni ovni, Enemy enemy) {
		panelGame.updateGame(ovni, enemy);
	}

	public void moveOvni(RunEnum code) {
		panelGame.moveFigure(code);
	}

	public void focusPanel(Presenters presenters) {
		addKeyListener(presenters);
		setFocusable(true);
		requestFocus();
	}

	public void paintLevels(ArrayList<Node> levels) {
		panelGame.paintLevels(levels);
		repaint();
	}

	public int generateLevels() {
		return Integer.parseInt(JOptionPane.showInputDialog("Cantidad de niveles por camino"));
	}

	public int generateRoads() {
		return Integer.parseInt(JOptionPane.showInputDialog("Cantidad de caminos"));
	}

}
