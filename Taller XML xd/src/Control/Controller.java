package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Constants;
import model.Synonym;
import model.SynonymManager;
import view.addWord.AddWordDialog;
import view.mainWindow.ManiFrame;

public class Controller implements ActionListener {

	//Falta, jdialog añadir palabra, añadir sinonimo mediante frame,
	// sobrescribir xml
	// www.latascadenxela.es/2008/07/java-y-xml-sax.html
	// https://wwww.journaldev.com/892/how-to-write-xml-file-in-java-using-java-stax-api
	// https://wwww.tutorialspoint.com/java_xml/java_sax_modify_document.htm
	
	private SynonymManager synonymManager;
	private ManiFrame maniFrame;
	private AddWordDialog wordDialog;
	private int cunt = 0;
	
	public Controller() {
	synonymManager = new SynonymManager();
	maniFrame = new ManiFrame(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase(Constants.FIND) ) {
			showSynonym();
			countSynonyms();
		}if (e.getActionCommand().equalsIgnoreCase(Constants.AFTER)) {
			afterSynonym();
		}if (e.getActionCommand().equalsIgnoreCase(Constants.NEXT)) {
			nextSynonym();
		}if (e.getActionCommand().equalsIgnoreCase(Constants.ADDWORD)) {
			showDialogToAddWord();	
		}if (e.getActionCommand().equalsIgnoreCase(Constants.ADDWORDTOLIST)) {
			addDatesToTable();
		}if (e.getActionCommand().equalsIgnoreCase(Constants.ADDSYNONYM)) {
//			showFrameToAddSynonyms();
		}
	}
	
	private void addDatesToTable() {
		System.out.println("xdxd");
			synonymManager.addWord(wordDialog.getInputedText());
			System.out.println(wordDialog.getInputedText());
			wordDialog.fillTable(synonymManager.getSynonym().getWord());
			System.out.println(synonymManager.getSynonym().getWord().toString());
	}

	private void showDialogToAddWord() {
		wordDialog = new AddWordDialog(this); 
		wordDialog.setVisible(true);
	}

	private void showSynonym() {
		maniFrame.disableButtonAfter();
		maniFrame.enableButtonNext();
		maniFrame.setText(findSynonym().getWord().get(cunt));
	}
	
	private void afterSynonym() {
		Synonym var = findSynonym();
		if (cunt <= var.getWord().size()) {
			cunt--;
			maniFrame.setText(var.getWord().get(cunt));
			maniFrame.enableButtonNext();
			if (cunt == 0) {
				maniFrame.disableButtonAfter();
			}
		}
	}
	
	private void nextSynonym() {
		Synonym varToShow = findSynonym();
		if (cunt >= 0 && cunt <= varToShow.getWord().size()) {
			cunt++;
			System.out.println(cunt);
			if (cunt == varToShow.getWord().size()-1) {				
				maniFrame.disableButtonNext();
			}
			maniFrame.enableButtonAfter();
			maniFrame.setText(varToShow.getWord().get(cunt));
		}  
	}
	
	private Synonym findSynonym() {
		return synonymManager.findSynonyms(maniFrame.getSynonym());
	}
	
	
	private void countSynonyms(){
		maniFrame.setNumber(String.valueOf(findSynonym().getWord().size()));
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
