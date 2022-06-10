package model;

import java.util.ArrayList;

import model.dao.WebService;

public class EpisodeManager {

	private ArrayList<Episode> episodeList;
	private WebService webService;
	
	
	public EpisodeManager() {
		webService = new WebService();
		episodeList = webService.getEpisodeList();
		}
	
	public ArrayList<String> returnNames(){
		ArrayList<String> names = new ArrayList<String>();
		for (Episode game : episodeList) {
			names.add(game.getName());
		}
		return names;
	}
	
	public Episode findEpisode(String episodeName) {
		Episode episodeFinded = null;
		for (Episode game : episodeList) {
			if (episodeName.equalsIgnoreCase(game.getName())) {
				episodeFinded = game;
			}
		}
		return episodeFinded;
	}
	
	public ArrayList<Episode> getGameList() {
		return episodeList;
	}
	
//	public static void main(String[] args) {
//		EpisodeManager xd = new EpisodeManager();
//		System.out.println(xd.findEpisode("The Night Lands").toString());
//	}
}
