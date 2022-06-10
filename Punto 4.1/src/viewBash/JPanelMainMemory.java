package viewBash;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelsBatchMono.MainMemory;

public class JPanelMainMemory extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanelMonitor jPanelMonitor;
	private JPanelUserMemory jPanelUserMemory;
	
	public JPanelMainMemory() {
		this.setLayout(new GridLayout(2, 1));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		init();
	}

	private void init() {
		
		this.jPanelMonitor = new JPanelMonitor();
		this.jPanelUserMemory = new JPanelUserMemory();
		
		JScrollPane jScrollPaneMonitor = new JScrollPane(jPanelMonitor);
		JScrollPane jScrollPaneUserMemory = new JScrollPane(jPanelUserMemory);
		
		this.add(jScrollPaneUserMemory);
		this.add(jScrollPaneMonitor);
	}
	
	public void renderJPanelMainMemory(MainMemory mainMemory) {
		this.jPanelMonitor.renderJPanelMonitor(mainMemory.getMonitormemory());
		this.jPanelUserMemory.renderjPaneluserMemory(mainMemory.getUserMemory());
	}

}
