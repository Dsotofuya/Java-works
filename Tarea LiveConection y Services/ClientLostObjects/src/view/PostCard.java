package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import models.Post;

public class PostCard extends JPanel{

	private static final long serialVersionUID = 1L;

	public PostCard(Post post) {
		setBorder(new RoundedBorder(15));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		JLabel titleLabel = new JLabel(post.getTitle());
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		titleLabel.setBorder(new RoundedBorder(20));
		titleLabel.setFont(new Font("Raleway", Font.PLAIN, 29));
		add(titleLabel);
		
		JLabel descriptionLabel = new JLabel(post.getDescription());
		System.out.println(post.getImage());
		descriptionLabel.setAlignmentX(CENTER_ALIGNMENT);
//		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setFont(ConstantsGUI.ROBOTO_FONT);
		descriptionLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
//		descriptionLabel.setBorder(new RoundedBorder(20));
		add(descriptionLabel);
		
		ImageIcon imageIcon = new ImageIcon(post.getImage());
		JLabel imageJlabel = new JLabel(imageIcon);
		System.out.println(post.getImage());
		imageJlabel.setAlignmentX(CENTER_ALIGNMENT);
//		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageJlabel.setFont(ConstantsGUI.ROBOTO_FONT);
		imageJlabel.setBorder(new RoundedBorder(50));
		add(imageJlabel);
		
		JPanel contactPanel = new JPanel();
		contactPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
		contactPanel.setLayout(new GridLayout(1, 2));
		contactPanel.setBackground(Color.WHITE);
		
		JLabel contactLb = new JLabel(String.valueOf(post.getContactNumber()));
		contactLb.setFont(ConstantsGUI.ROBOTO_FONT);
//		contactLb.setAlignmentX(CENTER_ALIGNMENT);
//		contactLb.setHorizontalAlignment(SwingConstants.CENTER);
//		contactLb.setBorder(new RoundedBorder(20));
		contactLb.setBorder(BorderFactory.createEmptyBorder(20, 680, 0, 0));
		contactPanel.add(contactLb);
		
		JButton contactBtn = new JButton(new ImageIcon(getClass().getResource("/img/message.png")));
		contactBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 500));
		contactPanel.add(contactBtn);
		add(contactPanel);
		setIUManager();
	}
	
	private void setIUManager() {
		UIManager.put("Border.background", Color.WHITE);
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("Label.cursor", new Cursor(Cursor.HAND_CURSOR));
		UIManager.put("TextField.border", new RoundedBorder(15));
		UIManager.put("Button.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Button.foreground", Color.BLACK);
	}
}
