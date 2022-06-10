package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Events;

public class CenterPanel extends JPanel {
	private static final long serialVersionUID = 3560991525376633046L;

	private ActionListener control;

	public CenterPanel(ActionListener control) {
		this.control = control;
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.DARK_GRAY);
	}

	public void fillMatrix(int[][] seatsMatriz) {
		for (int i = 0; i < seatsMatriz.length; i++) {
			for (int j = 0; j < seatsMatriz.length; j++) {
				if (seatsMatriz[i][j] == 0) {
					JButton avaliableSeat = new JButton();
					avaliableSeat.setPreferredSize(new Dimension(40, 40));
					avaliableSeat.setActionCommand(Events.RESERVE.toString());
					avaliableSeat.setFocusable(false);
					avaliableSeat.setOpaque(false);
					avaliableSeat.setContentAreaFilled(false);
					avaliableSeat.setBorderPainted(false);
					avaliableSeat.setBackground(Color.green);
					avaliableSeat.setIcon(new ImageIcon(new ImageIcon("src/images/emptySeat.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
					avaliableSeat.setName(i + "-" + j);
					avaliableSeat.addActionListener(control);
					add(avaliableSeat);
				} else if (seatsMatriz[i][j] == 1) {
					JButton filledSeat = new JButton();
					filledSeat.setPreferredSize(new Dimension(40, 40));
					filledSeat.setActionCommand(Events.FILL.toString());
					filledSeat.setFocusable(false);
					filledSeat.setOpaque(false);
					filledSeat.setContentAreaFilled(false);
					filledSeat.setBorderPainted(false);
					filledSeat.setBackground(Color.red);
					filledSeat.setIcon(new ImageIcon(new ImageIcon("src/images/filledSeat.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
					filledSeat.setName(i + "-" + j);
					filledSeat.addActionListener(control);
					add(filledSeat);
				}
			}
		}
		repaint();
		revalidate();
	}
	
	public void cleanMatriz() {
		removeAll();
	}
}
