package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.Post;
import models.PostList;


public class PostPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PostPanel() {
		setBackground(Color.white);
	}
	public void refreshProducts(PostList postList, ActionListener listener) {
		setLayout(new GridLayout(postList.size(),1));
		setBackground(Color.PINK);
		removeAll();
		for (Post post : postList) {
			System.out.println("Hola putos" + post);
			System.out.println(post.getDescription());
			add(new PostCard(post));
		}
		repaint(); 
		revalidate();
	}
		
}
