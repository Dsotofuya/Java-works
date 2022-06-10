package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelNorth extends JPanel{
	
	private JLabel label, emptyLabel, emptyLabel2, emptyLabel3, emptyLabel4;

	public JPanelNorth(){
		setLayout(new GridLayout(1,3));
		setBackground(Color.decode("#0b5ba1"));
		setVisible(true);
		init();
	}
	
	public void init(){
		
		emptyLabel  = new JLabel();
		add(emptyLabel);
		/*emptyLabel3  = new JLabel();
		add(emptyLabel3);*/
		ImageIcon main = new ImageIcon(getClass().getResource("/images/lg-cinepolis.png"));
		label = new JLabel();
		label.setIcon(main);
		add(label);
		/*emptyLabel4  = new JLabel();
		add(emptyLabel4);*/
		emptyLabel2  = new JLabel();
		add(emptyLabel2);
		
	}
	
	
}
