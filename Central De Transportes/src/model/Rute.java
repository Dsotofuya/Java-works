package model;

public class Rute {
	private double kilometers;
	private String startPoint;
	private String finishPoint;
	private int fuel;

	public Rute(long code, double kilometers, String startPoint, String finishPoint, int fuel) {
		this.fuel = fuel;
		this.kilometers = kilometers;
		this.startPoint = startPoint;
		this.finishPoint = finishPoint;
	}

	public Rute() {
		fuel = 0;
		kilometers = 0.0;
		startPoint = "";
		finishPoint = "";
	}

	public int getFuel() {
		return fuel;
	}

	public void setfuel(int fuel) {
		this.fuel = fuel;
	}

	public double getKilometers() {
		return kilometers;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getFinishPoint() {
		return finishPoint;
	}

	public void setFinishPoint(String finishPoint) {
		this.finishPoint = finishPoint;
	}

}
