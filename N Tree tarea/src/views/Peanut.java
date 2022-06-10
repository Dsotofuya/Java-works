package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Node;
import model.Tree;

public class Peanut extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTree jTree;
	private DefaultTreeModel treeModel;
	private Tree tree;
	private DefaultListModel<String> model;

	public Peanut() {
		tree = new Tree();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem btnAdd = new JMenuItem("Add");
		JMenuItem btnDelete = new JMenuItem("Delete");
		JMenuItem btnInit = new JMenuItem("Start Tournament");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Ingresa del jugador:");
				tree.add(new Node(name));
				paintTree(tree.getRoot());
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Ingresa Del jugador a eliminar:");
				tree.delete(name);
				paintTree(tree.getRoot());
			}
		});
		btnInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tree.validateTeams();
				paintTree(tree.getRoot());
			}
		});
		JMenu menuFile = new JMenu("File");
		menuFile.add(btnAdd);
		menuFile.add(btnDelete);
		menuFile.add(btnInit);
		menu.add(menuFile);

		jTree = new JTree();
		jTree.setPreferredSize(new Dimension(500, 500));
		add(new JScrollPane(jTree), BorderLayout.LINE_START);

		model = new DefaultListModel<>();
		JList<String> list = new JList<String>(model);
		add(new JScrollPane(list), BorderLayout.CENTER);
		setSize(500, 700);
		setVisible(true);
	}

	public void paintTree(Node root) {
		DefaultMutableTreeNode visualRoot = new DefaultMutableTreeNode(root.getData());
		for (Node child : root.getChildren()) {
			addChild(visualRoot, child);
		}
		treeModel = new DefaultTreeModel(visualRoot);
		jTree.setModel(treeModel);
		jTree.repaint();
	}

	private void addChild(DefaultMutableTreeNode father, Node base) {
		DefaultMutableTreeNode visualNode = new DefaultMutableTreeNode(base.getData());
		father.add(visualNode);
		for (Node child : base.getChildren()) {
			addChild(visualNode, child);
		}
	}

	public static void main(String[] args) {
		Peanut xd = new Peanut();
		xd.tree.add(new Node("Pepe"));
		xd.paintTree(xd.tree.getRoot());
	}
}
