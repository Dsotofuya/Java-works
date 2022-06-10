package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Actions;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private PostPanel postPanel;
	public MainPanel(ActionListener listener) {
		setBackground(Color.red);
		setLayout(new BorderLayout());

//		JPanelFilledForms jPanelFilledForms = new JPanelFilledForms(post, actionListener)
		
		
		postPanel = new PostPanel();
		add(postPanel, BorderLayout.CENTER);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 1));
		
		TopPanel topPanel = new TopPanel();
		gridPanel.add(topPanel);
		

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2));
		
		JButton refreshButton = new JButton("Actualizar");
		refreshButton.addActionListener(listener);
		refreshButton.setFocusable(false);
		refreshButton.setActionCommand(Actions.REFRESH.toString());
		southPanel.add(refreshButton);
		
		JButton addPostBtn = new JButton("Agregar publicación");
		addPostBtn.addActionListener(listener);
		addPostBtn.setFocusable(false);
		addPostBtn.setActionCommand(Actions.SHOW_POST_DIALOG.toString());
		southPanel.add(addPostBtn);
		
		gridPanel.add(southPanel);
		add(gridPanel, BorderLayout.NORTH);
		setIUManager();
	}
	
	public PostPanel getPostPanel() {
		return postPanel;
	}
	
	private void setIUManager() {
		UIManager.put("Label.background", Color.WHITE);
		UIManager.put("Label.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("Label.cursor", new Cursor(Cursor.HAND_CURSOR));
		UIManager.put("TextField.border", new RoundedBorder(15));
		UIManager.put("Button.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Button.foreground", Color.BLACK);
	}
}
