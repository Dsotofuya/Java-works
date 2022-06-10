package control;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		String cadena = "a v a asdas. das, da, a a da ";
		String cadena2 = cadena.replace(".", "").replace(",", "");
		String words[] = cadena2.split(" ");
		for (String string : words) {
			System.out.println(string);
			}
		
		Map<String, Integer> occurrences = new HashMap<String, Integer>(); 

		for (String word : words) { 
		    Integer oldCount = occurrences.get(word); 
		    if (oldCount == null) { 
		     oldCount = 0; 
		    } 
		    occurrences.put(word, oldCount + 1);
		} 
		 System.out.println(occurrences.toString());
	}
}
