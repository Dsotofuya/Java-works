package model;

import java.io.File;

public class PartB {

	private int percentOne, percentTwo;
	
	public PartB() {
		percentOne = processFolder("folder1");
		percentTwo = processFolder("folder2");
	}

	private int processFolder(String path) {
		File file = new File(path);
		int size = 0;
			if (file.isDirectory()) {
				String list[] = file.list();
				for (String string : list) {
					size = (int) new File(path+ "/" + string).length();
			}
		}
			return size;
	}

//	public int getPercent(int size){
//		int percent = 0;
//		int length = new File("path");
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//					percent = (size/length)/360;
//			}
//		});
//		thread.start();
//		return percent;
//	}
//	
	
	public static void main(String[] args) {
		new PartB();
	}
}
