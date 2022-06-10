package model.priorityList;

public class Task {
	
	private String name;
	private int points;

	public Task(String name, int points) {
		this.name = name;
		this.points = points;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoints() {
		return points;
	}
}
