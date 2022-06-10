package viewBash;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelsBatchMono.Description;

public class JPanelMonitor extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public JPanelMonitor() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void renderJPanelMonitor(ArrayList<Description> descriptionsMonitor) {
		 removeAll();
		if(descriptionsMonitor.size() > 0) {
			this.add(new JLabel("        Monitor        "),CENTER_ALIGNMENT);
		  this.add(new JLabel("Programa:   " + descriptionsMonitor.get(0).getOwner()));
		}
		
		for (Iterator<Description> iterator = descriptionsMonitor.iterator(); iterator.hasNext();) {
			Description description = (Description) iterator.next();
			this.add(new JLabel(description.getSentence().getEnumSentence().name()));
		}
		revalidate();
	}

}
