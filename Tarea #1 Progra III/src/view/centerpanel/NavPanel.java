package view.centerpanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Data.Constants;

public class NavPanel extends JPanel{
	
	private static final long serialVersionUID = 6753056291905526403L;
	private String[] buttonName = {"For you", "Top Charts", "Premium", "Categories"};
	
	public NavPanel() {
		setBackground(Color.white);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Constants.GREY_COLOR)));
		generateButtons(buttonName);
	}
	
	public void generateButtons(String[] buttonName){
		for (String name : buttonName) {
			JButton btn = new JButton(name);
			btn.setBackground(Color.WHITE);
			btn.setForeground(Color.decode(Constants.GREY_COLOR));
			btn.setFont(new Font("Arial", 0, 13));
			btn.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode(Constants.GREY_COLOR)));
			add(btn);
		}
	}
}
