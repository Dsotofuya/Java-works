package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.Events;

public class CenterSouthPanel extends JPanel {
	private static final long serialVersionUID = -7031900580507968553L;

	private static final String BACKGROUND = "#B3B3B3";
	private static final String CARD_BACKGROUND = "#D9D9D9";

	private ActionListener control;

	public CenterSouthPanel(ActionListener control) {
		this.control = control;
		setBackground(Color.decode(BACKGROUND));
	}

	public void addCard(BufferedImage image, String name) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(CARD_BACKGROUND));
		panel.setPreferredSize(new Dimension(300, 240));
		JLabel xd = new JLabel();
		if (image != null) {
			xd.setIcon(new ImageIcon(image));
		}
		panel.add(xd);
		JButton undo = new JButton("Undo");
		undo.setPreferredSize(new Dimension(100, 20));
		undo.setName(name);
		undo.setActionCommand(Events.UNDO.toString());
		undo.addActionListener(control);
		panel.add(undo);
		add(panel);
		repaint();
		revalidate();
	}
}
