package view.northpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.Constants;

public class FindBarPanel extends JPanel{
	private static final String ICON_MENU = "src/Data/menuIcon.png";
	private static final long serialVersionUID = -409671107707736843L;
	private static final String ICON_FIND_BY_VOICE = "src/Data/iconFinder.png";
	
	public FindBarPanel() {
		setBorder(BorderFactory.createLineBorder(Color.decode(Constants.GREY_COLOR)));
		setBackground(Color.white);
		JButton menuBtn = new JButton(new ImageIcon(
				new ImageIcon(ICON_MENU).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		menuBtn.setBorder(BorderFactory.createEmptyBorder());
		menuBtn.setBackground(Color.white);
		add(menuBtn);
		
		JTextField findTxtF = new JTextField();
		findTxtF.setFont(new Font("Arial", 0, 12));
		findTxtF.setForeground(Color.decode(Constants.GREY_COLOR));
		findTxtF.setText("Search for apps & games");
		findTxtF.setBorder(BorderFactory.createEmptyBorder());
		findTxtF.setPreferredSize(new Dimension(200, 20));
		findTxtF.setHorizontalAlignment(JTextField.LEFT);
		add(findTxtF);
		
		JButton findByVoiceBtn = new JButton(new ImageIcon(
				new ImageIcon(ICON_FIND_BY_VOICE).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		findByVoiceBtn.setBorder(BorderFactory.createEmptyBorder());
		findByVoiceBtn.setBackground(Color.white);
		add(findByVoiceBtn);
	}
}
