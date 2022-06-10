package view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Constants.Constants;
import Control.Controller;

public class navPanel extends JPanel {
	private static final long serialVersionUID = -5345075238800940677L;

	private JComboBox<String> episodeCB;
	
	public navPanel(Controller control) {
		
			episodeCB = new JComboBox<>();
			episodeCB.setPreferredSize(new Dimension(540, 25));
			episodeCB.setActionCommand(Constants.EPISODESELECTED);
			episodeCB.addActionListener(control);
			add(episodeCB);
			
		}
		
		public void fillCB(ArrayList<String> episodeList) {
			for (String episodeName : episodeList) {
				episodeCB.addItem(episodeName);
			}
		}
		
		public String getText() {
			return (String) episodeCB.getSelectedItem();
		}
}