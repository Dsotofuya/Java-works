package xd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class bmpManager {
	//500, 333
	
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
	
	public byte[] newSize(int high, int width) {
		int newSize = (high*(width-1)*3);
		return intToByte(newSize-1);
	}
	
	public byte[] newHigh(byte[] array) {
		return intToByte(byteToInt(array[22], array[23], array[24], array[25]));
	}
	
	public byte[] newWidth(byte[] array) {
		int newWidth = byteToInt(array[18], array[19], array[19], array[20]);
		newWidth = newWidth/2;
		return intToByte(newWidth);
	}
	
	
	public void replaceHeader(byte[] header, File ruta) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(ruta, false)){
			fileOutputStream.write(header, 0, 54);
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
	
	public byte[] intToByte(int value) {
	    return new byte[] { 
	            (byte)(value >> 24),
	            (byte)(value >> 16),
	            (byte)(value >> 8),
	            (byte)value };
	    }
	
	public byte[] returnNewHeader(byte[] encabezado) {
		byte[] arrayAlto = newHigh(encabezado); 
		int newHighxd = byteToInt(arrayAlto[3], arrayAlto[2], arrayAlto[1], arrayAlto[0]);
		
		byte[] arrayAncho = newWidth(encabezado); 
		int newWidthxd = byteToInt(arrayAncho[3], arrayAncho[2], arrayAncho[1], arrayAncho[0]);
		
		byte[] newSize = newSize(newHighxd-1, newWidthxd-1);

		encabezado[2] = newSize[0];
		encabezado[3] = newSize[1];
		encabezado[4] = newSize[2];
		encabezado[5] = newSize[3];
		encabezado[18] = arrayAncho[0];
		encabezado[19] = arrayAncho[1];
		encabezado[20] = arrayAncho[2];
		encabezado[21]= arrayAncho[3];
		encabezado[22] = arrayAlto[0];
		encabezado[23] = arrayAlto[1];
		encabezado[24] = arrayAlto[2];
		encabezado[25]= arrayAlto[3];
		return encabezado;

	}
	
	public byte[] returnNewBody(byte[] body) {
		byte[] newBody = new byte[body.length];
		for (int i = 0; i < body.length; i+=2) {
			newBody[i] = body[i];
		}
		return newBody;
	}
	
	public byte[] takeBody(File ruta) {
		byte[] header = new byte[54];
		System.out.println(ruta.length()-54);
		byte[] body = new byte[(int) ruta.length()-54];
		try (FileInputStream fileInputStream = new FileInputStream(ruta)){
				fileInputStream.read(header);
				fileInputStream.read(body);
//				for (byte b : body) {
//					System.out.println(b);
//				}
			} catch (FileNotFoundException e) {
				System.out.println("El archivo no se ha encontrado");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Eror de carga de la imagen");
				e.printStackTrace();
			}
			return body;
		}
	
	public void replaceImage(byte[] header, byte[] body, String ruta) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(ruta, false)){
			fileOutputStream.write(header, 0, 54);
			System.out.println(body.length);
			fileOutputStream.write(body, 0, body.length);
		} catch (FileNotFoundException e) {
			System.out.println("archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de escritura");
			e.printStackTrace();
		}
	}

}
