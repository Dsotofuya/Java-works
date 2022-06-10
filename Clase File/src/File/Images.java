package File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Images {

	
	
	
	public int convertirByteAInt(byte date1, byte date2, byte date3, byte data4) {
		int numero = 0; 
		
		if (data4 < 0) {
			int convertido = comvertirNegativo(data4);
			int d = convertido + (int) Math.pow(2, 24);
			System.out.println("el primer byte es: " + d);
			numero = numero + d;
		} else {
			int d = data4 * (int) Math.pow(2, 24);
			System.out.println("el primer byte es: " + d);
			numero = numero + d;
		}
			if (date3 < 0) {
			int convertido = comvertirNegativo(date3);
			int c = convertido + (int) Math.pow(2, 16);
			System.out.println("el segundo byte es: " + c);
			numero = numero + c;
		} else{
			int c = date3 * (int) Math.pow(2, 16);
			System.out.println("el segundo byte es: " + c);
			numero = numero + c;
		}
			if (date2 < 0) {
			int convertido = comvertirNegativo(date2);
			int b = convertido + (int) Math.pow(2, 8);
			System.out.println("el tercero byte es: " + b);
			numero = numero + b;
		} else {
			int b = date2 * (int) Math.pow(2, 8);
			System.out.println("el tercero byte es: " + b);
			numero = numero + b;
		}
			if (date1 < 0) {
			int convertido = comvertirNegativo(date1);
			int a = convertido + (int) Math.pow(2, 0);
			System.out.println("el cuarto byte es: " + a);
			numero = numero + a;
		} else {
			int a = date1 + (int) Math.pow(2, 0);
			System.out.println("el cuarto byte es: " + a);
			numero = numero + a;
		}
		return numero;
}


	public int comvertirNegativo(byte numero) {	
			return numero + 256;
	}
	
	@SuppressWarnings("resource")
	public void getSize() {
		
		try {
			FileInputStream imageInputStream = new FileInputStream("src/zData/tiger.bmp");
				
				
				byte[] cabeceraArray = new byte[54];
			            imageInputStream.read(cabeceraArray);
			            StringBuilder a = new StringBuilder();
			            
			            char b = (char) cabeceraArray[0]; 
			            char c = (char) cabeceraArray[1]; 
			            a.append(b); a.append(c);
			            
			            System.out.println(a);
			            int xd = cabeceraArray[2]+256;
			            System.out.println(xd + " " + cabeceraArray[3] + " " + cabeceraArray[4] + " " + cabeceraArray[5]);
			            
			            System.out.println(new Images().convertirByteAInt(cabeceraArray[2],
			            		cabeceraArray[3], cabeceraArray[4], cabeceraArray[5]));
			            //metodo que reciba 4 bytes, los invierta y retorne el entero
//			            System.out.println(pos18 + " " + pos19 + " " + pos20 + " " + pos21);
//			            System.out.println(pos22 + " " + pos23 + " " + pos24 + " " + pos25);
			    
			            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	@SuppressWarnings("resource")
	public byte[] gethigh() {
		byte[] high = new byte[4];
		try {
			FileInputStream imageInputStream = new FileInputStream("src/zData/tiger.bmp");
				byte[] cabeceraArray = new byte[54];
			            imageInputStream.read(cabeceraArray);
			           high[0] = cabeceraArray[22];
			           high[1] = cabeceraArray[23];
			           high[2] = cabeceraArray[24];
			           high[3] = cabeceraArray[25];
			            
		}catch (IOException e) {
			e.printStackTrace();
		}
		return high;
	}
	
	@SuppressWarnings({ "resource" })
	public byte[] getwidth() {
		byte[] width = new byte[4];
		try {
			FileInputStream imageInputStream = new FileInputStream("src/zData/tiger.bmp");
				byte[] cabeceraArray = new byte[54];
			            imageInputStream.read(cabeceraArray);
			            width[0] = cabeceraArray[18];
			            width[1] = cabeceraArray[19];
			            width[2] = cabeceraArray[20];
			            width[3] = cabeceraArray[21];
			            
		}catch (IOException e) {
			e.printStackTrace();
		}
		return width;
	}
	
	@SuppressWarnings("resource")
	public byte[] getSizexd() {
		byte[] size = new byte[4];
		try {
			FileInputStream imageInputStream = new FileInputStream("src/zData/tiger.bmp");
				byte[] cabeceraArray = new byte[54];
			            imageInputStream.read(cabeceraArray);
			            size[0] = cabeceraArray[2];
			            size[1] = cabeceraArray[3];
			            size[2] = cabeceraArray[4];
			            size[3] = cabeceraArray[5];
			            
		}catch (IOException e) {
			e.printStackTrace();
		}
		return size;
	}
	
	public void generateNewImage(byte[] high, byte[] width) throws FileNotFoundException {
//		try {
//			FileInputStream imageInputStream = new FileInputStream("src/zData/nd.bmp");
//			byte[] cabeceraArray = new byte[54];
//			
//			FileOutputStream imageOutputStream = new FileOutputStream("src/zData/nd.bmp");
//			ImageOutputStream outputStream = (ImageOutputStream) imageInputStream;
//			
			RandomAccessFile fichero = new RandomAccessFile("src/zData/nd.bmp", "rw");
			try {
				fichero.seek(3);
				fichero.write(getSizexd());
				fichero.seek(18);
				fichero.write(getwidth());
				fichero.write(gethigh());
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	    	
	}
	
	public static void main(String[] args) {
		Images n =  new Images();
		try {
			n.generateNewImage(n.gethigh(), n.getwidth());
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
	}
}
