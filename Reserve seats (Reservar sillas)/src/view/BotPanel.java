package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BotPanel extends JPanel {
	private static final long serialVersionUID = -2731677703646216622L;

	private static final String SEAT_FILLED = "Seat Filled";
	private static final String SEAT_EMPTY = "Seat Empty";
	
	private JLabel infoFilled, infoEmpty;

	public BotPanel(ActionListener control) {
		setBackground(Color.DARK_GRAY);
		infoFilled = new JLabel(SEAT_FILLED,new ImageIcon("src/images/filledSeat.png"), SwingConstants.TRAILING);
		infoFilled.setFont(new Font("Arial", Font.BOLD, 30));
		infoFilled.setForeground(Color.WHITE);
		infoFilled.setPreferredSize(new Dimension(250, 70));
		add(infoFilled);
		infoEmpty = new JLabel(SEAT_EMPTY,new ImageIcon("src/images/emptySeat.png"), SwingConstants.TRAILING);
		infoEmpty.setPreferredSize(new Dimension(250, 70));
		infoEmpty.setFont(new Font("Arial", Font.BOLD, 30));
		infoEmpty.setForeground(Color.WHITE);
		add(infoEmpty);
	}

}
