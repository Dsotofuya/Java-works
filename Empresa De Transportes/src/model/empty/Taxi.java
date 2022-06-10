package model.empty;

import javax.swing.JOptionPane;

public class Taxi extends Vehiculo implements Tarifa {
	private boolean comunicador;
	
	public Taxi(){
		comunicador = false;
	}

	public boolean isComunicador() {
		return comunicador;
	}

	public void setComunicador(boolean comunicador) {
		this.comunicador = comunicador;
	}

	public double calcularTarifa() {
		int tarifa = 250;
		double distancia = getRuta().getDistancia();
		double saldo = distancia*tarifa;
		return saldo;
	}
	
	public boolean radio(){
		String  radio = JOptionPane.showInputDialog("¿El taxi tiene radio comunicador? escriba si o no.");
		if (radio == "si") {
			return true;
			
		}else {
			return false;
		}
		
	}
}
