package views;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import models.Node;
import models.Tree;


public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTree jTree;
	private DefaultTreeModel treeModel;
	private Tree<Character> tree;
	private DefaultListModel<String> model;

	public Window() {
		tree = new Tree<Character>('.');
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem btnAdd = new JMenuItem("Add");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Ingresa el contacto:");
				addContact(name);
				paintTree(tree.getRoot());
			}
		});
		JMenu menuFile = new JMenu("File");
		menuFile.add(btnAdd);
		menu.add(menuFile);

		jTree = new JTree();
		add(new JScrollPane(jTree), BorderLayout.LINE_START);

		model = new DefaultListModel<>();
		JList<String> list = new JList<String>(model);
		add(new JScrollPane(list), BorderLayout.CENTER);

		JTextField txName = new JTextField();
		txName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				search(txName.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("Escribiendo");
			}
		});
		add(txName, BorderLayout.PAGE_START);

		setVisible(true);
	}

	public void paintTree(Node<Character> root) {
		DefaultMutableTreeNode visualRoot = new DefaultMutableTreeNode(root.getInfo());
		for (Node<Character> child : root.getChilds()) {
			addChild(visualRoot, child);
		}
		treeModel = new DefaultTreeModel(visualRoot);
		jTree.setModel(treeModel);
		jTree.repaint();
	}

	private void addChild(DefaultMutableTreeNode father, Node<Character> base) {
		DefaultMutableTreeNode visualNode = new DefaultMutableTreeNode(base.getInfo());
		father.add(visualNode);
		for (Node<Character> child : base.getChilds()) {
			addChild(visualNode, child);
		}
	} 

	private void addContact(String name) {
		Node<Character> base = tree.getRoot();
		for (int i = 0; i < name.length(); i++) {
			char element = name.charAt(i);
			base = addToTree(base, element);
		}
	}

	public Node<Character> addToTree(Node<Character> base, char element) {
		Node<Character> result = base.getChilds().stream().filter(node -> element == node.getInfo())
				.findAny().orElse(null);
		if (result == null) {
			result = new Node<Character>(element);
			base.addChild(result);
		}
		return result;
	}
	
	public void search(String text) {
		model.removeAllElements();
		Node<Character> actual = tree.getRoot();
		String textBase = "";
		for (int i = 0; i < text.length(); i++) {
			char element = text.charAt(i);
			if(search(actual, element) != null) {
				actual = search(actual, element);
				textBase += element;
			}
		}
		concant(actual, textBase.substring(1));
	}
	
	public void concant(Node<Character> base, String text) {
		if(base.getChilds().isEmpty()) {
			model.addElement(text + base.getInfo());
		}else {
			for (Node<Character> child : base.getChilds()) {
				concant(child, text + base.getInfo());
			}
		}
	}

	private Node<Character> search(Node<Character> actual, char element) {
		Node<Character> result = actual.getChilds().stream().filter(node -> element == node.getInfo())
				.findAny().orElse(null);
		return result;
	}
	public static void main(String[] args) {
		new Window();
	}
}