package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.nio.ByteOrder;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Person;


public class JframeMain extends JFrame {

	private static final String TITTLE = "CINEPOLIS - recervas";
	private JPanelSouth southPanel;
	private JPanelNorth northPanel;
	private JPanelMidRight jPanelMidRight;
	private JPanelMidLeft jPanelMidLeft;
	private Events events;
	
	public JframeMain(){
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////	
		
	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/favicon.png"));
    setIconImage(icon);
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////// Setbounds
    
	setTitle(TITTLE);
	setResizable(false);
	setSize(new Dimension(750, 500));
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	getContentPane().setBackground(Color.decode("#0b5ba1"));
	setLayout(new BorderLayout());
	northPanel = new JPanelNorth(); 
	add(northPanel, BorderLayout.NORTH);
	southPanel = new JPanelSouth(); 
	add(southPanel, BorderLayout.SOUTH); 
	jPanelMidRight = new JPanelMidRight(this);
	add(jPanelMidRight, BorderLayout.EAST);
	jPanelMidLeft = new JPanelMidLeft(this);
	add(jPanelMidLeft, BorderLayout.CENTER);
	setVisible(true);
	}
	
	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events; }
	
	
	public JPanelMidRight getjPanelMid() {
		return jPanelMidRight;
	}

	public void setjPanelMid(JPanelMidRight jPanelMid) {
		this.jPanelMidRight = jPanelMid;
	}

	public Person makePerson() {
		return jPanelMidLeft.makePerson();
	}
	
	public static void main(String[] args) {
		new JframeMain();
	}
}
