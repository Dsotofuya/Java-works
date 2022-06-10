package view.addSynonym;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Constants.Constants;
import Control.Controller;

public class SynonymAddPanel extends JPanel{
	private static final long serialVersionUID = 6248508549362835559L;
	
	private GridBagConstraints gbc;
	private JTextField inputWord;
	private JTable dates;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JButton addWord;
	private JComboBox<String> listSynonyms;
	
	public SynonymAddPanel(Controller control) {
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());	
		generateBasicGrid(gbc);
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 5, 0);
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		listSynonyms = new  JComboBox<>();
		listSynonyms.setActionCommand(Constants.ITEMSELECTED);
		listSynonyms.addActionListener(control);
		add(listSynonyms, gbc);
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.weightx = 100;
		inputWord = new JTextField();
		inputWord.setPreferredSize(new Dimension(200, 20));
		add(inputWord, gbc);
		gbc.gridx = 3;
		gbc.gridwidth = 2;
		addWord = new JButton(Constants.ADDSYNONYMBTNTOLIST);
		addWord.setActionCommand(Constants.ADDSYNONYMTOLIST);
		addWord.addActionListener(control);
		add(addWord, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 0, 0, 0);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new Object[] {"Words"});
		dates = new JTable(tableModel);
		scrollPane = new JScrollPane(dates);
		scrollPane.setPreferredSize(new Dimension(280, 160));
		add(scrollPane, gbc);
	}
	
	
	
	public void fillBox(ArrayList<String> words) {
		for (String string : words) {
			listSynonyms.addItem(string);
		}
	}
	
	public void fillTable(ArrayList<String> listWord) {
		tableModel.setRowCount(0);
		for (int j = 0; j < listWord.size(); j++) {
		tableModel.addRow(new Object[] {listWord.get(j)});
		}
		repaint();
	}
	
	public String getWordCombo() {
		return (String) listSynonyms.getSelectedItem();
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
		for (int i = 0; i < 3; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}

	public void clean() {
		inputWord.setText("");
	}
}
