package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Control;
import costants.Costants;

public class addPanel extends JPanel {
	private static final long serialVersionUID = -3244756419543064376L;
	
	private JLabel spanish;
	private JLabel english;
	private JLabel french;
	private JLabel empty;
	private JTextField wordSpanish;
	private JTextField wordEnglish;
	private JTextField wordFrench;
	private JButton addFrench;
	private JButton addEnglish;
	
	public addPanel(Control control) {
		setLayout(new GridLayout(3,3));
		spanish = new JLabel("En Español: ");
		add(spanish);
		wordSpanish = new JTextField();
		add(wordSpanish);
		empty = new JLabel();
		add(empty);
		english = new JLabel("En Ingles: ");
		add(english);
		wordEnglish = new JTextField();
		add(wordEnglish);
		addEnglish = new JButton("Adicionar");
		addEnglish.setActionCommand(Costants.ADD);
		addEnglish.addActionListener(control);
		add(addEnglish);
		french = new JLabel("En Frances: ");
		add(french);
		wordFrench = new JTextField();
		add(wordFrench);
		addFrench = new JButton("Adicionar");
		addFrench.setActionCommand(Costants.ADD);
		addFrench.addActionListener(control);
		add(addFrench);
		
	}
	
	public String getWordSpanishText() {
		return wordSpanish.getText();
	}
	public String getWordEnglishText() {
		return wordEnglish.getText();
	}
	public String geFrenchText() {
		return wordFrench.getText();
	}
}
