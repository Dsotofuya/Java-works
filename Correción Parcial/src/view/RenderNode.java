package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import model.INode;

public class RenderNode implements TreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		JButton label = new JButton();
		INode node = (INode) ((DefaultMutableTreeNode) value).getUserObject();
		String path = node.getIcon();
		label.setIcon(new ImageIcon(path));
		label.setText(node.getData());
		label.setBackground(Color.decode(((INode) ((DefaultMutableTreeNode) value).getUserObject()).getColor()));
		return label;
	}
}