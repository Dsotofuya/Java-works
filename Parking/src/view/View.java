package view;

import java.awt.Menu;

import javax.swing.JOptionPane;

import control.MenuGlobal;
import control.PMenu;
import control.ResourceMenu;
import models.StateOfVehicle;
import models.TypeOfVehicle;
import models.Vehicle;

public class View {
	
	public TypeOfVehicle getTypeOfVehicle() {
		int option =  JOptionPane.showOptionDialog(null, "Escoja el tipo", "Tipo de Vehiculo", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, TypeOfVehicle.values(), TypeOfVehicle.values()[0]);
		return TypeOfVehicle.values()[option];
	}
	
	public String getPlate() {
		return JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
	}
	
	public Vehicle selectVehicle(Vehicle [] listVehicle) {
        return (Vehicle) JOptionPane.showInputDialog(null, "Elija un vehiculo: ", "Vehiculos", JOptionPane.QUESTION_MESSAGE,
                null, listVehicle, listVehicle[0]);
    }
	
	public void getUpdate() {
		 JOptionPane.showMessageDialog(null, ("El proceso fue exitoso"));
	}
	
	public StateOfVehicle getStateOfVehicle() {
		int option =  JOptionPane.showOptionDialog(null, "Escoja el estado del vehiculo", "Estado de Vehiculo", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, StateOfVehicle.values(), StateOfVehicle.values()[0]);
		return StateOfVehicle.values()[option];
	}
	
	public void getInt(int number) {
	JOptionPane.showMessageDialog(null, number);
	}
	
	public MenuGlobal getOptionGlobal() {
		return (MenuGlobal) JOptionPane.showInputDialog(null, "Ingrese la opción:", "Menú", JOptionPane.QUESTION_MESSAGE,
				null, MenuGlobal.values(), MenuGlobal.values()[0]);
	}
	
	public PMenu getOption() {
		return (PMenu) JOptionPane.showInputDialog(null, "Ingrese la opción:", "Menú", JOptionPane.QUESTION_MESSAGE,
				null, PMenu.values(), PMenu.values()[0]);
	}
	
	public ResourceMenu getOptionResource() {
		return (ResourceMenu) JOptionPane.showInputDialog(null, "Ingrese la opción:", "Menú", JOptionPane.QUESTION_MESSAGE,
				null, ResourceMenu.values(), ResourceMenu.values()[0]);
	}
	
	public void getIncorrect() {
		 JOptionPane.showMessageDialog(null, ("El proceso no se pudo completar"));
			}
	
	public void takeParkingBill(double parkingBill) {
			 JOptionPane.showMessageDialog(null, ("Su factura es de $" + parkingBill));
	}
	
	public void showQuantity(double quantity) {
		 JOptionPane.showMessageDialog(null, ("Hay " + quantity + "disponible"));
	}
	
	public void showRecomended(StateOfVehicle state) {
		 JOptionPane.showMessageDialog(null, ("La recomendación es que deberia invertir mas en " + state + " ya que actualmente tiene mas clientes en esta categoria. "));
}
	
	public void showMoneyCollect(double money) {
		 JOptionPane.showMessageDialog(null, ("El negocio ha recolectado: $" + money));
}
	
	public void showPorcentageTotal( double parked, double both) {
		JOptionPane.showMessageDialog(null, ("Hay: "  + parked + "% de autos parqueados"+ "  y un: " + both + "% de autos lavados y parqueados."));
		
	}
	
}	