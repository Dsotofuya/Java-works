package model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataScoreDao {

	private static final String PATH_JSON = "src/data/ScoreData.json";
	private static final String SCORE_LIST = "scoreList";
	private static final String USER = "user";
	private static final String SCORE = "score";

	public void writeDates(ConcurrentHashMap<String, Integer> scoreList) {
		JSONObject data = new JSONObject();
		JSONArray jsonlist = new JSONArray();
		for (String id : scoreList.keySet()) {
			JSONObject scoreData = new JSONObject();
			scoreData.put(USER, id);
			scoreData.put(SCORE,  scoreList.get(id));
			jsonlist.put(scoreData);
		}
		data.put(SCORE_LIST, jsonlist);
		try (FileWriter file = new FileWriter(PATH_JSON)) {
			file.write(data.toString());
		} catch (Exception e) {
		}
	}

	public JSONObject loadDates() {
		BufferedReader in;
		String inputLine;
		StringBuffer response = new StringBuffer();
		try {
			in = new BufferedReader(new FileReader(PATH_JSON));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONObject(response.toString());
	}

	public ConcurrentHashMap<String, Integer> listDates(JSONObject jsonObject) {
		ConcurrentHashMap<String, Integer> scoreData = new ConcurrentHashMap<String, Integer>();
		JSONArray userArray = jsonObject.getJSONArray(SCORE_LIST);
		Iterator<?> iterator = userArray.iterator();
		while (iterator.hasNext()) {
			JSONObject userDates = (JSONObject) iterator.next();
			String name = userDates.getString(USER);
			Integer score = userDates.getInt(SCORE);
			scoreData.put(name, score);
			}
		return scoreData;
	}
}
