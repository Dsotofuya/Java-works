package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -6644915693652104869L;

	private static final String ICON_PATH = "src/data/icon.png";
	private static final String PARCIAL = "Parcial 2";

	private GenericPanel genericpanel;
	private CardsPanel cards;

	public Peanut(ActionListener control) {
		super(PARCIAL);
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		genericpanel = new GenericPanel(control);
		add(genericpanel, BorderLayout.NORTH);
		cards = new CardsPanel();
		JScrollPane pane = new JScrollPane(cards);
		pane.setPreferredSize(new Dimension(400, 350));
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(pane, BorderLayout.CENTER);
		setVisible(true);
	}

	public GenericPanel getGeneric() {
		return genericpanel;
	}
	
	public CardsPanel getCards() {
		return cards;
	}
}
