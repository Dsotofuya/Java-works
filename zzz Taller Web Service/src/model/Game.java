package model;

public class Game {

	private int appId;
	private String name;
	
	public Game(int appId, String name) {
		this.appId = appId;
		this.name = name;
	}

	public int getId() {
		return appId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Juego:  appId: " + appId + "name: " + name + "\n";
	}
	
}
