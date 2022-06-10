package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.Events;

public class PeanutFrame extends JFrame{
	private static final long serialVersionUID = -6055824919055012884L;

	private static final String ICON_PATH = "src/data/icon.png";
	private static final String PROCESS_TEXT = "Process Text";
	private static final String PROCESS_IMAGE = "Process Image";
	private static final String LOAD_IMAGE = "Load Image";
	private static final String LOAD_TEXT = "Load Text";
	
	private ContenPanel imagePanel;
	private ContenPanel textPanel;
	private CanvasPanel canvasPanel;
	
	public PeanutFrame(ActionListener control) {
		super("Process app");
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setSize(860, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		canvasPanel = new CanvasPanel();
		JScrollPane scroll = new JScrollPane(canvasPanel); 
		scroll.setPreferredSize(new Dimension(400, 300));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		imagePanel = new ContenPanel(scroll, PROCESS_IMAGE,
				control, Events.PROCESSIMAGE.toString(), LOAD_IMAGE);
		add(imagePanel, BorderLayout.WEST);
		JTextArea text = new JTextArea();
		text.setBackground(Color.decode("#D5D5D5"));
		text.setLineWrap(true);
		JScrollPane textScroll = new JScrollPane(text);
		textScroll.setPreferredSize(new Dimension(400, 300));
		textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textPanel = new ContenPanel(textScroll, PROCESS_TEXT,
				control, Events.PROCESSTEXT.toString(), LOAD_TEXT);
		add(textPanel, BorderLayout.EAST); 
		
		setVisible(true);
	}
	
	public CanvasPanel getCanvasPanel() {
		return canvasPanel;
	}
}