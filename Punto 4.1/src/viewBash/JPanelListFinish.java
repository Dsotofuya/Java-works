package viewBash;

import java.awt.Color;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelsBatchMono.Finish;

public class JPanelListFinish extends JPanel{

	private static final long serialVersionUID = 1L;
	
	
	public JPanelListFinish() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void addExcecutionFinish(Finish executionFinish) {
		this.add(new Label(executionFinish.getNameprogram()));
	}
	
	public void renderListFinish(ArrayList<Finish> finishs) {
		System.out.println("render Finish");
		this.removeAll();
		
		String description = "";
		
		if (finishs.size() > 0) {
			this.add(new JLabel("                   Tipos de sentencia del   " + finishs.get(0).getNameprogram()));
		}
		
		int cont = 1;
		for (Iterator<Finish> iterator = finishs.iterator(); iterator.hasNext();) {
			Finish finish = (Finish) iterator.next();
			this.add(new JLabel("Sentencia: " + cont + " - " +  finish.getNameprogram() + "  tipo de sentencia: " + finish.getEnumSentence()));
			cont ++;
		}
		this.revalidate();
	}
		
}
