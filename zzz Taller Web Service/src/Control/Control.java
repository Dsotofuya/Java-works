package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import constants.Constants;
import model.GameManager;
import model.GameSpecs;
import view.ManiFrame;


public class Control implements ActionListener{

	private GameManager gameManager;
	private ManiFrame maniFrame;
	
	public Control() throws MalformedURLException {
		gameManager = new GameManager();
		maniFrame = new ManiFrame(this);
		maniFrame.fillCB(gameManager.returnNames());
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equalsIgnoreCase(Constants.GAMESELECTED)) {
			System.out.println(gameManager.findGame(maniFrame.getText()));
			try {
				loadGameDates();
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			maniFrame.repaintAll();
			}
		
	}
	
	private void loadGameDates() throws MalformedURLException {
		GameSpecs specs  = gameManager.returnGameSpecs(gameManager.findGame(maniFrame.getText()).getId());
		System.out.println(specs.toString());
		maniFrame.loadImage(specs.getImg());
		maniFrame.loadDescription(specs.getDescription());
		maniFrame.loadMinimumReqs(specs.getMinimumReqs());
	}
	
	public static void main(String[] args) throws MalformedURLException {
		new Control();
	}

}
