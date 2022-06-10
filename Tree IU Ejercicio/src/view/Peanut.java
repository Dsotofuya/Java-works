package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.Events;
import models.Tree;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -8343009008814258002L;

	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	private CanvasPanel canvas;

	public Peanut(ActionListener control) {
		super("Tree V2");
		setSize((int) (size.getWidth()), (int) (size.getHeight() - 50));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initMenuBar(control);
		canvas = new CanvasPanel(null);
		add(canvas, BorderLayout.CENTER);
		setVisible(true);
	}

	private void initMenuBar(ActionListener control) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Archive");
		JMenu options = new JMenu("Options");
		JMenuItem add = new JMenuItem("Add");
		add.setActionCommand(Events.ADD.toString());
		add.addActionListener(control);
		JMenuItem delete = new JMenuItem("Delete");
		delete.setActionCommand(Events.DELETE.toString());
		delete.addActionListener(control);
		JMenuItem search = new JMenuItem("Search");
		search.setActionCommand(Events.SEARCH.toString());
		search.addActionListener(control);
		JMenuItem fB = new JMenuItem("Show Balancing Factor");
		fB.setActionCommand(Events.SHOW_FB.toString());
		fB.addActionListener(control);
		JMenuItem balance = new JMenuItem("Swing Tree");
		balance.setActionCommand(Events.SWING.toString());
		balance.addActionListener(control);
		menu.add(add);
		menu.add(delete);
		menu.add(search);
		options.add(fB);
		options.add(balance);
		menuBar.add(menu);
		menuBar.add(options);
		setJMenuBar(menuBar);
	}

	public void repaintCanvas(Tree tree) {
		canvas.setTree(tree);
		canvas.repaint();
	}

	public void showFB(boolean showFB) {
		canvas.setShowFB(showFB);
		canvas.repaint();
	}
}
