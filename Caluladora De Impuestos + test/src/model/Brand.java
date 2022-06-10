package model;

import java.util.ArrayList;

public class Brand {

	private String brand;
	private ArrayList<Line> lineList;
	
	public Brand(String brand, ArrayList<Line> lineList) {
		this.brand = brand;
		this.lineList = lineList; 
	}

	public String getBrand() {
		return brand;
	}

	public ArrayList<Line> getLineList() {
		return lineList;
	}
}
