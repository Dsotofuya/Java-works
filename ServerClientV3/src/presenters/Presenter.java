package presenters;

import java.io.IOException;

import models.IObserver;
import models.Product;
import network.Client;
import views.ClientWindow;

public class Presenter implements IObserver{
	
	private Client client;
	private ClientWindow clientWindow;
	
	public Presenter() {
		try {
			client = new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientWindow = new ClientWindow();
	}
	
	public void startObserver() {
		client.setObserver(this);
	}
	
	@Override
	public void updateTime(Product time) {
		clientWindow.updateLbTime(time.getServer());
	}
	
	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		presenter.startObserver();
	}
}