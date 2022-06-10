package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.MalformedURLException;

import javax.swing.JPanel;

import view.center.LeftPanel;
import view.center.RightPanel;

public class CenterPanel  extends JPanel{
	private static final long serialVersionUID = 8006391520119358179L;
	
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	
	public CenterPanel() throws MalformedURLException {
		setLayout(new BorderLayout());
		leftPanel = new LeftPanel();
		leftPanel.setPreferredSize(new Dimension(460, 215));
		add(leftPanel, BorderLayout.WEST);
		rightPanel = new RightPanel();
		add(rightPanel, BorderLayout.CENTER);
	}
	
	public void repaintAll() {
		leftPanel.repaint();
		leftPanel.revalidate();
		rightPanel.repaint();
		rightPanel.revalidate();
		repaint();
		revalidate();
	}
	
	public void loadImage(String url) throws MalformedURLException  {
		leftPanel.loadImage(url);
	}
	
	public void loadDescription(String desciption)  {
		rightPanel.loadDescription(desciption);
	}
	
	public void loadminimumReqs(String loadminimumReqs)  {
		rightPanel.loadminimumReqs(loadminimumReqs);
	}
	
}
