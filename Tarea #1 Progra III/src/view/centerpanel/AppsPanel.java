package view.centerpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.App;

public class AppsPanel extends JPanel{
	private static final long serialVersionUID = -7748640207793122840L;

	private GeneratedPanel generatedPanel;
	
	public AppsPanel(ArrayList<App> appList) {
		setBackground(Color.WHITE);
		generatedPanel = new GeneratedPanel(appList);
		JScrollPane scrollPane = new JScrollPane(generatedPanel);
		scrollPane.setPreferredSize(new Dimension(340, 125));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.white);
		add(scrollPane);
	}
}
