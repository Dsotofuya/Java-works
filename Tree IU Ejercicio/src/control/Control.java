package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Node;
import models.Tree;
import view.Peanut;

public class Control implements ActionListener {

	private static final String TXT_SEARCH = "Cual es el numero que desea buscar?";
	private static final String TXT_ADD = "Cual es el nuevo numero a agregar?";
	private static final String TXT_DELETE = "Cual es el numero que desea eliminar?";

	private Tree tree;
	private Peanut peanut;
	private ArrayList<Node> nodeAuxList;

	public Control() {
		nodeAuxList = new ArrayList<Node>();
		tree = new Tree();
		peanut = new Peanut(this);
		tree.add(new Node(10));
		tree.add(new Node(5));
		tree.add(new Node(12));
		tree.add(new Node(3));
		tree.add(new Node(6));
		tree.add(new Node(1));
		peanut.repaintCanvas(tree);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD:
			addNode();
			break;
		case DELETE:
			deleteNode();
			break;
		case SEARCH:
			seachNode();
			break;
		case SHOW_FB:
			showFB();
			break;
		case SWING:
			swing();
			break;
		}
	}

	private void swing() {
		treeToArray(tree.getRoot());
		for (int i = 0; i < nodeAuxList.size(); i++) {
			tree.addNodeBalanced(nodeAuxList.get(i));
		}
		peanut.repaintCanvas(tree);
	}

	private void treeToArray(Node node) {
		nodeAuxList.add(node);
		if (node.getLeft() != null) {
			treeToArray(node.getLeft());
		}
		if (node.getRight() != null) {
			treeToArray(node.getRight());
		}
		tree = new Tree();
	}

	private void showFB() {
		tree.calculateFB(tree.getRoot());
		peanut.showFB(true);
	}

	private void seachNode() {
		tree.cleanFinded(tree.getRoot());
		tree.search(tree.getRoot(), Integer.valueOf(JOptionPane.showInputDialog(TXT_SEARCH)), 1);
		peanut.repaintCanvas(tree);
	}

	private void deleteNode() {
		tree.cleanFinded(tree.getRoot());
		tree.delete(Integer.valueOf(JOptionPane.showInputDialog(TXT_DELETE)));
		tree.calculateFB(tree.getRoot());
		peanut.repaintCanvas(tree);
	}

	private void addNode() {
		tree.cleanFinded(tree.getRoot());
		tree.add(new Node(Integer.valueOf(JOptionPane.showInputDialog(TXT_ADD))));
		tree.calculateFB(tree.getRoot());
		peanut.repaintCanvas(tree);
	}

	public static void main(String[] args) {
		new Control();
	}
}
