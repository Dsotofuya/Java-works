package model;

import java.util.ArrayList;

import model.dao.WebService;

public class GameManager {

	private ArrayList<Game> gameList;
	private WebService webService;
	
	
	public GameManager() {
		webService = new WebService();
		gameList = webService.getGameList();
		deleteTestDates();
	}
	
	public void deleteTestDates() {
		gameList.remove(0);
		gameList.remove(1);
		gameList.remove(2);
		gameList.remove(3);
		gameList.remove(4);
	}
	
	public ArrayList<String> returnNames(){
		ArrayList<String> names = new ArrayList<String>();
		for (Game game : gameList) {
			names.add(game.getName());
		}
		return names;
	}
	
	public ArrayList<Game> getGameList() {
		return gameList;
	}
	
	public Game findGame(String gameName) {
		Game gameFinded = null;
		for (Game game : gameList) {
			if (gameName.equalsIgnoreCase(game.getName())) {
				gameFinded = game;
			}
		}
		return gameFinded;
	}
	
	public GameSpecs returnGameSpecs(int id) {
		return webService.getGameSpecs(webService.searchGame(String.valueOf(id)), String.valueOf(id));
	}
}
