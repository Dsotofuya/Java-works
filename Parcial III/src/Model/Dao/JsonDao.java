package Model.Dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Ciudad;

public class JsonDao {
	
private JFileChooser fileChooser;

	public JsonDao() {
		fileChooser = new JFileChooser();
	}
	
	public List<Ciudad> leerJson() {
		
		List<Ciudad> listaCiudades = new ArrayList<>();
		
		fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(fileChooser);
		JSONParser parser = new JSONParser();	
		
		try {
			Object obj = parser.parse(new FileReader(fileChooser.getSelectedFile().getAbsolutePath()));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray ciudades = (JSONArray) jsonObject.get("ciudades");
			Iterator<?> iterator = ciudades.iterator();
			while (iterator.hasNext()) {
				JSONObject ciudad = (JSONObject) iterator.next();
				
				String nombre = (String) ciudad.get("nombre");
				System.out.println(nombre);
				
				double latitud = (double) ciudad.get("latitud");
				System.out.println(latitud);
				
				double longitud = (double) ciudad.get("longitud");
				System.out.println(longitud);
				
				long temperatura = (long) ciudad.get("temperatura");
				System.out.println(temperatura);
				
				long poblacion = (long) ciudad.get("poblacion");
				System.out.println(poblacion);
				
				Ciudad newCiudad = new Ciudad(nombre, latitud, longitud, temperatura, poblacion);
				listaCiudades.add(newCiudad);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaCiudades;
	}
	
	@SuppressWarnings("unchecked")
	public void guardarCuidades(List<Ciudad> ciudades) {
		JSONArray array =  new JSONArray();
		JSONObject jsonObject = new JSONObject();
		if (ciudades != null && !ciudades.isEmpty()) {
			for (Ciudad ciudad : ciudades) {
				jsonObject.put("nombre", ciudad.getNombre());
				jsonObject.put("latitud", ciudad.getLatitud());
				jsonObject.put("longitud", ciudad.getLongitud());
				jsonObject.put("temperatura", ciudad.getTemperatura());
				jsonObject.put("poblacion", ciudad.getPoblacion());
			}
			array.add(jsonObject);
		}	try (FileWriter fileWriter = new FileWriter("D:\\Ciudades.json")) {
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(array);
	}
	
	public static void main(String[] args) {
		JsonDao a = new JsonDao();
		
		System.out.println(a.leerJson().toString());
	}
	
}
