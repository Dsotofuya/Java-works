package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import network.Client;
import view.Peanut;

public class Control implements ActionListener, IObserver {

	private static final String SEPARATOR = "-";
	private static final String SEAT_RESERVED = "Seat Reserved";
	private static final String LAST_UPDATE = "Last update: ";
	private static final String RESEVE_SEAT = "Reseve seat";
	private static final String DO_U_WANT_RESEVE_THIS_SEAT = "Do u want reseve this seat?";
	private static final String SEAT_FILLED = "Seat Filled";
	private static final String SEAT_NOT_AVALIABLE = "Seat Not Avaliable";

	private Client client;
	private Peanut peanut;

	public Control() {
		try {
			client = new Client();
			peanut = new Peanut(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case RESERVE:
			reseveSeat(((JComponent) (e.getSource())).getName());
			break;
		case FILL:
			JOptionPane.showInternalMessageDialog(null, SEAT_NOT_AVALIABLE, SEAT_FILLED, JOptionPane.WARNING_MESSAGE);
			break;
		default:
			break;
		}
	}

	@Override
	public void updateSeats(int[][] seatsMatriz, String updateTime) {
		peanut.getCenter().cleanMatriz();
		peanut.getCenter().fillMatrix(seatsMatriz);
		peanut.getTop().updateInfo(LAST_UPDATE + updateTime);
	}

	private void reseveSeat(String seat) {
		if (JOptionPane.showConfirmDialog(null, DO_U_WANT_RESEVE_THIS_SEAT, RESEVE_SEAT, JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE) == 0) {
			String[] xy = seat.split(SEPARATOR);
			client.requestSeat(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
			JOptionPane.showMessageDialog(null, SEAT_RESERVED, RESEVE_SEAT, JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void startObserver() {
		client.setObserver(this);
	}

	public static void main(String[] args) {
		Control control = new Control();
		control.startObserver();
	}
}