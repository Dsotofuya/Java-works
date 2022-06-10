package model.empty;

import javax.swing.JOptionPane;

public class Bus extends Vehiculo implements Tarifa {
	private boolean baño;

	public Bus() {
		baño = false;
	}

	public boolean isBaño() {
		return baño;
	}

	public void setBaño(boolean baño) {
		this.baño = baño;
	}

	public boolean baño(){
		String  baño = JOptionPane.showInputDialog("¿El bus tiene baño? escriba si o no.");
		if (baño == "si") {
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public double calcularTarifa() {
	if(baño = true) {
		double distancia = getRuta().getDistancia();
		return (distancia * tarifa)+500;
		}
	else {
		double distancia = getRuta().getDistancia();
		return (distancia * tarifa);
		}
	}
}