package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import models.Product;
import models.ProductNotFoundException;
import models.Store;
import views.WindowStore;

public class Presenter implements ActionListener{
	
	private static final String TEXT_ERROR = "Error";
	private Store store;
	private WindowStore windowStore;
	
	public Presenter() {
		try {
			store = new Store();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		windowStore = new WindowStore(this);
		windowStore.initList(store.getProducts(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(Events.valueOf(e.getActionCommand())) {
			case ADD:
				add(Integer.parseInt(((JButton)e.getSource()).getName()));
			break;
		}
	}

	private void add(int id) {
		try {
			Product product = store.searchProduct(id);
			store.addProductToCar(product);
			windowStore.initCar(store.getProductsInCar());
			windowStore.setTotal(store.calculateTotal());
		} catch (ProductNotFoundException e) {
			JOptionPane.showMessageDialog(windowStore, e.getMessage(),
					TEXT_ERROR, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}