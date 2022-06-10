package view.desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import control.Events;

public class PeanutDesktop extends JFrame {
	private static final long serialVersionUID = 336635674031538466L;

	private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int WIDTH = (int) Math.round(SCREEN_SIZE.getWidth() / 2);
	private static final int HEIGHT = (int) Math.round(SCREEN_SIZE.getHeight() / 2);
	private static final String ARCHIVE = "Archive";
	private static final String ADD = "Add";
	private static final String DELETE = "Delete";
	private static final String DELETE_FIRST = "Delete First";
	private static final String DELETE_LAST = "Delete Last";
	private static final String DELETE_BY_ID = "Delete By Id";
	private static final String TITTLE = "Profile Contontroller";
	private static final String UPDATE = "Update";
	private CardsPanel cards;

	public PeanutDesktop(ActionListener control) {
		super(TITTLE);
		setSize(WIDTH, HEIGHT);
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		initMenubar(control);
		cards = new CardsPanel();
		JScrollPane pane = new JScrollPane(cards);
		pane.setPreferredSize(new Dimension(300, HEIGHT));
		add(pane, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	private void initMenubar(ActionListener control) {
		JMenuBar menuBar = new JMenuBar();
		JMenu add = new JMenu(ARCHIVE);
		JMenuItem addFirts = new JMenuItem(ADD);
		addFirts.addActionListener(control);
		addFirts.setActionCommand(Events.SHOW_ADD_DIALOG.toString());
		add.add(addFirts);
		JMenu delete = new JMenu(DELETE);
		JMenuItem deleteFirst = new JMenuItem(DELETE_FIRST);
		deleteFirst.addActionListener(control);
		deleteFirst.setActionCommand(Events.DELETE_FIRST.toString());
		JMenuItem deleteLast = new JMenuItem(DELETE_LAST);
		deleteLast.addActionListener(control);
		deleteLast.setActionCommand(Events.DELETE_LAST.toString());
		JMenuItem deleteById = new JMenuItem(DELETE_BY_ID);
		deleteById.addActionListener(control);
		deleteById.setActionCommand(Events.DELETE_BY_ID.toString());
		delete.add(deleteFirst);
		delete.add(deleteLast);
		delete.add(deleteById);
		JMenu update = new JMenu(UPDATE);
		update.setActionCommand(Events.UPDATE.toString());
		update.addActionListener(control);
		menuBar.add(add);
		menuBar.add(delete);
		menuBar.add(update);
		setJMenuBar(menuBar);
	}

	public CardsPanel getCards() {
		return cards;
	}
}
