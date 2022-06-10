package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Brand {

	private String brand;
	private ArrayList<Line> lineList;
	
	public Brand(String brand, ArrayList<Line> lineList) {
		this.brand = brand;
		this.lineList = lineList; 
	}

	
	public void addLine(String name, ArrayList<Model> modelList) {
		lineList.add(new Line(name, modelList));
	}
	public String getBrand() {
		return brand;
	}

	public ArrayList<Line> getLineList() {
		return lineList;
	}
	
	public String toString() {
		String result = null;
		for (Line line : lineList) {
			result = line.getLine();
		}
		return  "Brand: " + this.brand + "," + "\n" + result  +  "\n";
	}
	
}
