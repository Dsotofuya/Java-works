package model;

import java.util.ArrayList;

public class Line {

	private String line;
	private ArrayList<Model> modelList;
	
	 public Line(String line, ArrayList<Model> modelList) {
		 this.line = line;
		 this.modelList = modelList;
	 }

	public void addModel(int model, double value) {
		modelList.add(new Model(model, value));
		
	}
	 
	public String getLine() {
		return line;
	}

	public ArrayList<Model> getModelList() {
		return modelList;
	}	 
	
}
