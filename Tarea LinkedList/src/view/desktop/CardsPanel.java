package view.desktop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Node;
import model.ProfileList;

public class CardsPanel extends JPanel {
	private static final long serialVersionUID = -7031900580507968553L;

	private static final String BACKGROUND = "#B3B3B3";
	private static final String CARD_BACKGROUND = "#D9D9D9";

	public CardsPanel() {
		setBackground(Color.decode(BACKGROUND));
	}

	public void graphicCards(ProfileList profileList) {
		removeAll();
		Node actual = profileList.getFirst();
		while (actual != null) {
			addCard(actual.getData().getId(), actual.getData().getName(), actual.getData().getImage(),
					actual.getData().getLikes());
			actual = actual.getNext();
		}
		repaint();
	}

	private void addCard(int id, String name, BufferedImage image, int likes) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(CARD_BACKGROUND));
		panel.setPreferredSize(new Dimension(250, 290));
		JLabel idName = new JLabel(id + ". " + name);
		idName.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(idName);
		JLabel xd = new JLabel(new ImageIcon(image));
		panel.add(xd);
		JLabel like = new JLabel("Likes: " + likes);
		like.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(like);
		add(panel);
	}
}
