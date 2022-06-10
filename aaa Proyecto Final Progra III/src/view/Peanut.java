package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.Events;
import model.INode;
import view.createAccount.CreateAccountMainPanel;
import view.login.LoginMainPanel;

public class Peanut extends JFrame{
	private static final long serialVersionUID = -7788036025712213447L;

	private static final String POSTAL_CREATOR = "Postal Creator";
	private static final String ICON_PATH = "src/data/img/photo.png";
	private PanelTree tree;
	private LoginMainPanel login;
	private CreateAccountMainPanel createAccount;
	private JMenuBar menu;
	
	public Peanut(MouseListener mouseListener, INode iNode, ActionListener control) {
		setSize(500, 720);
		setTitle(POSTAL_CREATOR);
		setResizable(false);
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem addFolder = new JMenuItem("Add folder");
		addFolder.addActionListener(control);
		addFolder.setActionCommand(Events.SHOW_ADD_FOLDER.toString());

		JMenuItem addFolderInsideOther = new JMenuItem("Add folder inside other");
		addFolderInsideOther.addActionListener(control);
		addFolderInsideOther.setActionCommand(Events.SHOW_ADD_FOLDER_INSIDE_OTHER.toString());

		JMenuItem addPostal = new JMenuItem("Add Postal");
		addPostal.addActionListener(control);
		addPostal.setActionCommand(Events.SHOW_ADD_POSTAL.toString());

		JMenuItem addImage = new JMenuItem("Add image");
		addImage.addActionListener(control);
		addImage.setActionCommand(Events.SHOW_ADD_IMAGE.toString());

		JMenuItem addText = new JMenuItem("Add text");
		addText.addActionListener(control);
		addText.setActionCommand(Events.SHOW_ADD_TEXT.toString());
		
		JMenuItem edit = new JMenuItem("Rename");
		edit.addActionListener(control);
		edit.setActionCommand(Events.SHOW_EDIT.toString());

		JMenuItem editText = new JMenuItem("Edit Text");
		editText.addActionListener(control);
		editText.setActionCommand(Events.SHOW_EDIT_TEXT.toString());
		
		JMenuItem editImage = new JMenuItem("Edit Image");
		editImage.addActionListener(control);
		editImage.setActionCommand(Events.SHOW_EDIT_IMAGE.toString());
		
		JMenuItem delete = new JMenuItem("Delete");
		delete.addActionListener(control);
		delete.setActionCommand(Events.SHOW_DELETE.toString());
		
		JMenuItem viewImage = new JMenuItem("View Image");
		viewImage.addActionListener(control);
		viewImage.setActionCommand(Events.SHOW_VIEW_IMAGE.toString());
		
		JMenuItem viewText = new JMenuItem("View text");
		viewText.addActionListener(control);
		viewText.setActionCommand(Events.SHOW_VIEW_TEXT.toString());

		JMenuItem setHost = new JMenuItem("Change host");
		setHost.addActionListener(control);
		setHost.setActionCommand(Events.CHANGE_HOST.toString());
		
		JMenuItem viewPostal = new JMenuItem("View Postal");
		viewPostal.addActionListener(control);
		viewPostal.setActionCommand(Events.SHOW_VIEW_POSTAL.toString());
		
		JMenuItem reload = new JMenuItem("Reload");
		reload.addActionListener(control);
		reload.setActionCommand(Events.RELOAD.toString());

		JMenu menuFile = new JMenu("File");
		menuFile.add(addFolder);
		menuFile.add(addFolderInsideOther);
		menuFile.add(addPostal);
		menuFile.add(addImage);
		menuFile.add(addText);
		menuFile.add(edit);
		menuFile.add(editText);
		menuFile.add(editImage);
		menuFile.add(delete);
		menuFile.add(viewImage);
		menuFile.add(viewText);
		menuFile.add(viewPostal);
		menuFile.add(reload);
		
		menu.add(menuFile);
		menu.setVisible(false);
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tree = new PanelTree(mouseListener, iNode, control);
		login = new LoginMainPanel(control);
		createAccount = new CreateAccountMainPanel(control);
		add(login, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public PanelTree getTree() {
		return tree;
	}
	
	public CreateAccountMainPanel getCreateAccount() {
		return createAccount;
	}
	
	public LoginMainPanel getLogin() {
		return login;
	}

	public void loadApp() {
		createAccount.setVisible(false);
		login.setVisible(false);
		menu.setVisible(true);
		tree.setVisible(true);
		add(tree, BorderLayout.CENTER);
		repaint();
	}
	
	public void loadLogin() {
		createAccount.setVisible(false);
		login.setVisible(true);
		add(login, BorderLayout.CENTER);
		repaint();
	}
	
	public void loadCreateAccount() {
		login.setVisible(false);
		createAccount.setVisible(true);
		add(createAccount, BorderLayout.CENTER);
		repaint();
	}
}
