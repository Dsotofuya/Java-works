package view.left;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Events;
import model.Post;

public class ListPanel extends JPanel{
	private static final long serialVersionUID = 1404751512420172547L;

	private static final String BACKGROUND = "#78BBFF";

	private ActionListener control;
	
	public ListPanel(ActionListener control, ArrayList<Post> postList) {
		this.control = control;
		setPreferredSize(new Dimension(300, postList.size()*30));
		setBackground(Color.decode("#466E80"));
		generateList(control, postList);
	}

	private void generateList(ActionListener control, ArrayList<Post> postList) {
		for (Post post : postList) {
			JButton btn = new JButton(post.getDescription());
			btn.setPreferredSize(new Dimension(310, 30));
			btn.setFocusable(false);
			btn.setBackground(Color.decode(BACKGROUND));
			btn.setForeground(Color.white);
			btn.setBorder(BorderFactory.createLineBorder(Color.white));
			btn.setName(String.valueOf(post.getId()));
			btn.setActionCommand(Events.FIND.toString());
			btn.addActionListener(control);
			add(btn);
		}
	}
	
	public void updateList(ArrayList<Post> postList) {
		removeAll();
		generateList(control, postList);
		repaint();
		revalidate();
	}
}
