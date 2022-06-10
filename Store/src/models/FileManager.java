package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	private static final String FILE_PATH = "./id.txt";

	public static int readId() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader(new File(FILE_PATH)));
		int id = Integer.parseInt(reader.readLine());
		reader.close();
		return id;
	}
	
	public static void writeId(int id) throws IOException {
		FileWriter writer = new FileWriter(new File(FILE_PATH));
		writer.write(String.valueOf(id));
		writer.close();
	}
}