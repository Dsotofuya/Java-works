package view.addWord;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Constants.Constants;
import Control.Controller;

public class WordPanel extends JPanel{
	private static final long serialVersionUID = 6248508549362835559L;
	
	private GridBagConstraints gbc;
	private JTextField inputWord;
	private JTable dates;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JButton addWord;
	
	public WordPanel(Controller control) {
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());	
		generateBasicGrid(gbc);
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 5, 0);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		inputWord = new JTextField();
		inputWord.setPreferredSize(new Dimension(280, 20));
		add(inputWord, gbc);
		gbc.gridx = 3;
		gbc.gridwidth = 4;
		addWord = new JButton(Constants.ADDWORDBTNTOLIST);
		addWord.setActionCommand(Constants.ADDWORDTOLIST);
		addWord.addActionListener(control);
		add(addWord, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 30, 0, 0);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new Object[] {"Synonyms"});
		dates = new JTable(tableModel);
		scrollPane = new JScrollPane(dates);
		scrollPane.setPreferredSize(new Dimension(280, 150));
		add(scrollPane, gbc);
	}
	
	public void fillTable(ArrayList<String> listWord) {
		tableModel.setRowCount(0);
		for (int j = 0; j < listWord.size(); j++) {
		tableModel.addRow(new Object[] {listWord.get(j)});
		}
		repaint();
	}
	
	public String getWordText() {
		return inputWord.getText();
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 10; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 2; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}
