package models;

import java.util.HashMap;

public class Constants 
{
	public HashMap<Integer, String> parseNumber = new HashMap<>();
	public HashMap<Character, Integer> parseLetter = new HashMap<>();
	
	public Constants() {
		parseNumber.put(0, "0");
		parseNumber.put(1, "1");
		parseNumber.put(2, "2");
		parseNumber.put(3, "3");
		parseNumber.put(4, "4");
		parseNumber.put(5, "5");
		parseNumber.put(6, "6");
		parseNumber.put(7, "7");
		parseNumber.put(8, "8");
		parseNumber.put(9, "9");
		parseNumber.put(10, "A");
		parseNumber.put(11, "B");
		parseNumber.put(12, "C");
		parseNumber.put(13, "D");
		parseNumber.put(14, "E");
		parseNumber.put(15, "F");
		parseNumber.put(16, "G");
		parseNumber.put(17, "H");
		parseNumber.put(18, "I");
		parseNumber.put(19, "J");
		parseNumber.put(20, "K");
		parseNumber.put(21, "L");
		parseNumber.put(22, "M");
		parseNumber.put(23, "N");
		parseNumber.put(24, "O");
		parseNumber.put(25, "P");
		parseNumber.put(26, "Q");
		parseNumber.put(27, "R");
		parseNumber.put(28, "S");
		parseNumber.put(29, "T");
		parseNumber.put(30, "U");
		parseNumber.put(31, "V");
		parseNumber.put(32, "W");
		parseNumber.put(33, "X");
		parseNumber.put(34, "Y");
		parseNumber.put(35, "Z");
		
		parseLetter.put('0', 0);
		parseLetter.put('1', 1);
		parseLetter.put('2', 2);
		parseLetter.put('3', 3);
		parseLetter.put('4', 4);
		parseLetter.put('5', 5);
		parseLetter.put('6', 6);
		parseLetter.put('7', 7);
		parseLetter.put('8', 8);
		parseLetter.put('9', 9);
		parseLetter.put('A', 10);
		parseLetter.put('B', 11);
		parseLetter.put('C', 12);
		parseLetter.put('D', 13);
		parseLetter.put('E', 14);
		parseLetter.put('F', 15);
		parseLetter.put('G', 16);
		parseLetter.put('H', 17);
		parseLetter.put('I', 18);
		parseLetter.put('J', 19);
		parseLetter.put('K', 20);
		parseLetter.put('L', 21);
		parseLetter.put('M', 22);
		parseLetter.put('N', 23);
		parseLetter.put('O', 24);
		parseLetter.put('P', 25);
		parseLetter.put('Q', 26);
		parseLetter.put('R', 27);
		parseLetter.put('S', 28);
		parseLetter.put('T', 29);
		parseLetter.put('U', 30);
		parseLetter.put('V', 31);
		parseLetter.put('W', 32);
		parseLetter.put('X', 33);
		parseLetter.put('Y', 34);
		parseLetter.put('Z', 35);
		
	}
	
	public HashMap<Integer, String> getParse() {
		return parseNumber;
	}
	
	public HashMap<Character, Integer> getParseLetter() {
		return parseLetter;
	}
}
