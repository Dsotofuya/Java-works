package view;

import java.awt.GridLayout;

import javax.swing.JFrame;

import control.Control;

public class traductor_Frame extends JFrame{
	private static final long serialVersionUID = -1201113290594270983L;
	
	private traduccionPanel traduccionPanel;
	private contadorPanel contadorPanel;
	private addPanel addPanel;
	
	public traductor_Frame(Control control) {
	super("Mi Traductor");
	setLayout(new GridLayout(3,1));
	traduccionPanel = new traduccionPanel(control);
	add(traduccionPanel);
	contadorPanel = new contadorPanel();
	add(contadorPanel);
	addPanel = new addPanel(control);
	add(addPanel);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setResizable(false);
	setSize(400,200);
	setVisible(true);
	}
	
	public String getWordSpanishText() {
		return addPanel.getWordSpanishText();
	}
	public String getWordEnglishText() {
		return addPanel.getWordEnglishText();
	}
	public String geFrenchText() {
		return addPanel.geFrenchText();
	}
	
	public String getWordText() {
		return traduccionPanel.getWordText();
	}
	
	public void setValueText(String value){
		traduccionPanel.setValueText(value);
	}
	
	public void setInglesInfoText(String value){
		contadorPanel.setInglesInfoText(value);
	}
	public void setFrancesText(String value){
		contadorPanel.setFrancesText(value);

	}

	
}
