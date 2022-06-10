package model.entity;

public class Model {
	private int year;
	private int value;
	
	public Model(int year, int value) {
		this.year = year;
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Model [year=" + year + ", value=" + value + "]";
	}
	
	

}
