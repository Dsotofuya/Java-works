package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperation {
	
	@SuppressWarnings("resource")
	public static ArrayList<String> loadTextFile(String path) throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader buffer = new BufferedReader(new FileReader(path));
		String line;
		while ((line = buffer.readLine()) != null){
			list.add(line);
		}
		return list;
	}
}
