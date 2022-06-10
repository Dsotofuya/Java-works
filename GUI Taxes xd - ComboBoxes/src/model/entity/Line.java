package model.entity;

import java.util.ArrayList;

public class Line {
	private String name;
	private ArrayList<Model> models;

	public Line(String name) {
		this.name = name;
		models = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Model> getModels() {
		return models;
	}

	public void setModels(ArrayList<Model> models) {
		this.models = models;
	}

	public void addModel(int y, int v) {
		models.add(new Model(y, v));
	}

	@Override
	public String toString() {
		return "Line [name=" + name + ", models=" + models + "]";
	}
	
	
}
