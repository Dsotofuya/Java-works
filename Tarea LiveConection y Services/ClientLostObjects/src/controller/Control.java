package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import models.Client;
import view.MainPanel;
import view.MainWindow;

public class Control implements ActionListener{
	
	private MainWindow mainWindow;
	private Client client;
	
	public Control() {
		mainWindow = new MainWindow(this);
		client = new Client();
			
		
//		mainWindow.getMainPanel().get
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case SEND_TEXT:
			break;
		case TO_RECEIVE_TEXT:
			break;
		case ADD_POST:
			sendDataToServer();
			break;
		case SHOW_POST_DIALOG:
			showPostDialog();
			break;
		case REFRESH:
			refresh();
			break;
		default:
			break;
		}
	}
	
	private void refresh() {
		client.sendAndReceive();
		mainWindow.getMainPanel().getPostPanel().refreshProducts(client.getPostList(), this);
	}

	private void sendDataToServer() {
		
		String image = client.encoder(mainWindow.getFileImage());
		try {
			client.sendDataToServer(mainWindow.getjDialogAddForm().getJlabelTitle(), mainWindow.getjDialogAddForm().getjLabelDescription(), mainWindow.getjDialogAddForm().getJlabelContactNumber() , image);
			mainWindow.closeShowAddDialog();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showPostDialog() {
		mainWindow.showAddPostDialog();
		
	}

}
