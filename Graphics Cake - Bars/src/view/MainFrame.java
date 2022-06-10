package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import control.Control;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -5093064061027429275L;

	private DatesPanel datesPanel;
	private CakePanel cakePanel;
	private BarsPanel barsPanel;
	private ButtonsPanel buttonsPanel;
	
	public MainFrame(Control control) {
		super("Generador Graficas");
		setLayout(new BorderLayout());
		datesPanel = new DatesPanel();
		add(datesPanel, BorderLayout.NORTH);
		cakePanel = new CakePanel();
		barsPanel = new BarsPanel();
		buttonsPanel = new ButtonsPanel(control);
		add(buttonsPanel, BorderLayout.SOUTH);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void showPanelCake() {
		cakePanel.setVisible(true);
		barsPanel.setVisible(false);
		add(cakePanel, BorderLayout.CENTER);
		validate();
	}
	
	public void showPanelBars() {
		cakePanel.setVisible(false);
		barsPanel.setVisible(true);
		add(barsPanel, BorderLayout.CENTER);
		validate();
	}
}
