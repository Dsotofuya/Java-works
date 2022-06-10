package view.right;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PostPanel extends JPanel {
	private static final long serialVersionUID = 6772073292756171402L;

	private static final String BACKGROUND = "#466E80";
	private static final String BUTTON_BACKGROUND = "#78BBFF";
	
	private static final String CONTACT = "Contact";
	
	private JLabel tittle, phone, image;
	private JTextArea description;
	private JButton contact;
	
	public PostPanel(ActionListener control) {
		setPreferredSize(new Dimension(450, 400));
		setBackground(Color.decode(BACKGROUND));
		
		tittle = new JLabel();
		tittle.setPreferredSize(new Dimension(400, 40));
		tittle.setHorizontalAlignment(SwingConstants.CENTER);
		tittle.setBorder(BorderFactory.createLineBorder(Color.white));
		tittle.setForeground(Color.WHITE);
		add(tittle);
		
		phone = new JLabel();
		phone.setPreferredSize(new Dimension(200, 40));
		phone.setBorder(BorderFactory.createLineBorder(Color.white));
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setForeground(Color.WHITE);
		add(phone);
		
		description = new JTextArea();
		description.setForeground(Color.WHITE);
		description.setLineWrap(true);
		description.setEditable(false);
		description.setBackground(Color.decode(BACKGROUND));
		JScrollPane descriptionPane = new JScrollPane(description);
		descriptionPane.setPreferredSize(new Dimension(400, 140));
		descriptionPane.setBorder(BorderFactory.createLineBorder(Color.white));
		descriptionPane.setFocusable(false);
		add(descriptionPane);
		
		image = new JLabel();
		image.setPreferredSize(new Dimension(270, 120));
		image.setBorder(BorderFactory.createLineBorder(Color.white));
		image.setForeground(Color.WHITE);
		add(image);
		
		contact = new JButton(CONTACT);
		contact.setPreferredSize(new Dimension(170, 25));
		contact.setBackground(Color.decode(BUTTON_BACKGROUND));
		contact.setBorder(BorderFactory.createLineBorder(Color.white));
		contact.setForeground(Color.WHITE);
		add(contact);
	}
	
	public void fillPost(String tittle, String photoPhat, String description, long phone) {
		this.tittle.setText(tittle);
		image.setIcon(new ImageIcon(new ImageIcon(photoPhat).getImage().
				getScaledInstance(270, 120, Image.SCALE_SMOOTH)));
		this.description.setText(description);
		this.phone.setText(String.valueOf(phone));
	}
	
}
