package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import model.INode;

public class RenderNode implements TreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		JLabel label = new JLabel();
		INode node = (INode) ((DefaultMutableTreeNode) value).getUserObject();
		label.setIcon(new ImageIcon(node.getIcon()));
		label.setText(node.getName());
		return label;
	}
}