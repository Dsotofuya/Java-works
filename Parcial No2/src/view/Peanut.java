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
	private GenericPanel2 genericPanel2;

	public Peanut(ActionListener control) {
		super(PARCIAL);
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		genericpanel = new GenericPanel(control);
		add(genericpanel, BorderLayout.NORTH);
		genericPanel2 = new GenericPanel2();
		JScrollPane pane = new JScrollPane(genericPanel2);
		pane.setPreferredSize(new Dimension(400, 350));
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(pane, BorderLayout.CENTER);
		setVisible(true);
	}

	public GenericPanel getFindPanel() {
		return genericpanel;
	}

	public GenericPanel2 getCardsPanel() {
		return genericPanel2;
	}
}
