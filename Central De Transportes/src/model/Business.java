package model;

public class Business {

	private String nameOfTheBusiness;
	private int numberOfEmployees;
	private int numberOfBuses;

	public Business(String nameOfTheBusiness, int numberOfEmployees, int numberOfBuses ) {
		this.nameOfTheBusiness = nameOfTheBusiness;
		this.numberOfEmployees = numberOfEmployees;
		this.numberOfBuses = numberOfBuses;
	}

	public Business() {
		nameOfTheBusiness = "";
		numberOfEmployees = 0;
		numberOfBuses = 0;
	}

	public String getNameOfTheBusiness() {
		return nameOfTheBusiness;
	}

	public void setNameOfTheBusiness(String nameOfTheBusiness) {
		this.nameOfTheBusiness = nameOfTheBusiness;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfBuses() {
		return numberOfBuses;
	}

	public void setNumberOfBuses(int numberOfBuses) {
		this.numberOfBuses = numberOfBuses;
	}
	
	
}