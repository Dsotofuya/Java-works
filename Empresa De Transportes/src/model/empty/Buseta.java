package model.empty;

public class Buseta extends Vehiculo implements Tarifa {
	private int pasajerosDiarios;
	
	public Buseta(){
		pasajerosDiarios = 0;
	}

	public int getPasajerosDiarios() {
		return pasajerosDiarios;
	}

	public void setPasajerosDiarios(int pasajerosDiarios) {
		this.pasajerosDiarios = pasajerosDiarios;
	}

	public double calcularTarifa() {
		int tarifa = 1600;
		double pasajeros = getPasajerosDiarios();
		return pasajeros*tarifa;
	}
}
