package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import model.dao.Manager;
import model.entity.Publicacion;
import network.Client;
import view.Card;
import view.JdialogCreateProduct;
import view.WindowClient;

public class Controller implements ActionListener {

	public Manager manager ;
	public WindowClient window;
	public Client client;
	
	public Controller() throws IOException {
		manager = new Manager();
		client = new Client();
		window = new WindowClient(null , this);
	}
	
	public static void main(String[] args) {
		try {
			new Controller();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( Action.valueOf( e.getActionCommand() ) ) {
		case ACEPT:
			String [] datos = window.dialogDatos();
			datos[3] = manager.encoder(datos[3]);
			client.sendInfo(datos);
			window.dialogVisible(false);
			break;
		case CONTACT:
			String app = ((JButton)e.getSource()).getName();
			client.sendMessage(Integer.valueOf(app), "Hola");
			break;
		case ADD:
			window.dialogVisible(true);
			break;
		case VER:
			String ver = ((JButton)e.getSource()).getName();
			Publicacion p1 = manager.searchPublicacion(Integer.valueOf(ver));
			try {
				new Card(p1 , this);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			break;
		case UPDATE:
			try {
				manager.fillList(client.requestInfo());
				window.paintPublicacion(manager.getListaPublicacion(), this);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
			default:
				break;
		}
	}
}
