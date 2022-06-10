package xd;

import java.io.File;

public class testBMP {	
	public void test(String path1, String path2) {
	bmpManager bmp = new bmpManager();
	byte[] arrayHeader = bmp.takeHeader(new File(path1)); //byte[]
	byte[] arrayBody = bmp.takeBody(new File(path1)); // byte[]
	bmp.replaceImage(bmp.returnNewHeader(arrayHeader), bmp.returnNewBody(arrayBody), path2);
}
	public static void main(String[] args) {
	new testBMP().test("src/zData/doggie.bmp","src/zData/tiger.bmp");
	}
	
}
