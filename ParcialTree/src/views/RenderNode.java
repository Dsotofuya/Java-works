package views;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import models.INode;

public class RenderNode implements TreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object node, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		Object obj = ((DefaultMutableTreeNode) node).getUserObject();
		INode iNode = ((INode) obj);
		String path = iNode.icon();
		ImageIcon image = new ImageIcon(getClass().getResource(path));
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(new JLabel(iNode.getId()), BorderLayout.NORTH);
		JButton btn = new JButton(image);
		jPanel.add(btn, BorderLayout.CENTER);
		return jPanel;
	}
}
