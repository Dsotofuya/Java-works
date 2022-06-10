package views;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import controllers.Events;
import models.CampingZoneType;

public class ToolBarCamping extends JToolBar{//Movable toolBar

	private static final long serialVersionUID = 1L;
	private JComboBox<CampingZoneType> bxTypeCamping;//Type unfolding list
	private JComboBox<String> bxStatusCamping;//Status unfolding list

	public ToolBarCamping(ActionListener controller) {//action parameter from controller
		
		bxStatusCamping = new JComboBox<>();//comboBox instantiation, items and border
		bxStatusCamping.addItem("Todos");
		bxStatusCamping.addItem("Libre");
		bxStatusCamping.addItem("Ocupado");
		bxStatusCamping.setBorder(BorderFactory.createTitledBorder("Status:"));
		add(bxStatusCamping);
		
		bxTypeCamping = new JComboBox<>(CampingZoneType.values());//comboBox instantiation and border
		bxTypeCamping.setBorder(BorderFactory.createTitledBorder("Type:"));
		add(bxTypeCamping);
		
		JButton btnSearch = new JButton("Q");//search button, starts search with Status and Type info
		btnSearch.addActionListener(controller);
		btnSearch.setActionCommand(Events.SEARCH.toString());
		add(btnSearch);
	}
	
	public String getBxStatus(){//returns the selected status
		return (String) bxStatusCamping.getSelectedItem();
	}
	
	public CampingZoneType getBxType(){//returns the selected type within an enumerate
		return (CampingZoneType) bxTypeCamping.getSelectedItem();
	}
}
