/**
 * 
 */
package view.addSynonym;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import Control.Controller;

public class AddSynonymFrame extends JFrame{
	private static final long serialVersionUID = -1065131544900568838L;
	
	private SynonymAddPanel synonymAddPanel;
	private SaveCancelbuttonsOfSynonymPanel buttonsPanel;
	public AddSynonymFrame(Controller control) {
		super("Add Synonym");
			setSize(450, 300);
			setLocationRelativeTo(null);
			synonymAddPanel = new SynonymAddPanel(control);
			add(synonymAddPanel, BorderLayout.CENTER);
			buttonsPanel = new SaveCancelbuttonsOfSynonymPanel(control);
			add(buttonsPanel, BorderLayout.SOUTH);
		}
		
		public void fillTable(ArrayList<String> list) {
			synonymAddPanel.fillTable(list);
		}
		
		public void fillBox(ArrayList<String> words) {
			synonymAddPanel.fillBox(words);
		}
		
		public String getWordCombo() {
			return synonymAddPanel.getWordCombo();
		}
		
		public void clean() {
			synonymAddPanel.clean();
		}
		
		public String getInputedText() {
			return synonymAddPanel.getWordText();
		}

}
