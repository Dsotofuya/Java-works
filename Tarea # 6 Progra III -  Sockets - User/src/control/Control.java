package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.User;
import view.Peanut;

public class Control implements ActionListener {

	private Peanut peanut;
	private User user;
	
	public Control() {
		user = new User();
		peanut = new Peanut(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SEND:
			send();
			break;
		case RECIVE:
			recive();
			break;
		default:
			break;
		}
	}

	private void send() {
		try {
			user.write(peanut.getAreasPanel().getTextToSend());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void recive() {
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
				try {
					peanut.getAreasPanel().showText(user.read());
				} catch (IOException e) {
					e.printStackTrace();
				}
//			}
//		});
//		thread.start();
	}

	public static void main(String[] args) {
		new Control();
	}
}
