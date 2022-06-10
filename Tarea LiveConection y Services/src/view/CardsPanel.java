package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.User;

public class CardsPanel extends JPanel {
	private static final long serialVersionUID = -1210966928811455084L;

	private static final String BACKGROUND = "#FFF5B3";

	public CardsPanel() {
		setBackground(Color.decode(BACKGROUND));
	}

	public void fill(ArrayList<User> userList) throws MalformedURLException {
		setPreferredSize(new Dimension(400, userList.size() * 28));
		for (User user : userList) {
			JLabel card = new JLabel(user.getName(),
					new ImageIcon(
							new ImageIcon(user.getPhoto()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)),
					SwingConstants.LEADING);
			card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			card.setPreferredSize(new Dimension(200, 50));
			add(card);
			repaint();
			revalidate();
		}
	}
}
