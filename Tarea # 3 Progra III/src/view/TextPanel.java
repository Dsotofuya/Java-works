package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.Events;

public class TextPanel extends JPanel {
	private static final long serialVersionUID = 5618738444418176622L;

	private JTextArea textArea;
	private JButton generateCloud;

	public TextPanel(ActionListener control) {
		setBackground(Color.decode("#7fc0c7"));
		setPreferredSize(new Dimension(400, 160));
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		JScrollPane textPane = new JScrollPane(textArea);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setPreferredSize(new Dimension(380, 150));
		add(textPane);
		generateCloud = new JButton("Generate Cloud");
		generateCloud.setBackground(Color.decode("#FF5960"));
		generateCloud.setActionCommand(Events.GENERATE.toString());
		generateCloud.addActionListener(control);
		setFocusable(false);
		add(generateCloud);
	}

	public String getText() {
		return textArea.getText();
	}
}
