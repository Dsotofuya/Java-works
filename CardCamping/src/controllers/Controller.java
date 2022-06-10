package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import views.DialogAddCamping;
import views.DialogAddPerson;
import views.DialogInvoice;
import views.WindowCamping;
import models.CampingNotFound;
import models.CampingZone;
import models.Reserve;
import models.ManagerCamping;
import models.Guest;

public class Controller implements ActionListener{

	private ManagerCamping managerCamping;//DAO instance
	private WindowCamping windowCamping;//Main Frame Instance
	private DialogAddCamping dialogAddCamping;//dialog instances
	private DialogInvoice dialogInvoice;//
	private DialogAddPerson dialogAddPerson;//

	public Controller() {//controller constructor
		managerCamping = new ManagerCamping();//allocates space memory for DAO
		windowCamping = new WindowCamping(this);//allocates space memory for views and assigns controller
		dialogAddCamping = new DialogAddCamping(windowCamping, this);//space memory for dialogs
		dialogAddPerson = new DialogAddPerson(windowCamping, this);
		dialogInvoice = new DialogInvoice(windowCamping, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {//events main method
		switch (Events.valueOf(e.getActionCommand())) {//gets case value and takes action accordingly
		case SHOW_ADD_CAMPING_DIALOG://1)names the event
			showAddCampingDialog();//executes the method to show dialog
			break;
		case ADD_CAMPING://*1
			addCamping();//3)executes the given method
			break;
		case RESERVE://*1
			reserve(Integer.valueOf(((JButton)(e.getSource())).getName()));//2) executes the reserve() method and converts the button's info to integer
			break;
		case CHECK_OUT://*1
			checkOut(Integer.valueOf(((JButton)(e.getSource())).getName()));//*2
			break;
		case PRINT:
			printInvoice();//*3
			break;
		case SEARCH:
			search();//*3
			break;
		case ADD_PERSON://*1
			addPerson();//*3
			break;
		case SHOW_ADD_PERSON_DIALOG://*1
			showAddPersonDialog();//*3
			break;
		}
	}
	//New methods needed in events
	private void showAddPersonDialog() {
		dialogAddPerson.setVisible(true);//when executed shows addPerson window
	}

	private void addPerson() {//w.e. saves a new person object
		Guest person = dialogAddPerson.getPerson();//creates the person object from user's input
		managerCamping.addPerson(person);//executes adding method from manager
		windowCamping.refreshPersonList(managerCamping.getPersonList());//refresh list with last person added
		dialogAddPerson.setVisible(false);//closes addPerson window
	}

	private void search() {
		windowCamping.refreshCards(managerCamping.search(
				windowCamping.getBxStatus(), windowCamping.getBxType()), this);//refreshes the pannel adding info from type and status window
	}

	private void printInvoice() {
		try {
			dialogInvoice.print();//prints pdf
		} catch (PrinterException e) {//catch errors
			e.printStackTrace();//prints error message
			JOptionPane.showMessageDialog(windowCamping, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);//shows error
		}
	}

	private void checkOut(int id) {
		try {
			Reserve invoice = managerCamping.checkOut(id, windowCamping.getSelectedPerson());//creates an invoice with id and person info
			dialogInvoice.showInvoice(invoice);//shows invoice
			windowCamping.refreshCards(managerCamping.getCampingZoneList(), this);//refresh cards
		} catch (CampingNotFound e) {//error handler
			e.printStackTrace();
			JOptionPane.showMessageDialog(windowCamping, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void reserve(int id) {
		int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter the hours:", 1));//shows dialog and gets hours number
		managerCamping.reserve(id, hours);//gets and sets generated models' id and sets the given hours num 
		windowCamping.refreshCards(managerCamping.getCampingZoneList(), this);//refresh cards panel
	}

	private void showAddCampingDialog() {
		dialogAddCamping.fillWithTestData();//fills Camping traits with random data
		dialogAddCamping.setVisible(true);//shows the addDialog 
	}
	
	private void addCamping() {
		dialogAddCamping.setVisible(false);//closes addDialog
		CampingZone campingZone = dialogAddCamping.getCampingZone();//creates CampingCard from addDialog info
		managerCamping.addCampingZone(campingZone);//adds cZone
		windowCamping.refreshCards(managerCamping.getCampingZoneList(), this);//refreshes center panel with new card
	}
}