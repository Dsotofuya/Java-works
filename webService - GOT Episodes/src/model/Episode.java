package model;

public class Episode {

	private int id;
	private String name;
	private int season;
	private int number;
	private String airdate;
	private String summary;
	
	public Episode(int id, String name, int season, int number, String airdate, String summary ) {
		this.id = id;
		this.name = name;
		this.season = season;
		this.number = number;
		this.airdate = airdate;
		this.summary = summary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSeason() {
		return season;
	}

	public int getNumber() {
		return number;
	}

	public String getAirdate() {
		return airdate;
	}

	public String getSummary() {
		return summary;
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", name=" + name + ", season=" + season + ", number=" + number + ", airdate="
				+ airdate + ", summary=" + summary + "]";
	}

}
