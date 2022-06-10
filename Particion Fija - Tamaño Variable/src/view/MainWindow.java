package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Constants;
import util.CenterWindow;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private StatePanel stadePane;
	private JPanel panel;
	private PanelOptions panelOptions;
	private PanelSimulation panelSimulation;
	private PanelPartitions panelPartitions;

	public MainWindow() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Particion Fija con Tamaño variable");
		this.setLocationRelativeTo(null);
		this.setBounds(CenterWindow.windowX() - (Constants.WIDHT_WINDOW / 2),
				CenterWindow.windowY() - (Constants.HEIGHT_WINDOW / 2), Constants.WIDHT_WINDOW,
				Constants.HEIGHT_WINDOW);
		this.setResizable(false);
		addPanels();
		this.setVisible(true);
		stadePane = new StatePanel();
		this.add(stadePane, BorderLayout.NORTH);
	}

	private void addPanels() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panelOptions = new PanelOptions();
		panelSimulation = new PanelSimulation();
		panelPartitions = new PanelPartitions();
		JPanel controlsPanel = new JPanel();
		controlsPanel.setLayout(new GridLayout(2, 1));
		controlsPanel.add(panelOptions);
		controlsPanel.add(panelPartitions);
		panel.add(controlsPanel, BorderLayout.SOUTH);
		panel.add(panelSimulation, BorderLayout.CENTER);
		this.add(panel, BorderLayout.CENTER);
	}

	public PanelOptions getPanelOptions() {
		return panelOptions;
	}

	public StatePanel getStadePane() {
		return stadePane;
	}

	public PanelSimulation getPanelSimulation() {
		return panelSimulation;
	}
	
	public PanelPartitions getPanelPartitions() {
		return panelPartitions;
	}
	
	public void restart() {
		panelPartitions = new PanelPartitions();
		repaint();
	}
}
