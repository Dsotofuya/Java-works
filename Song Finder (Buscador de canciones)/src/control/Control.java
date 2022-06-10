package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import model.Song;
import network.Services;
import view.Peanut;

public class Control implements ActionListener {

	private Peanut peanut;
	private Services services;
	private ArrayList<Song> songList;

	public Control() {
		peanut = new Peanut(this);
		services = new Services();
		songList = new ArrayList<Song>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case FIND:
			find();
			break;
		default:
		}
	}

	private void find() {
		try {
			songList = services.findArtist(peanut.getFindPanel().getArtistText(),
					Integer.valueOf(peanut.getFindPanel().getNSongText()));
			updateGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateGUI() {
		try {
			peanut.getCardsPanel().fill(songList);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Control();
	}
}
