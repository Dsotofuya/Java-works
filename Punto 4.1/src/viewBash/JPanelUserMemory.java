package viewBash;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelsBatchMono.Description;

public class JPanelUserMemory extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public JPanelUserMemory() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	public void renderjPaneluserMemory(ArrayList<Description> descriptionsUsersMemory) {
		this.removeAll();
		if (descriptionsUsersMemory.size() > 0) {
			this.add(new JLabel("         Memoria de Usuario           "));
			this.add(new JLabel("Programa:  " + descriptionsUsersMemory.get(0).getOwner()));
		}
		
		for (Iterator<Description> iterator = descriptionsUsersMemory.iterator(); iterator.hasNext();) {
			Description description = (Description) iterator.next();
			this.add(new JLabel(description.getSentence().getEnumSentence().name()));
		}
		revalidate();
	}

}
