package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import editLookAndFeel.TestTheme;
import view.panels.ImagePanel;
import view.panels.PanelOptions;
import view.panels.branchsPanel;
import view.panels.panelExtension;

public class CupEMartFrame extends JFrame{
	private static final long serialVersionUID = -963772791703426698L;
	
	private ImagePanel imagePanel;
	private PanelOptions panelOptions;
	private branchsPanel branchsPanel;
	private panelExtension panelExtension;
	private GridBagConstraints gbc;
	
	private final static String LOOKANDFEEL = "Metal";
	private final static String THEME = "DefaultMetal";/* "Metal", "System", "Motif","GTK"*/

	public CupEMartFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		super("Cup E-Mart");
		
//		String lookAndFeel = null;
//		if (LOOKANDFEEL.equals("Metal")) {
//			lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
//			}
//			if (LOOKANDFEEL.equals("System")) {
//			lookAndFeel = UIManager.getSystemLookAndFeelClassName();
//			}
//			if (LOOKANDFEEL.equals("Motif")) {
//			lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//			}
//			if (LOOKANDFEEL.equals("GTK")) {
//			lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
//			}
//			UIManager.setLookAndFeel(lookAndFeel);
//			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" // "javax.swing.plaf.metal.MetalLookAndFeel");
		
			if (LOOKANDFEEL.equals("Metal")) {
				if (THEME.equals("DefaultMetal")) {
					MetalLookAndFeel.setCurrentTheme(new TestTheme());
			}
				else if (THEME.equals("Ocean")) {
					MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			}	
			UIManager.setLookAndFeel(new MetalLookAndFeel()); 
			}
			
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		imagePanel = new ImagePanel();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(imagePanel, gbc);
		panelOptions = new  PanelOptions();
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 0);
		add(panelOptions, gbc);
		branchsPanel = new branchsPanel();
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 5, 5, 5);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(branchsPanel, gbc);  
		panelExtension = new panelExtension();
		add(panelExtension, gbc);
		setSize(565, 485);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new CupEMartFrame();
	}
}
