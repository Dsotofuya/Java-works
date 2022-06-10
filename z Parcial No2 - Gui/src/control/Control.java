package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import costants.Costants;
import model.dao.controlPalabra;
import view.traductor_Frame;

public class Control implements ActionListener {

	private traductor_Frame traductorFrame;
	private controlPalabra controlPalabra;
	
	public Control() {
		traductorFrame = new traductor_Frame(this);
		controlPalabra = new controlPalabra();
		init();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (Costants.ADD == arg0.getActionCommand()) {
			System.out.println(traductorFrame.getWordSpanishText());
			System.out.println(traductorFrame.getWordEnglishText());
			System.out.println(traductorFrame.geFrenchText());
			controlPalabra.addNewWord(traductorFrame.getWordSpanishText(), traductorFrame.getWordEnglishText(), traductorFrame.geFrenchText()); 
			init();
		}
		if (Costants.TRASLATE_ENGLISH == arg0.getActionCommand()) {
			traductorFrame.setValueText(controlPalabra.buscarPalabraIngles(traductorFrame.getWordText()));
		}
		if (Costants.TRASLATE_FRENCH == arg0.getActionCommand()) {
			traductorFrame.setValueText(controlPalabra.buscarPalabraFrances(traductorFrame.getWordText()));
		}
	}
	
	private void init() {
		traductorFrame.setInglesInfoText(String.valueOf(controlPalabra.nEnglishWords()));
		traductorFrame.setFrancesText(String.valueOf(controlPalabra.nFrenchhWords()));

	}
	
	public static void main(String[] args) {
		new Control();
	}

}
