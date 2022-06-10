package Model;

import java.util.ArrayList;
import java.util.List;

import Model.Dao.JsonDao;

public class ManagerCiudad {

	private List<Ciudad> listaCiudades;
	private JsonDao dao;
	
	public ManagerCiudad() {
		dao = new JsonDao();
		listaCiudades = new ArrayList<>();
	}
	
	public static Ciudad createCiudad(String name, double latitud, double longitud, long temperatura, long poblacion) {
		return new Ciudad(name, latitud, longitud, temperatura, poblacion);
	}
	

	public void addCuidad(Ciudad ciudad) {
		listaCiudades.add(ciudad);
	}

	public List<Ciudad> cargarCiudades() {
		listaCiudades = dao.leerJson();
		return listaCiudades;
	}
	
	public void guardarCiudades() {
		dao.guardarCuidades(listaCiudades);
	}
	
	
	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}
	
	
}
