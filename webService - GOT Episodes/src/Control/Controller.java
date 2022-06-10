package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Constants;
import model.Episode;
import model.EpisodeManager;
import view.EpisodeFrame;

public class Controller implements ActionListener {

	private EpisodeFrame episodeFrame;
	private EpisodeManager episodeManager;

	public Controller() {
		episodeFrame = new EpisodeFrame(this);
		episodeManager = new EpisodeManager();
		episodeFrame.fillCB(episodeManager.returnNames());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase(Constants.EPISODESELECTED)) {
			fillDates();
		}
	}

	private void fillDates() {
		Episode episode = episodeManager.findEpisode(episodeFrame.getText());
		episodeFrame.fillPanel(String.valueOf(episode.getId()), episode.getName(), String.valueOf(episode.getSeason()),
				String.valueOf(episode.getNumber()), episode.getAirdate(), episode.getSummary());
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
