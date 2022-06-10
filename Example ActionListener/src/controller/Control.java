package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.UserManager;
import views.MainWindow;

public class Control implements ActionListener {

	private UserManager userManager;
	private MainWindow mainWindow;
	
	public Control() {
		userManager = new UserManager();
		mainWindow = new MainWindow(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		case ACCEPT:
				System.out.println("Hola");
			break;
		case BACK:
			
			break;
		default:
			break;
		}
	}

}
