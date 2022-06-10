package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.AppManager;
import view.PeanutFrame;

public class Control implements ActionListener {

	private AppManager appManager;
	
	public Control() {
		appManager =  new AppManager(); 
		new PeanutFrame(appManager.getAppList());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		switch (Events.valueOf(e.getActionCommand())) {
//		case 1:
//			break;
//		}
	}

	public static void main(String[] args) {
		new Control();
	}
}
