package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import model.userTree.ANode;

public class PanelTreeUser extends JPanel {
	private static final long serialVersionUID = -562955632670945569L;

	private JTree jTree;
	private DefaultTreeModel treeModel;
	private JPopupMenu popupMenu;
	
	public PanelTreeUser(MouseListener mouseListener, ANode rootNode, ActionListener control) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootNode);
		jTree = new JTree(root);
		jTree.setCellRenderer(new RenderANode());
		jTree.addMouseListener(mouseListener);
		JScrollPane pane = new JScrollPane(jTree);
		pane.setPreferredSize(new Dimension(470, 650));
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(pane, BorderLayout.LINE_START);
//		
//		popupMenu = new JPopupMenu();
//		JMenuItem add = new JMenuItem(Events.ADD.toString());
//		add.addActionListener(control);
//		add.setActionCommand(Events.ADD.toString());
//		JMenuItem edit = new JMenuItem(Events.EDIT.toString());
//		edit.addActionListener(control);
//		edit.setActionCommand(Events.EDIT.toString());
//		JMenuItem view = new JMenuItem(Events.VIEW.toString());
//		view.addActionListener(control);
//		view.setActionCommand(Events.VIEW.toString());
//		JMenuItem delete = new JMenuItem(Events.DELETE.toString());
//		delete.addActionListener(control);
//		delete.setActionCommand(Events.DELETE.toString());
//		popupMenu.add(add);
//		popupMenu.add(edit);
//		popupMenu.add(view);
//		popupMenu.add(delete);
	}
	
	public void paintTree(ANode root) {
		DefaultMutableTreeNode visualRoot = new DefaultMutableTreeNode(root);
		for (ANode child : root.getChildren()) {
			addChild(visualRoot, child);
		}
		treeModel = new DefaultTreeModel(visualRoot);
		jTree.setModel(treeModel);
		jTree.repaint();
		expandAll();
	}

	private void addChild(DefaultMutableTreeNode father, ANode base) {
		DefaultMutableTreeNode visualNode = new DefaultMutableTreeNode(base);
		father.add(visualNode);
		for (ANode child : base.getChildren()) {
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
			}
//			if (((DefaultMutableTreeNode) path.getLastPathComponent()).) {
//			}
		}
	}
}
