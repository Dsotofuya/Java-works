package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Constants.Constants;
import model.Synonym;
import model.SynonymManager;
import view.addSynonym.AddSynonymFrame;
import view.addWord.AddWordDialog;
import view.mainWindow.ManiFrame;

public class Controller implements ActionListener {

	// www.latascadenxela.es/2008/07/java-y-xml-sax.html
	// https://wwww.journaldev.com/892/how-to-write-xml-file-in-java-using-java-stax-api
	// https://wwww.tutorialspoint.com/java_xml/java_sax_modify_document.htm

	private SynonymManager synonymManager;
	private ManiFrame maniFrame;
	private AddWordDialog wordDialog;
	private AddSynonymFrame synonymFrame;
	private int cunt = 0;

	public Controller() {
		synonymFrame = new AddSynonymFrame(this);
		synonymManager = new SynonymManager();
		maniFrame = new ManiFrame(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase(Constants.FIND)) {
			showSynonym();
			countSynonyms();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.AFTER)) {
			afterSynonym();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.NEXT)) {
			nextSynonym();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.ADDWORD)) {
			showDialogToAddWord();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.ADDWORDTOLIST)) {
			addDataToTable();
			wordDialog.clean();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.SAVE)) {
			saveDataToArray();
			synonymManager.writeXml();
			wordDialog.dispose();
			wordDialog.clean();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.CANCEL)) {
			wordDialog.dispose();
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.ADDSYNONYM)) {
			synonymFrame.fillBox(returnWordsToCombo());
			synonymFrame.setVisible(true);
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.ITEMSELECTED)) {
			synonymFrame.fillTable(synonymManager.findSynonyms(synonymFrame.getWordCombo()).getWord());
		}
		if (e.getActionCommand().equalsIgnoreCase(Constants.ADDSYNONYMTOLIST)) {
			addSynonym();
			synonymFrame.clean();
		}if (e.getActionCommand().equalsIgnoreCase(Constants.SAVESYNONYM)) {
			synonymFrame.dispose();
			synonymManager.writeXml();
		}if (e.getActionCommand().equalsIgnoreCase(Constants.CANCELSYNONYM)) {
			synonymFrame.dispose();
		}
	}

	private void addSynonym() {
		synonymManager.findSynonyms(synonymFrame.getWordCombo()).addWord(synonymFrame.getInputedText());
		synonymFrame.fillTable(synonymManager.findSynonyms(synonymFrame.getWordCombo()).getWord());
	}
	
	private void addDataToTable() {
		synonymManager.addWord(wordDialog.getInputedText());
		wordDialog.fillTable(synonymManager.getSynonym().getWord());
	}

	private void saveDataToArray() {
		synonymManager.addSynonym(synonymManager.getSynonym());
		synonymManager.setNewSynonym();
		ArrayList<Synonym> xd = synonymManager.getSynonymsList();
		for (Synonym a : xd) {
			System.out.println(a.getWord().toString());
		}
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
			if (cunt == varToShow.getWord().size() - 1) {
				maniFrame.disableButtonNext();
			}
			maniFrame.enableButtonAfter();
			maniFrame.setText(varToShow.getWord().get(cunt));
		}
	}

	private ArrayList<String> returnWordsToCombo() {
		ArrayList<String> words = new ArrayList<>();
		for (Synonym synonym : synonymManager.getSynonymsList()) {
			words.add(synonym.getWord().get(0));
		}
		return words;
	}

	private Synonym findSynonym() {
		return synonymManager.findSynonyms(maniFrame.getSynonym());
	}

	private void countSynonyms() {
		maniFrame.setNumber(String.valueOf(findSynonym().getWord().size()));
	}

	public static void main(String[] args) {
		new Controller();
	}
}
