package view.mobile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Events;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = -8426095442710628440L;
	
	private static final String LIKE = "Like";
	private static final String DISLIKE = "Dislike";
	private static final String UPDATE = "Update";
	
	private JButton like, dislike, update;
	
	private static final String CARD_BACKGROUND = "#D9D9D9";
	private static final String LIKE_BACKGROUND = "#BBE897";
	private static final String DISLIKE_BACKGROUND = "#FF6F51";
	
	public ButtonsPanel(ActionListener control) {
		setPreferredSize(new Dimension(250, 50));
		like = new JButton(LIKE);
		like.setActionCommand(Events.LIKE.toString());
		like.addActionListener(control);
		like.setBackground(Color.decode(LIKE_BACKGROUND));
		add(like);
		dislike = new JButton(DISLIKE);
		dislike.setActionCommand(Events.DISLIKE.toString());
		dislike.addActionListener(control);
		dislike.setBackground(Color.decode(DISLIKE_BACKGROUND));
		add(dislike);
		update = new JButton(UPDATE);
		update.setActionCommand(Events.UPDATE_MOBILE.toString());
		update.addActionListener(control);
		update.setBackground(Color.LIGHT_GRAY);
		add(update);
		setBackground(Color.decode(CARD_BACKGROUND));
	}
}
