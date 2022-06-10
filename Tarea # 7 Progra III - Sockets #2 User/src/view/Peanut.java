package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Post;

public class Peanut extends JFrame{
	private static final long serialVersionUID = 105533001847262676L;

	private static final String APP_NAME = "L0SS";
	private static final String ICON_PATH = "src/data/L0SSIcon.png";
	private static final String BACKGROUND = "#466E80";

	private LeftPanel left;
	private RightPanel right;
	
	public Peanut(ActionListener control, ArrayList<Post> postList) {
		super(APP_NAME);
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setSize(new Dimension(850, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		left = new LeftPanel(control, postList);
		left.setBackground(Color.decode(BACKGROUND));
		add(left, BorderLayout.WEST);
		right = new RightPanel(control);
		right.setBackground(Color.decode(BACKGROUND));
		add(right, BorderLayout.EAST);
		setResizable(false);
		setVisible(true);
	}
	
	public LeftPanel getLeft() {
		return left;
	}
	
	public RightPanel getRight() {
		return right;
	}
}
