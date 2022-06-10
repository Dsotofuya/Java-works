package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Constants;
import util.CenterWindow;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private StadePane stadePane;
	private JPanel panel;
	private PanelOptions panelOptions;
	private PanelSimulation panelSimulation;

	public MainWindow() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Particion Fija");
		this.setLocationRelativeTo(null);
		this.setBounds(CenterWindow.windowX() - (Constants.WIDHT_WINDOW / 2),
				CenterWindow.windowY() - (Constants.HEIGHT_WINDOW / 2), Constants.WIDHT_WINDOW,
				Constants.HEIGHT_WINDOW);
		this.setResizable(false);
		addPanels();
		this.setVisible(true);
		stadePane = new StadePane();
		this.add(stadePane, BorderLayout.PAGE_START);
	}

	private void addPanels() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panelOptions = new PanelOptions();
		panelSimulation = new PanelSimulation();
		panel.add(panelOptions, BorderLayout.SOUTH);
		panel.add(panelSimulation, BorderLayout.CENTER);
		this.add(panel, BorderLayout.CENTER);
	}

	public PanelOptions getPanelOptions() {
		return panelOptions;
	}

	public StadePane getStadePane() {
		return stadePane;
	}

	public PanelSimulation getPanelSimulation() {
		return panelSimulation;
	}
}
