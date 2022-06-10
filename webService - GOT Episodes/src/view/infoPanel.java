package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class infoPanel extends JPanel{
	private static final long serialVersionUID = -3271615673762634205L;

	private JLabel id;
	private JLabel name;
	private JLabel season;
	private JLabel number;
	private JLabel airdate;
	private JTextArea summary;
	private GridBagConstraints gbc;
	
	public infoPanel(){
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 5, 0);
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		id = new JLabel();
		add(id, gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		name = new JLabel();
		add(name, gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		season = new JLabel();
		add(season, gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		number = new JLabel();
		add(number, gbc);
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		airdate = new JLabel();
		add(airdate, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		summary = new JTextArea();
		summary.setOpaque(false);
		summary.setLineWrap(true);
		summary.setEditable(false);
		add(summary, gbc);
		
		
	}
	
	public void fillPanel(String id, String name, String season, String number, String airdate, String summary) {
		this.id.setText("id: " + id);
		this.name.setText("name: " +name);
		this.season.setText("Season:  "+season);
		this.number.setText("Number:  " +number);
		this.airdate.setText("Airdate:  "+airdate);
		this.summary.setText("Summary:  "+summary);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 10; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 3; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}
