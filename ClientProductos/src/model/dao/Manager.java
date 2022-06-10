package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import model.entity.Publicacion;

public class Manager {

	public ArrayList< Publicacion > listaPublicacion;

	public Manager() {
		listaPublicacion = new ArrayList<>();
	}
	
	public static Publicacion createPublicacion(String title, String description, String phone, String photo) {
		return new Publicacion(title, description, phone, photo);
	}

	public String encoder(String imagePath) {
		  String base64Image = "";
		  File file = new File(imagePath);
		  try (FileInputStream imageInFile = new FileInputStream(file)) {
		    byte imageData[] = new byte[(int) file.length()];
		    imageInFile.read(imageData);
		    base64Image = Base64.getEncoder().encodeToString(imageData);
		  } catch (FileNotFoundException e) {
		    System.out.println("Image not found" + e);
		  } catch (IOException ioe) {
		    System.out.println("Exception while reading the Image " + ioe);
		  }
		  return base64Image;
	}
	
	public static void decoder(String base64Image, String pathFile) {
		  try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
		    byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
		    imageOutFile.write(imageByteArray);
		  } catch (FileNotFoundException e) {
		    System.out.println("Image not found" + e);
		  } catch (IOException ioe) {
		    System.out.println("Exception while reading the Image " + ioe);
		  }
		}

	public void addPublicacion(Publicacion publicacion) {
		listaPublicacion.add(publicacion);
	}
	
	public Publicacion searchPublicacion(int id) {
		for (int i = 0; i < listaPublicacion.size(); i++) {
			Publicacion publicacion = listaPublicacion.get(i);
			if (publicacion.getId() == id) {
				return publicacion;
			}
		}
		return null;
	}
	
	public void fillList(ArrayList< Publicacion> list) {
		listaPublicacion = list;
	}
	
	public ArrayList<Publicacion> getListaPublicacion() {
		return listaPublicacion;
	}
}