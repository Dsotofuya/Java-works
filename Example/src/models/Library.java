package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Library extends Thread{

	public Library() {
		start();
	}
	
	@Override
	public void run() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./book.txt"));
			String line;
			while (( line = reader.readLine()) != null) {
				System.out.println(line.split(" ").length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Library();
	}
}