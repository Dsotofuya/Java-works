package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import models.INode;
import models.Node;
import presenters.Events;
import presenters.Presenter;

public class MyJFrameContainer extends JFrame {

	private static final String TITLE = "Parcial n-Tree";
	private static final String IMG_ICON = "/img/icon.png";
	private static final long serialVersionUID = 1L;
	private DefaultTreeModel treeModel;
	private JTree jTree;
//	private JPopupMenu popupMenu;
	private ActionListener listener;
	private MouseListener mouse;

	public MyJFrameContainer(Presenter presenter) {

		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(IMG_ICON)).getImage());
		setTitle(TITLE);

		this.listener = presenter;

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Node(""));
		DefaultTreeModel model = new DefaultTreeModel(root);

		jTree = new JTree(model);
		jTree.addTreeSelectionListener(presenter);
		jTree.setCellRenderer(new RenderNode());
		jTree.addMouseListener(mouse);

		add(new JScrollPane(jTree), BorderLayout.WEST);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout());
		jPanel.add(btn("Agragar empresa", Events.ADD.name() ));
		jPanel.add(btn("Agragar zona", Events.ADD_ZONA.name() ));
		jPanel.add(btn("Agragar usuario", Events.ADD_USER.name() ));
		jPanel.add(btn("Validar usuarios", Events.VALIDATE.name() ));

		add(jPanel, BorderLayout.SOUTH);

	}

	public void paintTree(INode iNode) {
		DefaultMutableTreeNode visualRoot = new DefaultMutableTreeNode(iNode);
		for (INode child : iNode.getChildren()) {
			addChild(visualRoot, child);
		}
		treeModel = new DefaultTreeModel(visualRoot);
		jTree.setModel(treeModel);

		expandAll();
		jTree.repaint();
	}

	private void addChild(DefaultMutableTreeNode father, INode base) {
		DefaultMutableTreeNode visualNode = new DefaultMutableTreeNode(base);
		father.add(visualNode);
		for (INode child : base.getChildren()) {
			addChild(visualNode, child);
		}
	}

	private void expandAll() {
		for (int i = 0; i < jTree.getRowCount(); i++) {
			jTree.expandRow(i);
		}
	}

	public String getNodeSelected() {
		return ((DefaultMutableTreeNode) jTree.getLastSelectedPathComponent()).toString();
	}

	private JButton btn(String name, String pathName) {
		JButton button = new JButton(name);
		button.addActionListener(listener);
		button.setActionCommand(pathName);
		return button;
	}

}
