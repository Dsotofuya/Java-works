package model;

import java.util.ArrayList;

public class Line {
	
	private String line;
	private ArrayList<Model> modelList;
	
	 public Line(String line, ArrayList<Model> modelList) {
		 this.line = line;
		 this.modelList = modelList;
	 }

	public void addModel(Model model) {
		modelList.add(model);
		
	}
	 
	public String getLine() {
		return line;
	}

	public ArrayList<Model> getModelList() {
		return modelList;
	}	 
	
	public String toString() {
		String result = null;
		for (Model model: modelList) {
			result += model.toString();
		}
		return  "Line: " + this.line + "," + "\n" + result + "\n";
	}
}
