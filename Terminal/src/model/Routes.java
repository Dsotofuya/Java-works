package model;

public class Routes {

	private String departure;
	private String destiny;
	private double kilometers;
	private int fuelPerKilometer;

	public Routes() {
		departure = " ";
		destiny = " ";
		kilometers = 0.0;
		fuelPerKilometer = 0;

	}

	public Routes(String departure, String destiny, double kilometers, int fuelPerKilometer) {
		this.departure = departure;
		this.destiny = destiny;
		this.kilometers = kilometers;
		this.fuelPerKilometer = fuelPerKilometer;

	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public double getKilometers() {
		return kilometers;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	public int getFuelPerKilometer() {
		return fuelPerKilometer;
	}

	public void setFuelPerKilometer(int fuelPerKilometer) {
		this.fuelPerKilometer = fuelPerKilometer;
	}

}
