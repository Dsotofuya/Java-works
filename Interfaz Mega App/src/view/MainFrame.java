package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2759812542498748168L;
	private FindBarPanel findBarPanel;
	private FooterPanel footerPanel;
	private CloudPanel archivesPanel;
	
	public MainFrame() {
		setIconImage(new ImageIcon("src/zData/MegaIcon.png").getImage());
		footerPanel = new FooterPanel();
		findBarPanel = new FindBarPanel();
		archivesPanel = new CloudPanel();
		setSize(400, 600);
		setLayout(new BorderLayout());
		add(findBarPanel, BorderLayout.NORTH);
		add(archivesPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setBackground(Color.decode("#FAFAFA"));
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
