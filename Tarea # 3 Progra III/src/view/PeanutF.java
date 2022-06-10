package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import control.Events;

public class PeanutF extends JFrame {
	private static final long serialVersionUID = 7403037528044919825L;

	private static final String ABOUT = "About";

	private TextPanel textPanel;
	private CanvasPanel canvasPanel;

	public PeanutF(ActionListener control) {
		super("Cloud Of Ideas");
		JMenuBar bar = new JMenuBar();
		JMenuItem about = new JMenuItem(ABOUT);
		about.addActionListener(control);
		about.setActionCommand(Events.ABOUT.toString());
		bar.add(about);
		setJMenuBar(bar);
		setIconImage(new ImageIcon("src/data/icon.png").getImage());
		setResizable(false);
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textPanel = new TextPanel(control);
		add(textPanel, BorderLayout.NORTH);
		canvasPanel = new CanvasPanel();
		add(canvasPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	public TextPanel getTextPanel() {
		return textPanel;
	}

	public CanvasPanel getCanvasPanel() {
		return canvasPanel;
	}
	
	public void showAbout() {
		JDialog about = new JDialog(this);
		about.setTitle(ABOUT);
		about.setSize(new Dimension(250, 150));
		about.setLocationRelativeTo(null);
		about.setLayout(new GridLayout(2,1));
		about.getContentPane().setBackground(Color.decode("#7fc0c7"));
		about.add(new JLabel("Elaborado Por Daniel Soto Fuya", SwingConstants.CENTER));
		about.add(new JLabel("cod: 201621288", SwingConstants.CENTER));
		about.setVisible(true);
	}
}