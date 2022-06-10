package View.Panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Control.Events;
import Data.Costants;
import View.WindowFrame;

public class PanelButtons extends JPanel {

	/**
	 * Mantiene los botones crud
	 */
	private static final long serialVersionUID = 1L;
	private WindowFrame window;
	private JButton add, delete;
	
	public PanelButtons(WindowFrame window, ActionListener controller) {
		this.window = window;
		

		add = new JButton(window.getLanguajes().getProperty("Add"));
		add.addActionListener(controller);
		add.setActionCommand(Events.SHOW_DIALOG_ADD.toString());
		delete = new JButton(window.getLanguajes().getProperty("Delete"));
		delete.addActionListener(controller);
		delete.setActionCommand(Events.SHOW_DELETE_DIALOG.toString());
		
		setBackground(Color.decode(Costants.BACKGROUND));
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.insets = new Insets(0,40,15,5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1; 
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		add(add, constraints);
		
		constraints.insets = new Insets(0,5,15,40);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1; 
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		add(delete, constraints);
		
	}
}
