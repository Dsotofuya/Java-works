package viewBash;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelsBatchMono.Finish;

public class JPanelRight extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanelListFinish jPanelListFinish;
	
	
	public JPanelRight() {
		this.setLayout(new GridLayout(1, 1));
		this.jPanelListFinish = new JPanelListFinish();
		JScrollPane jScrollPane = new JScrollPane(jPanelListFinish);
		this.add(jScrollPane);
		
	}
	
	
	public void renderFinish(ArrayList<Finish> finishs) {
		this.jPanelListFinish.renderListFinish(finishs);
	}

}
