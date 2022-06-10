package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSpinner;

import controllers.Events;

import models.CampingZone;
import models.CampingZoneType;
import models.ManagerCamping;

public class DialogAddCamping extends JDialog {

	private static final long serialVersionUID = 1L;
	private JComboBox<CampingZoneType> bxTypeCamping;//comboBox item instantiation 
	private JSpinner spX;//interface tool that shows a element from a spinning list
	private JSpinner spY;//interface tool that shows a element from a spinning list
	
	public DialogAddCamping(JFrame frame, ActionListener controller) {//set the mainframe and controller as parameters for receiving coordenates and actions 
		super(frame, true);
		setTitle("Add camping");
		setSize(500, 500);
		setLocationRelativeTo(frame);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		bxTypeCamping = new JComboBox<>(CampingZoneType.values());//creates cBox showing campTypes
		bxTypeCamping.setBorder(BorderFactory.createTitledBorder("Type:"));//box label
		bxTypeCamping.removeItemAt(0);//removes empty space
		add(bxTypeCamping);
		
		spX = new JSpinner();//creates x spinner for the user
		spX.setBorder(BorderFactory.createTitledBorder("X:"));//spinner label
		add(spX);
		
		spY = new JSpinner();//creates y spinner for the user
		spY.setBorder(BorderFactory.createTitledBorder("Y:"));//spinner label
		add(spY);
		
		JButton btnAddDialog = new JButton("Add camping");//creates a button that starts ADD_CAMPING
		btnAddDialog.setAlignmentX(Component.CENTER_ALIGNMENT);//centers window
		btnAddDialog.setBackground(Constants.COLOR_GREEN);//back color
		btnAddDialog.setForeground(Color.WHITE);//front color
		btnAddDialog.addActionListener(controller);//links the btn with the Main Controller
		btnAddDialog.setActionCommand(Events.ADD_CAMPING.toString());//links to enumerated event
		add(btnAddDialog);//adds button
	}
	
	public void fillWithTestData(){//randomizes empty data by default
		bxTypeCamping.setSelectedIndex(0);//selects first item in the box
		spX.setValue((int)(Math.random()*100));
		spY.setValue((int)(Math.random()*100));
	}
	
	public CampingZone getCampingZone(){//gets cZone parameters
		return ManagerCamping.createCampingZone((CampingZoneType)bxTypeCamping.getSelectedItem(),
				((int)spX.getValue()), ((int)spY.getValue()));//enters the parameters of creating method(enum type, X and Y integers)
	}
}