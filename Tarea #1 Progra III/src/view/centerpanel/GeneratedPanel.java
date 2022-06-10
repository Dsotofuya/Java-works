package view.centerpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Data.Constants;
import model.App;

public class GeneratedPanel extends JPanel {
	private static final long serialVersionUID = 2066234593412475459L;

	private static final String ICON_EXT = ".jpg";

	public GeneratedPanel(ArrayList<App> appList) {
		
		setBackground(Color.WHITE);
		for (App app : appList) {
			structureApp(app.getName(), app.getImage(), app.getSize());
		}
		structureApp("Pubg", "", 2);
	}

	public void structureApp(String name, String image, int size) {
		if (!image.isEmpty() || !image.equalsIgnoreCase("")) {
			generateApp(name, image, size);
		} else {
			generateApp(name, "src/Data/product", size);
		}
	}

	public void generateApp(String name, String image, int size) {
		JButton btn = new JButton(name + " " + size, new ImageIcon(
				new ImageIcon(image + ICON_EXT).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn.setBorder(BorderFactory.createEmptyBorder());
		btn.setBackground(Color.WHITE);
		btn.setFocusable(false);
		btn.setForeground(Color.decode(Constants.GREY_COLOR));
		btn.setPreferredSize(new Dimension(100, 100));
		btn.setFont(new Font("Arial", 0, 12));
		add(btn);
	}
}