package model.empty;

import javax.swing.JOptionPane;

public class Bus extends Vehiculo implements Tarifa {
	private boolean ba�o;

	public Bus() {
		ba�o = false;
	}

	public boolean isBa�o() {
		return ba�o;
	}

	public void setBa�o(boolean ba�o) {
		this.ba�o = ba�o;
	}

	public boolean ba�o(){
		String  ba�o = JOptionPane.showInputDialog("�El bus tiene ba�o? escriba si o no.");
		if (ba�o == "si") {
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public double calcularTarifa() {
	if(ba�o = true) {
		double distancia = getRuta().getDistancia();
		return (distancia * tarifa)+500;
		}
	else {
		double distancia = getRuta().getDistancia();
		return (distancia * tarifa);
		}
	}
}