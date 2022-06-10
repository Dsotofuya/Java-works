package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import control.Events;
import model.INode;

public class Peanut extends JFrame {
	private static final String ADD_USER = "Add user";
	private static final String ADD_ZONE = "Add zone";
	private static final String ADD_COMPANY = "Add company";
	private static final String CALL_USER = "Call User";

	private static final long serialVersionUID = 4400742153022573199L;
	
	private static final String FILE = "File";
	private static final String DISABLE_USERS = "Disable users";
	private static final String BALANCE = "Balance";

	private JTree jTree;
	private DefaultTreeModel treeModel;
	private JPopupMenu popupMenu;

	public Peanut(ActionListener control, MouseListener mouseListener, INode rootNode) throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem addCompany = new JMenuItem(ADD_COMPANY);
		addCompany.addActionListener(control);
		addCompany.setActionCommand(Events.ADDCOMPANY.toString());
		JMenuItem addZone = new JMenuItem(ADD_ZONE);
		addZone.addActionListener(control);
		addZone.setActionCommand(Events.ADDZONE.toString());
		JMenuItem callUser = new JMenuItem(CALL_USER);
		callUser.addActionListener(control);
		callUser.setActionCommand(Events.CALL_USER.toString());
		JMenuItem addUser = new JMenuItem(ADD_USER);
		addUser.addActionListener(control);
		addUser.setActionCommand(Events.ADDUSER.toString());
		JMenuItem btnBalance = new JMenuItem(BALANCE);
		JMenuItem btnUnable = new JMenuItem(DISABLE_USERS);
		btnBalance.addActionListener(control);
		btnBalance.setActionCommand(Events.BALANCE.toString());
		btnUnable.addActionListener(control);
		btnUnable.setActionCommand(Events.UNABLE.toString());
		JMenu menuFile = new JMenu(FILE);
		menuFile.add(addCompany);
		menuFile.add(addZone);
		menuFile.add(addUser);
		menuFile.add(btnUnable);
		menuFile.add(btnBalance);
		menuFile.add(callUser);
		menu.add(menuFile);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootNode);
		jTree = new JTree(root);
		jTree.setCellRenderer(new RenderNode());
		jTree.setPreferredSize(new Dimension(500, 1000));
		jTree.addMouseListener(mouseListener);
		JScrollPane pane = new JScrollPane(jTree);
		pane.setSize(500, 700);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(pane, BorderLayout.LINE_START);

//		popupMenu = new JPopupMenu();
//		JMenuItem addFile = new JMenuItem(Events.ADD.toString());
//		addFile.addActionListener(control);
//		addFile.setActionCommand(Events.ADD.toString());
//		popupMenu.add(addFile);
		setSize(500, 700);
		setVisible(true);
	}

	public void paintTree(INode root) {
		DefaultMutableTreeNode visualRoot = new DefaultMutableTreeNode(root);
		for (INode child : root.getChildren()) {
			addChild(visualRoot, child);
		}
		treeModel = new DefaultTreeModel(visualRoot);
		jTree.setModel(treeModel);
		jTree.repaint();
		expandAll();
	}

	private void addChild(DefaultMutableTreeNode father, INode base) {
		DefaultMutableTreeNode visualNode = new DefaultMutableTreeNode(base);
		father.add(visualNode);
		for (INode child : base.getChildren()) {
			addChild(visualNode, child);
		}
	}

	public void expandAll() {
		for (int i = 0; i < jTree.getRowCount(); i++) {
			jTree.expandRow(i);
		}
	}

	public void showMenu(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			int row = jTree.getClosestRowForLocation(e.getXOnScreen(), e.getY());
			jTree.setSelectionRow(row);
			TreePath path = jTree.getPathForLocation(e.getPoint().x, e.getPoint().y);
			if (((DefaultMutableTreeNode) path.getLastPathComponent()).isRoot()) {
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
			if (((DefaultMutableTreeNode) path.getLastPathComponent()).isLeaf()) {
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
//			}if (((DefaultMutableTreeNode) path.getLastPathComponent()).isNodeDescendant()) {
			}
		}
	}
}