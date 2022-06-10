package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Events;

public class FindPanel extends JPanel {
	private static final long serialVersionUID = -2708564640659570565L;

	private static final String BACKGROUND = "#FFF5B3";
	private static final String BUTTON_BACKGROUND = "#A699FF";
	private static final String BUTTON_TEXT = "Find";

	private JTextField artist, nSongs;
	private JButton find;

	/**
	 * Constructor of the topside of the frame,this have the bar to input de artist
	 * name & the number of songs that want to find
	 **/
	public FindPanel(ActionListener control) {
		setBackground(Color.decode(BACKGROUND));
		artist = new JTextField();
		artist.setPreferredSize(new Dimension(200, 30));
		add(artist);
		nSongs = new JTextField();
		nSongs.setPreferredSize(new Dimension(200, 30));
		add(nSongs);
		find = new JButton(BUTTON_TEXT);
		find.addActionListener(control);
		find.setBackground(Color.decode(BUTTON_BACKGROUND));
		find.setActionCommand(Events.FIND.toString());
		add(find);
	}

	
	/** This methods return the text inputed on the jtexfields**/
	
	public String getArtistText() {
		return artist.getText();
	}

	public String getNSongText() {
		return nSongs.getText();
	}
}
