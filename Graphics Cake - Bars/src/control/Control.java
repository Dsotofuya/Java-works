package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.Constants;
import view.MainFrame;

public class Control implements ActionListener {
 
	private MainFrame f;
	
	public Control() {
	f = new MainFrame(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	 if (Constants.BARS == e.getActionCommand()) {
		 	f.showPanelBars();
	 	}
	 if (Constants.CAKE == e.getActionCommand()) {
		 f.showPanelCake();
	 	}
	}
	
	public static void main(String[] args) {
		new Control();
	}

}
