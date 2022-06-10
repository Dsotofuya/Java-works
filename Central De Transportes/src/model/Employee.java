package model;

public class Employee {

	private String nameOfTheEmployee;
	private int documentOfIdenty;
	private int ageOfTheEmployee;

	public Employee(String nameageOfTheEmployee, int documentOfIdenty, int ageOfTheEmployee) {
		this.nameOfTheEmployee = nameageOfTheEmployee;
		this.documentOfIdenty = documentOfIdenty;
		this.ageOfTheEmployee = ageOfTheEmployee;
	}

	public Employee() {
		nameOfTheEmployee = null;
		documentOfIdenty = 0;
		ageOfTheEmployee = 0;
	}

	public String getNameOfTheEmployee() {
		return nameOfTheEmployee;
	}

	public void setNameOfTheEmployee(String nameOfTheEmployee) {
		this.nameOfTheEmployee = nameOfTheEmployee;
	}

	public int getDocumentOfIdenty() {
		return documentOfIdenty;
	}

	public void setDocumentOfIdenty(int documentOfIdenty) {
		this.documentOfIdenty = documentOfIdenty;
	}

	public int getAgeOfTheEmployee() {
		return ageOfTheEmployee;
	}

	public void setAgeOfTheEmployee(int ageOfTheEmployee) {
		this.ageOfTheEmployee = ageOfTheEmployee;
	}
}