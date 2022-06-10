package viewBash;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelsBatchMono.MaquineBatchMono;

public class JMainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanelMain JPanelMain;

	public JMainFrame(ActionListener actionListener) {
		this.setTitle("Batch");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, (Toolkit.getDefaultToolkit().getScreenSize().height) - 80);
		
		this.JPanelMain = new JPanelMain(actionListener);
		this.add(JPanelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public void renderView(MaquineBatchMono maquineBatchMono) {
		this.JPanelMain.renderView(maquineBatchMono);
	}
	
}
