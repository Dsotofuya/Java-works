package viewBash;

import java.awt.Color;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import DataStructure.MyQueue;
import modelsBatchMono.Execution;


public class JPanelListExecution extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	public JPanelListExecution() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void addExecution(Execution execution) {
		this.add(new Label(execution.getNameProgram()));
	}
	
	public void renderListExecution(MyQueue<Execution> queueExecutions) {
		System.out.println("render executions");
		this.removeAll();
		ArrayList<Execution> arrayList = queueExecutions.getQueue();
		String description = "";
		
		for (Iterator<Execution> iterator = arrayList.iterator(); iterator.hasNext();) {
			Execution execution = (Execution) iterator.next();
			description += "Nombre de programa: " + execution.getNameProgram() + "   /   numero de lotes: " + execution.getProgram().getQueueBatch().size() + "    /   " ;
			
			for (int i = 0; i < execution.getProgram().getQueueBatch().size(); i++) {
				description += " cantidad de sentencias en batch " + (i + 1) + " :  " + execution.getProgram().getQueueBatch().getQueue().get(i).getNumSentences();
				description += "    /     ";
			}
			
			this.add(new JLabel(description));
			description = "";
		}
		this.revalidate();
	}
	
}
