package model.entity;

import java.util.ArrayList;

public class Mark {
private String name;
private ArrayList<Line> lines;

	public Mark(String name) {
		this.name=name;
		lines = new ArrayList<>();
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Line> getLines() {
		return lines;
	}


	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}


	public void addLine(String n){
		lines.add(new Line(n));
	}

	public boolean lineExists(String founded){
		boolean exists = false;
		for (Line line : lines){
			if (line.getName().equals(founded)){
				return true;
			}
		}
		return exists;
	}

	public int findLine(String lineName){
		int pos = -1;
		int i = 0;
		boolean founded = false;
		while (i < lines.size() && !founded){
			if (lines.get(i).getName().equals(lineName)){
				pos = i;
				founded = true;
			}
			i++;
		}
		return pos;
	}
	
	public Line getLine(int pos){
		return lines.get(pos);
	}
	
	@Override
	public String toString() {
		return "Mark [name=" + name + "]";
	}
	
	public String toStringLines() {
		return lines.toString();
	}
	
	
}
