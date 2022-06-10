package View;

import java.util.Scanner;

public class View {
	
	public void text(String string) {
		System.out.println(string);
	}
	
	public String readString() {
		Scanner sc = new Scanner(System.in);
		String date = new String();
		date = sc.next();
		return date;
	}
}
