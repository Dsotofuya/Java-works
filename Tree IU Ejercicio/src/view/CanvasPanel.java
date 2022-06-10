package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import models.Node;
import models.Tree;

public class CanvasPanel extends Canvas {
	private static final long serialVersionUID = -8813716262247171760L;

	private Tree tree;
	private int width;
	private boolean showFB;

	public CanvasPanel(Tree tree) {
		this.tree = tree;
		showFB = false;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		width = width / 2;
		if (tree != null) {
			paintNode(g, tree.getRoot(), width, 0, 0);
		}
	}

	public void paintNode(Graphics g, Node node, int x, int y, int xDad) {
		if (node != null) {
			if (node.getLeft() != null) {
				g.setColor(Color.BLACK);
				g.drawLine(x + 25, y + 25, x - Math.abs(x - xDad)/2 + 25, y + 125);
			}
			if (node.getRight() != null) {
				g.setColor(Color.BLACK);
				g.drawLine(x + 25, y + 25, x + Math.abs(x - xDad)/2 + 25, y + 125);
			}
			if (node.getFinded() == 1) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.decode("#32a852"));
			}
			g.fillOval(x, y, 50, 50);
			g.setColor(Color.black);
			g.drawString(String.valueOf(node.getData()), x + 17, y + 30);
			if (showFB) {
				g.drawString(String.valueOf(node.getfB()), x - 25, y + 20);
			}
			paintNode(g, node.getLeft(), x - Math.abs(x - xDad) / 2, y + 100, x);
			paintNode(g, node.getRight(), x + Math.abs(x - xDad) / 2, y + 100, x);
		}
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public void setShowFB(boolean showFB) {
		this.showFB = showFB;
	}
}