package Model.Dao;

import java.io.FileReader;
import java.util.Iterator;

import javax.swing.JFileChooser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonDao {
	
private JFileChooser fileChooser;
		
	public JsonDao() {

		fileChooser = new JFileChooser();
	}
	
	@SuppressWarnings("unused")
	public void leerJson() {
		fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(fileChooser);
		JSONParser parser = new JSONParser();	
		
		try {
			Object obj = parser.parse(new FileReader(fileChooser.getSelectedFile().getAbsolutePath()));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray inmuebles = (JSONArray) jsonObject.get("inmuebles");
			Iterator<?> iterator = inmuebles.iterator();
			while (iterator.hasNext()) {
				JSONObject inmueble = (JSONObject) iterator.next();
				
				String direccion = (String) inmueble.get("direccion");
				System.out.println("Dirección: " + direccion);
				
				String matricula = (String) inmueble.get("matricula");
				System.out.println("Matricula: " + matricula);
				
				
				JSONObject tipo = (JSONObject) inmueble.get("tipoInmueble");
				System.out.println("Tipo: " + tipo.toJSONString());
				
				
				JSONArray propietarios = (JSONArray) inmueble.get("propietarios");
				Iterator<?> iterator2 = propietarios.iterator();
				System.out.println("Propietarios: ");
				while (iterator2.hasNext()) {
					JSONObject propietario = (JSONObject) iterator2.next();
					
					String primerNombre = (String) propietario.get("primerNombre");
					if (primerNombre == null) {
						primerNombre = "";
					}
					String segundoNombre = (String) propietario.get("segundoNombre");
					if (segundoNombre == null) {
						segundoNombre = "";
					}
					
					String primerApellido = (String) propietario.get("primerApellido");
					if (primerApellido == null) {
						primerApellido = "";
					}
					
					String segundoApellido = (String) propietario.get("segundoApellido");
					if (segundoApellido == null) {
						segundoApellido = "";
					}
					System.out.println(primerNombre + " " + segundoApellido + " " + primerApellido + " " + segundoApellido);
					
					long porcentaje = (long) propietario.get("porcentaje");
					System.out.println("Porcentaje: " + porcentaje);
				} 
				
				JSONArray ofertas = (JSONArray) inmueble.get("ofertas");
				Iterator<?> iterator3 = ofertas.iterator();
				System.out.println("Ofertas: ");
				while (iterator3.hasNext()) {
					
					JSONObject oferta = (JSONObject) iterator3.next();
					
					long id = (long) oferta.get("id");
					System.out.println("Id: "+ id);
					
					String nombre = (String) oferta.get("nombre");
					System.out.println("Nombre: " +nombre);
					
					long valor = (long) oferta.get("valor");
					System.out.println("Valor" +valor);
					
				} 
				
				long habitaciones = (long) inmueble.get("habitaciones");
				System.out.println("Habitaciones: " + habitaciones);
				
				long banios = (long) inmueble.get("banios");
				System.out.println("Baños: " +banios);
				
				long parqueaderos = (long) inmueble.get("parqueaderos");
				System.out.println("Parqueaderos: " + parqueaderos);
				
				long estrato = (long) inmueble.get("estrato");
				System.out.println("Estrato" + estrato);
				
				long pisos = (long) inmueble.get("pisos");
				System.out.println("Pisos: "+ pisos);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new JsonDao().leerJson();
	}
}
