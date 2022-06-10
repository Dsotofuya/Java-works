package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class test2 {

	public void debeTransformarLaListaDeVacacionesDelEmpleadoDesdeFichero() throws IOException {
		final Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		final InputStream is = GsonTest.class.getClassLoader().getResourceAsStream("json.txt");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
		final Empleado empleado = gson.fromJson(bufferedReader, Empleado.class);
		assertNotNull(empleado.getVacaciones());
		assertEquals(2, empleado.getVacaciones().size());
		assertEquals(5, empleado.getVacaciones().get(0).getTotalDias());
		assertEquals(7, empleado.getVacaciones().get(1).getTotalDias());
		bufferedReader.close();
	}
}
