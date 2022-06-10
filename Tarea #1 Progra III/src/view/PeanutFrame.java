package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.App;
import view.centerpanel.CenterPanel;
import view.northpanel.NorthPanel;
import view.southpanel.SouthPanel;

public class PeanutFrame extends JFrame {
	private static final long serialVersionUID = 2969333141936108744L;
	
	private NorthPanel northPanel;
	private CenterPanel centerPanel;
	private SouthPanel southPanel;

	public PeanutFrame(ArrayList<App> appList) {
		setSize(360, 640);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		northPanel = new NorthPanel();
		add(northPanel, BorderLayout.PAGE_START);
		centerPanel = new CenterPanel(appList);
		add(centerPanel, BorderLayout.CENTER);
		southPanel = new SouthPanel();
		add(southPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
}
