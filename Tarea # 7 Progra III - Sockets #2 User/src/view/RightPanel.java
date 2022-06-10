package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.right.PostPanel;

public class RightPanel extends JPanel {
	private static final String NO_NOTIFICATIONS = "No notifications...";
	private static final long serialVersionUID = 2674306017192664607L;

	private JLabel notify;
	private PostPanel postPanel;
	
	public RightPanel(ActionListener control) {
		setPreferredSize(new Dimension(500, 500));
		notify = new JLabel(NO_NOTIFICATIONS, SwingConstants.CENTER);
		notify.setPreferredSize(new Dimension(400, 40));
		notify.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		notify.setForeground(Color.WHITE);
		add(notify);
		
		postPanel = new PostPanel(control);
		postPanel.setBorder(BorderFactory.createLineBorder(Color.white));
		add(postPanel);
	}
	
	public PostPanel getPostPanel() {
		return postPanel;
	}
	
	public void setNotifyText(String text) {
		notify.setText(text);
	}
}
