package views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controllers.MainController;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private MainPanel mainPanel;
	
	public MainFrame(MainController controller) {
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setTitle("Base de Datos");
		setSize(new Dimension(480, 500));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);
		MainBar mainBar = new MainBar(controller);
		add(mainBar, BorderLayout.BEFORE_FIRST_LINE);
		setVisible(true);
	}
		
	public MainPanel getMainPanel() {
		return mainPanel;
	}
}
