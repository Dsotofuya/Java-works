package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dao.ImageDao;
import view.PeanutFrame;

public class Control implements ActionListener{

	private PeanutFrame peanut;
	private ImageDao imageDao;
	
	public Control() {
		imageDao = new ImageDao();
		peanut = new PeanutFrame(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Events.valueOf(event.getActionCommand())) {
		case PROCESSIMAGE:
			processImage();
			break;

		default:
		}
	}

	private void processImage() {
		imageDao.run();
		peanut.getCanvasPanel().paintImage(imageDao.getArray());
	}

	public static void main(String[] args) {
		new Control();
	}
}
