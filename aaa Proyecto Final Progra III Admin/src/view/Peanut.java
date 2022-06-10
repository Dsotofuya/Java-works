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
import model.userTree.ANode;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -7788036025712213447L;

	private static final String POSTAL_CREATOR = "Postal Creator";
	private static final String ICON_PATH = "src/data/img/photo.png";
	private PanelTree treePostal;
	private PanelTreeUser treeUser;
	private JMenuBar menu;

	public Peanut(MouseListener mouseListener, INode iNode, ANode aNode, ActionListener control) {
		setSize(975, 720);
		setTitle(POSTAL_CREATOR);
		setResizable(false);
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem addFolder = new JMenuItem("Add folder");
		addFolder.addActionListener(control);
		addFolder.setIcon(new ImageIcon("src/data/img/addFolder.png"));
		addFolder.setActionCommand(Events.SHOW_ADD_FOLDER.toString());

		JMenuItem addFolderInsideOther = new JMenuItem("Add folder inside other");
		addFolderInsideOther.addActionListener(control);
		addFolderInsideOther.setIcon(new ImageIcon("src/data/img/addFolderInside.png"));
		addFolderInsideOther.setActionCommand(Events.SHOW_ADD_FOLDER_INSIDE_OTHER.toString());

		JMenuItem addPostal = new JMenuItem("Add Postal");
		addPostal.addActionListener(control);
		addPostal.setIcon(new ImageIcon("src/data/img/addPostal.png"));
		addPostal.setActionCommand(Events.SHOW_ADD_POSTAL.toString());

		JMenuItem addImage = new JMenuItem("Add image");
		addImage.addActionListener(control);
		addImage.setIcon(new ImageIcon("src/data/img/addImage.png"));
		addImage.setActionCommand(Events.SHOW_ADD_IMAGE.toString());

		JMenuItem addText = new JMenuItem("Add text");
		addText.addActionListener(control);
		addText.setIcon(new ImageIcon("src/data/img/addText.png"));
		addText.setActionCommand(Events.SHOW_ADD_TEXT.toString());
		
		JMenuItem edit = new JMenuItem("Rename");
		edit.addActionListener(control);
		edit.setIcon(new ImageIcon("src/data/img/addText.png"));
		edit.setActionCommand(Events.SHOW_EDIT.toString());

		JMenuItem editText = new JMenuItem("Edit Text");
		editText.setIcon(new ImageIcon("src/data/img/addText.png"));
		editText.addActionListener(control);
		editText.setActionCommand(Events.SHOW_EDIT_TEXT.toString());
		
		JMenuItem editImage = new JMenuItem("Edit Image");
		editImage.setIcon(new ImageIcon("src/data/img/addText.png"));
		editImage.addActionListener(control);
		editImage.setActionCommand(Events.SHOW_EDIT_IMAGE.toString());
		
		JMenuItem delete = new JMenuItem("Delete");
		delete.setIcon(new ImageIcon("src/data/img/addText.png"));
		delete.addActionListener(control);
		delete.setActionCommand(Events.SHOW_DELETE.toString());
		
		JMenuItem viewImage = new JMenuItem("View Image");
		viewImage.setIcon(new ImageIcon("src/data/img/addText.png"));
		viewImage.addActionListener(control);
		viewImage.setActionCommand(Events.SHOW_VIEW_IMAGE.toString());
		
		JMenuItem viewText = new JMenuItem("View text");
		viewText.setIcon(new ImageIcon("src/data/img/addText.png"));
		viewText.addActionListener(control);
		viewText.setActionCommand(Events.SHOW_VIEW_TEXT.toString());

		JMenuItem setHost = new JMenuItem("Change host");
		setHost.setIcon(new ImageIcon("src/data/img/addText.png"));
		setHost.addActionListener(control);
		setHost.setActionCommand(Events.CHANGE_HOST.toString());
		
		JMenuItem viewPostal = new JMenuItem("View Postal");
		viewPostal.setIcon(new ImageIcon("src/data/img/addText.png"));
		viewPostal.addActionListener(control);
		viewPostal.setActionCommand(Events.SHOW_VIEW_POSTAL.toString());

		JMenu menuFile = new JMenu("File Postal");
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
		
		JMenuItem addUser = new JMenuItem("Add user");
		addUser.setIcon(new ImageIcon("src/data/img/addText.png"));
		addUser.addActionListener(control);
		addUser.setActionCommand(Events.SHOW_ADD_USER.toString());

		JMenuItem changePasswordUser = new JMenuItem("Change user password");
		changePasswordUser.setIcon(new ImageIcon("src/data/img/addText.png"));
		changePasswordUser.addActionListener(control);
		changePasswordUser.setActionCommand(Events.SHOW_CHANGE_PASSWORD.toString());
		
		JMenuItem concedePrivileges = new JMenuItem("Concede privileges");
		concedePrivileges.setIcon(new ImageIcon("src/data/img/addText.png"));
		concedePrivileges.addActionListener(control);
		concedePrivileges.setActionCommand(Events.SHOW_CONCEDE_PRIVILEGES.toString());
		
		JMenu menuUser = new JMenu("File User");
		menuUser.add(addUser);
		menuUser.add(changePasswordUser);
		menuUser.add(concedePrivileges);
		
		JMenuItem reload = new JMenuItem("Reload");
		reload.addActionListener(control);
		reload.setActionCommand(Events.RELOAD.toString());
		
		menu.add(menuFile);
		menu.add(menuUser);
		menu.add(reload);

		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		treePostal = new PanelTree(mouseListener, iNode, control);
		treePostal.setAutoscrolls(true);
		add(treePostal, BorderLayout.WEST);

		treeUser = new PanelTreeUser(mouseListener, aNode, control);
		add(treeUser, BorderLayout.EAST);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public PanelTree getTreePostal() {
		return treePostal;
	}

	public PanelTreeUser getTreeUser() {
		return treeUser;
	}
}
