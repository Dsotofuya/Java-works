package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Conversor;
import view.MainFrame;

/** 
 * Clase encarada de conectar vista y logica
 * @author DSotoFuya
 */
public class presenter implements ActionListener {

	private MainFrame mainFrame;
	private Conversor conversor;

	public presenter() {
		conversor = new Conversor();
		mainFrame = new MainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case CONVERT:
			try {
				mainFrame.refersh(conversor.conversor(mainFrame.getNumber(), mainFrame.getInitialBase(),
						mainFrame.getFinalBase(), mainFrame.getTruncNumber()));				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(mainFrame, "La notaci\u00F3n debe ser un punto (.)");
			}
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		new presenter();
	}
}
