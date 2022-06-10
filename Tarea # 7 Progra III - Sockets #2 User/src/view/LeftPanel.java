package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.Events;
import model.Post;
import view.left.ListPanel;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = -1350706169921659518L;

	private static final String ADD_POST = "Add Post";
	private static final String UPDATE = "Update";
	private static final String BACKGROUD_COMPONENT = "#78BBFF";

	private JButton addPost;
	private JButton updateList;
	private ListPanel listPanel;
	
	public LeftPanel(ActionListener control, ArrayList<Post> postList) {
		setPreferredSize(new Dimension(350, 500));
		
		addPost = new JButton(ADD_POST);
		addPost.setPreferredSize(new Dimension(125, 30));
		addPost.setFocusable(false);
		addPost.setBackground(Color.decode(BACKGROUD_COMPONENT));
		addPost.setForeground(Color.white);
		addPost.setBorder(BorderFactory.createLineBorder(Color.white));
		addPost.setActionCommand(Events.ADD.toString());
		addPost.addActionListener(control);
		add(addPost);
		
		updateList = new JButton(UPDATE);
		updateList.setPreferredSize(new Dimension(125, 30));
		updateList.setFocusable(false);
		updateList.setBackground(Color.decode(BACKGROUD_COMPONENT));
		updateList.setForeground(Color.white);
		updateList.setBorder(BorderFactory.createLineBorder(Color.white));
		updateList.setActionCommand(Events.UPDATE.toString());
		updateList.addActionListener(control);
		add(updateList);
		
		listPanel = new ListPanel(control, postList);
		JScrollPane scrollPane = new JScrollPane(listPanel);
		scrollPane.setPreferredSize(new Dimension(300, 410));
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane);
	}
	
	public ListPanel getListPanel() {
		return listPanel;
	} 
}
