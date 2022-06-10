package model;

public class Company {

	private String companyName;
	private int numberEmployees;
	private int numberBuses;

	public Company() {
		companyName = " ";
		numberEmployees = 0;
		numberBuses = 0;

	}

	public Company(String companyName, int numberEmployees, int numberBuses) {
		this.companyName = companyName;
		this.numberEmployees = numberEmployees;
		this.numberBuses = numberBuses;

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	public int getNumberBuses() {
		return numberBuses;
	}

	public void setNumberBuses(int numberBuses) {
		this.numberBuses = numberBuses;
	}

}
