package views;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.Events;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public MenuBar(ActionListener controller) {//links to controller events
		JMenu menuFile = new JMenu("File");//creates dropDown menu button 
		
		JMenuItem itemShowAddCamping = new JMenuItem("Add camping");//add item to dropDown menu
		itemShowAddCamping.addActionListener(controller);//links component to controller events
		itemShowAddCamping.setActionCommand(Events.SHOW_ADD_CAMPING_DIALOG.toString());//links to specified event
		menuFile.add(itemShowAddCamping);//adds to menuFile
		
		JMenuItem itemShowAddPerson = new JMenuItem("Add person");//add item to dropDown menu
		itemShowAddPerson.addActionListener(controller);//links component to controller events
		itemShowAddPerson.setActionCommand(Events.SHOW_ADD_PERSON_DIALOG.toString());//links to specified event
		menuFile.add(itemShowAddPerson);//adds to menuFile
		
		add(menuFile);//adds dropDown menu button
	}
}