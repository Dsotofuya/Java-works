package view.centerpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.App;

public class CenterPanel extends JPanel{
	private static final long serialVersionUID = -4293313589774876280L;

	private NavPanel navPanel;
	private AppsPanel appsPanel;
	
	public CenterPanel(ArrayList<App> appList) {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		navPanel = new NavPanel();
		add(navPanel, BorderLayout.NORTH);
		appsPanel = new AppsPanel(appList);
		add(appsPanel, BorderLayout.CENTER);
	}
}
