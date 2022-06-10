package model;

import java.util.ArrayList;

public class AppManager {

	private ArrayList<App> appList;

	public AppManager() {
		appList = new ArrayList<App>();
		addApp(createApp(1, "Pubg", "", 20000));
		addApp(createApp(2, "Maincrah", "", 19800));
		addApp(createApp(3, "Chess Rush", "", 9200));
		addApp(createApp(4, "Tap!", "", 7800));
	}

	public App createApp(int id, String name, String image, int size) {
		return new App(id, name, image, size);
	}

	public void addApp(App app) {
		appList.add(app);
	}

	public ArrayList<App> getAppList() {
		return appList;
	}
	
//	public static void main(String args[]) {
//		List<Integer> lList = new ArrayList<Integer>();
//
//		lList.add(4);
//		lList.add(1);
//		lList.add(7);
//		lList.add(2);
//		lList.add(9);
//		lList.add(1);
//		lList.add(5);
//
//		Collections.sort(lList);
//		Collections.reverse(lList);
//		for (int i = 0; i < lList.size(); i++) {
//			System.out.println(lList.get(i));
//		}
//	}
}
