package imagen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Image {

	
	public byte[] takeHeader(File ruta) {
		byte[] header = new byte[54];
		try (FileInputStream fileInputStream = new FileInputStream(ruta)){
			fileInputStream.read(header);
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se ha encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eror de carga de la imagen");
			e.printStackTrace();
		}
		return header;
	}
	
	
	// Corregir
//	public byte[] newSize(byte[] array) {
//		return toByteArray(byteToInt(array[2], array[3], array[4], array[5]));
//	}
//	
//	public byte[] newWidth(byte[] array) {
//		return toByteArray(byteToInt(array[18], array[19], array[20], array[21]));
//	}
//	public byte[] newHigh(byte[] array) {
//		return toByteArray(byteToInt(array[22], array[23], array[24], array[25]));
//	
//	}
	
	
	public void replaceHeader(byte[] header, File ruta) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(ruta, false)){
			fileOutputStream.write(header, 2, 5);
			fileOutputStream.write(header, 18, 21);
			fileOutputStream.write(header, 22, 25);
		} catch (FileNotFoundException e) {
			System.out.println("archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de escritura");
			e.printStackTrace();
		}
		
	}
	
	public int byteToInt(byte date1, byte date2, byte date3, byte data4) {
		int number = 0; 
		
		if (data4 < 0) {
			int convertido = converterNegative(data4);
			int d = convertido + (int) Math.pow(2, 24);
			number = number + d;
		} else {
			int d = data4 * (int) Math.pow(2, 24);
			number = number + d;
		}
			if (date3 < 0) {
			int convertido = converterNegative(date3);
			int c = convertido + (int) Math.pow(2, 16);
			number = number + c;
		} else{
			int c = date3 * (int) Math.pow(2, 16);
			number = number + c;
		}
			if (date2 < 0) {
			int convertido = converterNegative(date2);
			int b = convertido + (int) Math.pow(2, 8);
			number = number + b;
		} else {
			int b = date2 * (int) Math.pow(2, 8);
			number = number + b;
		}
			if (date1 < 0) {
			int convertido = converterNegative(date1);
			int a = convertido + (int) Math.pow(2, 0);
			number = number + a;
		} else {
			int a = date1 + (int) Math.pow(2, 0);
			number = number + a;
		}
		return number;
}

	public int converterNegative(byte number) {	
			return number + 256;
	}
	
	public byte[] toByteArray(int value) {
	    return new byte[] { 
	            (byte)(value >> 24),
	            (byte)(value >> 16),
	            (byte)(value >> 8),
	            (byte)value };
	    }
	
	
	public static void main(String[] args) {
		Image image = new Image() ;
		byte[] xd = image.takeHeader(new File("src/zData/tiger.bmp"));
			System.out.println(xd[2]);
			System.out.println(xd[3]);
			System.out.println(xd[4]);
			System.out.println(xd[5]);
			System.out.println("El nuevo tamaño será: " + image.byteToInt(xd[2], xd[3], xd[4], xd[5]));
			int newSize = image.byteToInt(xd[2], xd[3], xd[4], xd[5]);
			System.out.println(image.toByteArray(newSize));
			
			System.out.println(xd[18]);
			System.out.println(xd[19]);
			System.out.println(xd[20]);
			System.out.println(xd[21]);
			System.out.println("El nuevo ancho de la imagen será: " + image.byteToInt(xd[18], xd[19], xd[20], xd[21]));
			int newWidth = image.byteToInt(xd[18], xd[19], xd[20], xd[21]);
			System.out.println(image.toByteArray(newWidth));
			
			System.out.println(xd[22]);
			System.out.println(xd[23]);
			System.out.println(xd[24]);
			System.out.println(xd[25]);
			System.out.println("El nuevo ancho de la imagen será: " + image.byteToInt(xd[22], xd[23], xd[24], xd[25]));
			int newHigh  = image.byteToInt(xd[22], xd[23], xd[24], xd[25]);
			System.out.println(image.toByteArray(newHigh));
			byte[] ada = image.toByteArray(newHigh);
			System.out.println(image.byteToInt(ada[3], ada[2], ada[1], ada[0]));
			
		image.replaceHeader(xd, new File("src/zData/nd.bmp"));
		
	}
	
}
