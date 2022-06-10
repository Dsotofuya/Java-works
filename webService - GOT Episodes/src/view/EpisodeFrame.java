package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import Control.Controller;

public class EpisodeFrame extends JFrame {
	private static final long serialVersionUID = -3726303371715015913L;
	
	private navPanel navPanel;
	private infoPanel infoPanel;
	
	public EpisodeFrame(Controller control) {
		super("GOT Episodes Info");
		navPanel = new navPanel(control);
		add(navPanel, BorderLayout.NORTH);
		infoPanel = new infoPanel();
		add(infoPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600, 250);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void fillPanel(String id, String name, String season, String number, String airdate, String summary) {
		infoPanel.fillPanel(id, name, season, number, airdate, summary);
		infoPanel.repaint();
		infoPanel.revalidate();
	}
	 
	public void fillCB(ArrayList<String> episodeList) {
		navPanel.fillCB(episodeList);
	}
	
	public String getText() {
		return navPanel.getText();
	}
}
