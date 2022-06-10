package viewBash;

import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelsBatchMono.Execution;
import modelsBatchMono.MaquineBatchMono;

public class JPanelLog extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public JPanelLog() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	
	public void renderJPanelLog(MaquineBatchMono maquineBatchMono) {
		for (Iterator<Execution> iterator = maquineBatchMono.getQueueExecution().getQueue().iterator(); iterator.hasNext();) {
			Execution execution = (Execution) iterator.next();
				this.add(new JLabel(execution.getLog()));
				
				this.revalidate();
		}
	}

}
