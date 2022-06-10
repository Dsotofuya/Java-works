package File;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.student;

public class Binarios {
	
	//El objeto que va en el try es para no tener que cerrar al final del metodo. y al usar varios lectores o escritores todos deber ir en el try c;
	
	
	public void escrbirEnBinario() {
		String text = "Tu tiempo es limitado\n" 
				+ "As� que no lo malgastes viviendo la vida de otra persona...\n";
		//convertir texto a bytes y asignarlo a un array
		byte buf[] = text.getBytes();
		
		
		try(FileOutputStream escritura = new FileOutputStream("src/zData/texto1.txt")){
			escritura.write(buf);
			escritura.write(buf, 10, 20); //Graba de un arreglo, desde un determinado byte hasta otro  hhhh
			for (int i = 0; i < buf.length; i+=2) {
				escritura.write(buf[i]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("no se ha encontrado el archivo");
		} catch (IOException e) {
				System.out.println("Ha ocurrido un error cerrando el escrtor de archivos :'c");
			}
		}
		
		public void leerBinario() {
			try (FileInputStream archivo = new FileInputStream("src/zData/texto1.txt")){
				int tamanio = archivo.available();
				int n = tamanio/4;
				
				System.out.println("Bytes disponibles: " + tamanio);
				System.out.println("Los primeros" + n + "bytes del archivo. un read() a la vez");
				for (int i = 0; i < n; i++) {
					System.out.println((char) archivo.read());
				}
				
				System.out.println("\n aun disponibles" + archivo.available());
				System.out.println("siguientes" + n + "bytes del archivo. en un read(b[]) a la vez");
				byte b[] = new byte[n];
				archivo.read(b);
				System.out.println(new String(b, 0, n));
				System.out.println("\n aun disponibles " + archivo.available());
			} catch (FileNotFoundException e) {
				System.out.println("Ha ocurrido un error archivo no existe");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error I/O");
				e.printStackTrace();
			}
		}
		
		public void escribirEnDiferentesFormatos() {
			try(FileOutputStream fuente = new FileOutputStream("src/zData/texto1.txt");
					BufferedOutputStream procesador1 = new BufferedOutputStream(fuente);
					DataOutputStream procesador2 = new DataOutputStream(procesador1);
					) {
				procesador2.writeDouble(3.14159);
				procesador2.writeBytes("Este es el valor de pi\n");
				procesador2.writeChars("Este es el valor de pi\n");
				} catch (FileNotFoundException e) {
				System.out.println("Ha ocurrido un error archivo no encontrado");
				} catch (IOException e) {
				System.out.println("Ha ocurrido un error I/O");
				}
		}
		
		public static void leerBinario2() {
			try (FileInputStream inputStream = new FileInputStream("src/zData/texto1.txt");
					DataInputStream dataInputStream = new DataInputStream(inputStream)){
				System.out.println(inputStream.available());
				inputStream.available();
//				for (int i = 0; i < bytes; i++) {
//					System.out.println(inputStream.read());		
//					System.out.println((char) inputStream.read());
					System.out.println(dataInputStream.readDouble());
					
					byte xd[] = new byte[23];
					dataInputStream.read(xd);
					System.out.println(new String(xd, 0 ,23));
					
					StringBuilder text = new StringBuilder();
					for (int i = 0; i<23; i++) {
						text.append(dataInputStream.readChar());
						
					}
					System.out.println(text);
//				}
			} catch (Exception e) {
				System.out.println("error eksi diiiiiiiiiiiiiiiiiiii" + e);
			}
		}
	
	public static void writeObjects() {
		FileOutputStream fuente;
		try {
			fuente = new FileOutputStream("src/zData/object.obj");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fuente);
			objectOutputStream.writeObject(new student(1, "Furibito :3"));
			objectOutputStream.writeObject(new student(2, "Porki"));
			objectOutputStream.close();
			fuente.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readObjects() {
		try (FileInputStream fileInputStream = new FileInputStream("src/zData/object.obj");
				ObjectInputStream objectInputStream =  new ObjectInputStream(fileInputStream)){
			while (fileInputStream.available() > 0) {
					student p1 = (student) objectInputStream.readObject();
					System.out.println(p1);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
//		new Binarios().escrbirEnBinario();
//		new Binarios().escribirEnDiferentesFormatos();
		
		new Binarios();
		//		new Binarios().leerBinario2();
		Binarios.writeObjects();
		new Binarios().readObjects();
		
	}
}
