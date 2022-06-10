package viewBash;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelsBatchMono.MaquineBatchMono;

public class JPanelLeft extends JPanel{

	private JPanelListExecution jPanelListExecution;
	private JPanelMainMemory jPanelMainMemory;
	
	private static final long serialVersionUID = 1L;
	
	public JPanelLeft() {
		this.setLayout(new GridLayout(2, 1));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		init();
	}

	private void init() {
		
		this.jPanelListExecution = new JPanelListExecution();
		this.jPanelMainMemory = new JPanelMainMemory();
		
		JScrollPane jScrollPaneListExecution = new JScrollPane(jPanelListExecution);
		
		this.add(jScrollPaneListExecution);
		this.add(jPanelMainMemory);
	}
	
	public void renderJPanelLeft(MaquineBatchMono maquineBatchMono) {
		jPanelListExecution.renderListExecution(maquineBatchMono.getQueueExecution());
		jPanelMainMemory.renderJPanelMainMemory(maquineBatchMono.getMainMemory());
	}

}
