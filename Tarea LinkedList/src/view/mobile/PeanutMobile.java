package view.mobile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Node;
import model.Profile;

public class PeanutMobile extends JFrame {
	private static final long serialVersionUID = -7476403251025723789L;

	private static final String CARD_BACKGROUND = "#D9D9D9";
	private static final String BACKGROUND = "#29B882";

	private JPanel panel;
	private ButtonsPanel buttons;

	public PeanutMobile(ActionListener control) {
		super("Tinder (?)");
		setSize(290, 385);
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setBackground(Color.decode(BACKGROUND));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		panel = new JPanel();
		panel.setBackground(Color.decode(CARD_BACKGROUND));
		panel.setPreferredSize(new Dimension(250, 300));
		add(panel, BorderLayout.NORTH);
		buttons = new ButtonsPanel(control);
		add(buttons, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void revalidateCard(Node node) {
		panel.removeAll();
		if (node != null) {
			panel.setName(String.valueOf(node.getData().getId()));
			System.out.println(panel.getName());
			JLabel name = new JLabel(node.getData().getName(), SwingConstants.CENTER);
			name.setPreferredSize(new Dimension(250, 30));
			name.setFont(new Font("Arial", Font.PLAIN, 20));
			panel.add(name);
			JLabel image = new JLabel(new ImageIcon(node.getData().getImage()));
			panel.add(image);
			JTextArea description = new JTextArea(node.getData().getDescription() + " " + node.getData().getBornday());
			description.setPreferredSize(new Dimension(250, 500));
			description.setFont(new Font("Arial", Font.PLAIN, 15));
			description.setEditable(false);
			description.setBackground(Color.decode(CARD_BACKGROUND));
			description.setLineWrap(true);
			JScrollPane pane = new JScrollPane(description);
			pane.setPreferredSize(new Dimension(250, 100));
			panel.add(description);
		} else {
			panel.add(new JLabel("Without concidence :C"));
		}
		revalidate();
	}

	public String getPanelName() {
		return panel.getName();
	}

	public static void main(String[] args) throws IOException {
		new PeanutMobile(null).revalidateCard(
				new Node(new Profile(5, ImageIO.read(new File("src/a.png")), "pepe", "23/03/1000", "soy io")));
	}
}
