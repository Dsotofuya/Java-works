package view.southpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Data.Constants;

public class SouthPanel extends JPanel{
	private static final long serialVersionUID = 1039521526408885274L;

	private String[] buttonName = {"Games", "Apps", "Movies", "Books"};
	private static final String ICON_PATH = "src/Data/iconFooter";
	private static final String ICON_EXT = ".png";

	public SouthPanel() {
		setBackground(Color.white);
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode(Constants.GREY_COLOR)));
		generateButtons(buttonName);
	}
	
	private void generateButtons(String[] buttonName){
		int i = 0;
		for (String name : buttonName) {
			JButton btn = new JButton(name, new ImageIcon(ICON_PATH + i + ICON_EXT));
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
			btn.setBorder(BorderFactory.createEmptyBorder());
			btn.setBackground(Color.WHITE);
			btn.setFocusable(false);
			btn.setForeground(Color.decode(Constants.GREY_COLOR));
			btn.setPreferredSize(new Dimension(80, 38));
			btn.setFont(new Font("Arial", 0, 12));
			add(btn);
			i++;
		}
	}
}
