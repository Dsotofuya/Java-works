package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.Event;
import controllers.MainController;

public class MainBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	public MainBar(MainController controller) {
		JMenu file = new JMenu("Archivo");
		
		JMenuItem addItem = new JMenuItem("Agregar Lugar");
		addItem.addActionListener(controller);
		addItem.setActionCommand(Event.SHOW_ADD_PLACE_DIALOG.toString());
		file.add(addItem);
		
		add(file);
	}

}
