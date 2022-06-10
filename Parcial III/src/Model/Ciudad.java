package Model;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Ciudad  implements  JSONStreamAware{

	private String nombre;
	private double latitud;
	private double longitud;
	private long temperatura;
	private long poblacion;
	
	public Ciudad(String nombre, double latitud, double longitud, long temperatura, long poblacion) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.temperatura = temperatura;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public long getTemperatura() {
		return temperatura;
	}

	public long getPoblacion() {
		return poblacion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void writeJSONString(Writer out) throws IOException {
		@SuppressWarnings("rawtypes")
		LinkedHashMap obj =  new LinkedHashMap<>();
		obj.put("nombre", nombre);
		obj.put("latitud", latitud);
		obj.put("longitud", longitud);
		obj.put("temperatura", temperatura);
		obj.put("poblacion", poblacion);
		JSONValue.writeJSONString(obj, out);
		
		
	}
	
}
