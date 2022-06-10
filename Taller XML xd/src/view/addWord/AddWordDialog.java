package view.addWord;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JDialog;

import Control.Controller;

public class AddWordDialog extends JDialog {
	private static final long serialVersionUID = -6833539909211883945L;

	private WordPanel wordPanel;
	private SaveCancelbuttonsPanel buttonsPanel;
	
	public AddWordDialog(Controller control) {
		setTitle("Add Word");
		setSize(400, 275);
		setLocationRelativeTo(null);
		wordPanel = new WordPanel(control);
		add(wordPanel, BorderLayout.CENTER);
		buttonsPanel = new SaveCancelbuttonsPanel(control);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void fillTable(ArrayList<String> list) {
		wordPanel.fillTable(list);
	}
	
	public String getInputedText() {
		return wordPanel.getWordText();
	}
	
	public static void main(String[] args) {
		new AddWordDialog(null).setVisible(true);;
		
	}
}
