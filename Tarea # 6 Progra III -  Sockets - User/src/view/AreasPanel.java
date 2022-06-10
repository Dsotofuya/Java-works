package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.Events;

public class AreasPanel extends JPanel {
	private static final long serialVersionUID = 4897675140628935995L;

	private JTextArea writeArea, readArea;
	private JButton send, recive;
	
	public AreasPanel(ActionListener control) {
		writeArea = new JTextArea();
		writeArea.setBackground(Color.decode("#D5D5D5"));
		writeArea.setLineWrap(true);
		JScrollPane writeScroll = new JScrollPane(writeArea);
		writeScroll.setPreferredSize(new Dimension(430, 320));
		writeScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(writeScroll);
		
		readArea = new JTextArea();
		readArea.setBackground(Color.decode("#D5D5D5"));
		readArea.setLineWrap(true);
		readArea.setEditable(false);
		JScrollPane readScroll = new JScrollPane(readArea);
		readScroll.setPreferredSize(new Dimension(430, 320));
		readScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(readScroll);
		
		send = new JButton("Send");
		send.setFocusable(false);
		send.setActionCommand(Events.SEND.toString());
		send.addActionListener(control);
		add(send);
		
		recive = new JButton("Recive");
		recive.setFocusable(false);
		recive.setActionCommand(Events.RECIVE.toString());
		recive.addActionListener(control);
		add(recive);
	}
	
	public void showText(String text) {
		readArea.setText(text);
	}
	
	public String getTextToSend() {
		return writeArea.getText();
	}
}
