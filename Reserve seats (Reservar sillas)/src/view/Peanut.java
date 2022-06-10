package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -8343009008814258002L;

	private TopPanel top;
	private CenterPanel center;
	private BotPanel bot;

	public Peanut(ActionListener control) {
		super("Tickets reservation");
		setSize(900, 500);
		setLocationRelativeTo(null);
		top = new TopPanel();
		add(top, BorderLayout.NORTH);
		center = new CenterPanel(control);
		add(center, BorderLayout.CENTER);
		bot = new BotPanel(control);
		add(bot, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public TopPanel getTop() {
		return top;
	}

	public CenterPanel getCenter() {
		return center;
	}

	public BotPanel getBot() {
		return bot;
	}

	public static void main(String[] args) {
		new Peanut(null);
	}
}
