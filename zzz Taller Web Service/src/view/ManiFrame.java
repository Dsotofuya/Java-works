package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import Control.Control;

public class ManiFrame extends JFrame {
	private static final long serialVersionUID = -4089388902583573056L;

	private TopPanel top;
	private CenterPanel centerPanel;
	
	public ManiFrame(Control control) throws MalformedURLException {
		super("Game Specs Searcher");
		setSize(new Dimension(880, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		top = new TopPanel(control);
		add(top, BorderLayout.NORTH);
		centerPanel = new CenterPanel();
		centerPanel.setBounds(10, 10, 10, 10);;
		add(centerPanel, BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
	}

	public void fillCB(ArrayList<String> gameList) {
		top.fillCB(gameList);
	}
	
	public String getText() {
		return top.getText();
	}
	
	public void loadImage(String url) throws MalformedURLException  {
		centerPanel.loadImage(url);
	}
	
	public void loadDescription(String description) {
		centerPanel.loadDescription(description);
	}
	
	public void loadMinimumReqs(String minimumReqs) {
		centerPanel.loadminimumReqs(minimumReqs);
	}
	
	public void repaintAll() {
		centerPanel.repaintAll();
		repaint();
		revalidate();
	}
	
}
