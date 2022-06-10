package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import view.PeanutF;

public class Control implements ActionListener {

	private PeanutF peanut;
	
	public Control() {
		peanut = new PeanutF(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case GENERATE:
			starCloud();
			break;
		case ABOUT:
			showAbout();
			break;
		default:
			break;
		}
	}

	private void starCloud() {
		peanut.getCanvasPanel().run(toHashMap(processText(peanut.getTextPanel().getText())));
	}
	
	private void showAbout() {
		peanut.showAbout();
	}
	
	private String[] processText(String text) {
		String textWithoutSpecialCaracters = text.replaceAll("[^a-zA-Z0-9]+"," ");
		return textWithoutSpecialCaracters.split(" ");
	}	
	
	private HashMap<String, Integer> toHashMap(String[] words){
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) { 
		    Integer count = map.get(word); 
		    if (count == null) { 
		     count = 0; 
		    } 
		    map.put(word, count + 1);
		} 
		return (HashMap<String, Integer>) map;
	}
	
	public static void main(String[] args) {
		new Control();
	}
}
