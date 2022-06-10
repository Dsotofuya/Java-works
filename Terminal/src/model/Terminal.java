package model;

public class Terminal {

	private Company enterprise;
	private Routes roads;
	private Bus buses;
	private Employee employees;

	public Terminal() {

	}

	public Terminal(Company enterprise, Routes roads, Bus buses, Employee employees) {
		this.enterprise = enterprise;
		this.roads = roads;
		this.buses = buses;
		this.employees = employees;

	}

	public Company getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Company enterprise) {
		this.enterprise = enterprise;
	}

	public Routes getRoads() {
		return roads;
	}

	public void setRoads(Routes roads) {
		this.roads = roads;
	}

	public Bus getBuses() {
		return buses;
	}

	public void setBuses(Bus buses) {
		this.buses = buses;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

}
