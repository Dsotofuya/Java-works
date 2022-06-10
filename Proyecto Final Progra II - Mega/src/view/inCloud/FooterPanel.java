package view.inCloud;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Control.Control;

public class FooterPanel extends JPanel{
	private static final long serialVersionUID = -8318572114652855834L;

	private JButton cloud;
	private JButton uploadCamera;
	private JButton chat;
	private JButton sharedFolders;
	private JButton withoutConexion;
	
	public FooterPanel(Control control) {
		cloud = new JButton(new ImageIcon("src/data/images/cloudIcon.png"));
		cloud.setFocusable(false);
		cloud.setBackground(Color.decode("#D90007"));
		cloud.setBorder(BorderFactory.createEmptyBorder());
		add(cloud);
		uploadCamera = new JButton(new ImageIcon("src/data/images/cloudIcon.png"));
		uploadCamera.setBackground(Color.decode("#D90007"));
		uploadCamera.setFocusable(false);
		uploadCamera.setBorder(BorderFactory.createEmptyBorder());
		add(uploadCamera);
		chat = new JButton(new ImageIcon("src/data/images/messagesIcon.png"));
		chat.setBackground(Color.decode("#D90007"));
		chat.setFocusable(false);
		chat.setBorder(BorderFactory.createEmptyBorder());
		add(chat);
		sharedFolders = new JButton(new ImageIcon("src/data/images/cloudIcon.png"));
		sharedFolders.setBackground(Color.decode("#D90007"));
		sharedFolders.setFocusable(false);
		sharedFolders.setBorder(BorderFactory.createEmptyBorder());
		add(sharedFolders);
		withoutConexion = new JButton(new ImageIcon("src/data/images/downLoadIcon.png"));
		withoutConexion.setFocusable(false);
		withoutConexion.setBackground(Color.decode("#D90007"));
		withoutConexion.setBorder(BorderFactory.createEmptyBorder());
		add(withoutConexion);
		setLayout(new GridLayout(1,5));
		setBackground(Color.decode("#D90007"));
	}
}
