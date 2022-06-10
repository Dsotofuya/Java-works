package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

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
	
	public CupEMartFrame(){
		super("Cup E-Mart");
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
		new CupEMartFrame();
	}
}
