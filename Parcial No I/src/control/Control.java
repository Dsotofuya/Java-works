package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Timer;

import model.PartA;
import view.PeanutFrame;

public class Control implements ActionListener{

	private PeanutFrame peanut;
	private ConcurrentHashMap<Integer, String> paragraph;
	private PartA partA;
	private Timer timer;
	
	public Control() {
		partA = new PartA();
		paragraph = partA.startProcess();
		peanut = new PeanutFrame(this, paragraph.get(0), 360,360);
		startThreadGraphic();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Events.valueOf(event.getActionCommand())) {
		case PAUSE:
			pause();
			break;
		case REANUDE: 
			resume();
			break;
		default:
		}
	}

	private void startThreadGraphic(){
			timer = new Timer(1500, new ActionListener() {
				int count = 0;
				@Override
				public void actionPerformed(ActionEvent e) {
					peanut.setTextToPaint(paragraph.get(count));
					peanut.getCanvasPanel().update(paragraph.get(count));
					count++;
				}
			});
			timer.start();
	}
		
	private void pause() {
		partA.pauseMusic();
		try {
			timer.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void resume(){
		partA.reanudeMusic();
	}
	public static void main(String[] args) {
		new Control();
	}
}
