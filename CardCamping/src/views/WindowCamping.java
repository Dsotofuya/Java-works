package views;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.CampingZone;
import models.CampingZoneType;
import models.Guest;


public class WindowCamping extends JFrame{//MainFrame

	private static final int MAX_ROW_NUMBER = 3;//Global constant with width of the cards grid
	private static final String TITLE = "Camping Manager Pro";//Global String for the app title
	private JPanel panelCampingCards;//java library instantiation
	private ToolBarCamping toolBarCamping;//Movable Bar instantiation 
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Guest> modelPerson;//A component that displays a list of objects and allows the user to select one or more items
	private JList<Guest> personList;//ListModel, maintains the contents of the DefaultListModel list

	public WindowCamping(ActionListener controller) {//parameter to receive Actions from controller
		setTitle(TITLE);
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		setJMenuBar(new MenuBar(controller));//Top menu bar
		
		toolBarCamping = new ToolBarCamping(controller);//Movable toolBar class
		add(toolBarCamping, BorderLayout.PAGE_START);
		
		modelPerson = new DefaultListModel<>();//displays list
		personList = new JList<>(modelPerson);//mantains content of list
		personList.setBorder(BorderFactory.createTitledBorder("Person list"));//adds border to the list view
		add(new JScrollPane(personList), BorderLayout.LINE_END);//allows to scroll the list
		
		panelCampingCards = new JPanel();//Container panel for cCards
		add(panelCampingCards, BorderLayout.CENTER);//centers main container
		
		setVisible(true);
	}
	
	public void refreshCards(ArrayList<CampingZone> campings, ActionListener controller){//receives a list and the controller as parameters
		panelCampingCards.removeAll();//executes erasing method from CampCards panel
		double rows = ((double)campings.size() / MAX_ROW_NUMBER);//establish the number of rows in the panel
		boolean isExactRowNumber = campings.size() % MAX_ROW_NUMBER == 0;//finds out if the rows are full or it needs blank spaces
		int rowsNumber =  isExactRowNumber ? (int) rows : (int)((1 - (rows - Math.floor(rows))) +  rows);//conditional statement, takes action if rows are full
		panelCampingCards.setLayout(new GridLayout(rowsNumber, MAX_ROW_NUMBER));//sets the new layout parameters with rowsNumber(calculated in last line)
		for (CampingZone campingZone : campings) {//loops from the campingZone selected to the total of campings' list
			panelCampingCards.add(new PanelCardCampingZone(campingZone, controller));//adds a new card with the new CZone info
		}
		if(!isExactRowNumber){//takes action to fill empty spaces on the grid
			int rest = MAX_ROW_NUMBER - (campings.size() % MAX_ROW_NUMBER);//finds the number of empty spaces
			for (int i = 0; i < rest; i++) {//repeats from 0 to the number of empty spaces
				panelCampingCards.add(new JLabel("Empty"));
			}
		}
		panelCampingCards.revalidate();//reviews and refresh the whole panel
	}
	
	public String getBxStatus(){//gives selected string from box in toolB... class
		return toolBarCamping.getBxStatus();
	}
	
	public CampingZoneType getBxType(){//gives selected enumerated from tollB... class
		return toolBarCamping.getBxType();
	}

	public void refreshPersonList(ArrayList<Guest> personList) {//actualizes PList
		modelPerson.clear();//DefaultListModel method that clears the list
		for (Guest person : personList) {//loop for rewriting the list with JList "personList" info
			modelPerson.addElement(person);
		}
	}

	public Guest getSelectedPerson() {//gives the required element
		return personList.getSelectedValue();
	}
}