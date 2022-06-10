package model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Archive;
import model.User;

public class DataUsersDao {

	public void writeDates(ArrayList<User> userDataList) {
		JSONObject data = new JSONObject();
		JSONArray userList = new JSONArray();
		for (User user : userDataList) {
			JSONObject userData = new JSONObject();
			userData.put("user", user.getUser());
			userData.put("password", user.getPassword());
			userData.put("archives", user.getArchiveList());
			userList.put(userData);
		}
		data.put("userList", userList);
		try (FileWriter file = new FileWriter("src/data/usersdata/UserData.json")) {
			file.write(data.toString());
		} catch (Exception e) {
		}
	}

	public JSONObject loadDates() {
		BufferedReader in;
		String inputLine;
		StringBuffer response = new StringBuffer();
		try {
			in = new BufferedReader(new FileReader("src/data/usersdata/UserData.json"));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONObject(response.toString());
	}

	public ArrayList<User> listDates(JSONObject jsonObject) {
		ArrayList<User> userData = new ArrayList<>();
		JSONArray userArray = jsonObject.getJSONArray("userList");
		Iterator<?> iterator = userArray.iterator();
		while (iterator.hasNext()) {
			JSONObject userDates = (JSONObject) iterator.next();
			String user = userDates.getString("user");
			String password = userDates.getString("password");
			JSONArray archives = userDates.getJSONArray("archives");
			Iterator<?> iteratorArchive = archives.iterator();
			ArrayList<Archive> archivesList = new ArrayList<>();
			while (iteratorArchive.hasNext()) {
				JSONObject archive = (JSONObject) iteratorArchive.next();
				int size = archive.getInt("size");
				String name = archive.getString("name");
				String type = archive.getString("type");
				archivesList.add(new Archive(name, size, type));
			}
			userData.add(new User(user, password, archivesList));
		}
		return userData;
	}
}
