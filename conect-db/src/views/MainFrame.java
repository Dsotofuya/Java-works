package views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controllers.MainController;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private MainPanel mainPanel;
	
	public MainFrame(MainController controller) {
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setTitle("Base de Datos");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);
		
		MainBar mainBar = new MainBar(controller);
		add(mainBar, BorderLayout.BEFORE_FIRST_LINE);
		
		setVisible(true);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}
}
