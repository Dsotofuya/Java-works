package model.dao;

import javax.swing.JOptionPane;

import model.empty.*;

public class ControlEmpresa {
	private Vehiculo vehiculo;
	private Ruta[] rutas;
	private Conductor[] conductores;
	private Taxi[] taxis;
	private Bus[] buses;
	private Buseta[] busetas;
	private int contadorTaxi;
	private int contadorBus;
	private int contadorBuseta;
	private int contadorConductores;
	private int contadorRutas;

	public ControlEmpresa() {
		rutas = new Ruta[10];
		conductores = new Conductor[10];
		taxis = new Taxi[10];
		buses = new Bus[10];
		busetas = new Buseta[10];
		contadorTaxi = 0;
		contadorBus = 0;
		contadorBuseta = 0;
		contadorConductores = 0;
		contadorRutas = 0;
	}

	public void createTaxi(String placa, int combustible, boolean comunicador, boolean estado, String modelo,
			Conductor conductor, Ruta ruta) {
		Taxi taxi = new Taxi();
		taxi.setPlaca(JOptionPane.showInputDialog(null, "Ingrese la placa del taxi"));
		taxi.setCombustible(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese galones de combustible")));
		taxi.setComunicador(taxi.radio());
		taxi.setModelo(JOptionPane.showInputDialog(null, "Ingrese el modelo del taxi" ));
		taxi.setConductor(conductor);
		taxi.setRuta(ruta);
//		taxi.setEstado(vehiculo.calcularEstado());
		guardarTaxi(taxi);
	}

	public void guardarTaxi(Taxi taxi) {
		taxis[contadorTaxi] = taxi;
		contadorTaxi++;

	}
	
	public int radioContador() {
		int contador = 0;
		for (int i = 0; i < taxis.length; i++) {
			if (taxis[i].isComunicador() == true) {
				contador++;
			}
		}
		return contador;
	}

	public void createBus(String placa, int combustible, boolean baño, boolean estado, String modelo,
			Conductor conductor, Ruta ruta) {
		Bus bus = new Bus();
		bus.setPlaca(JOptionPane.showInputDialog(null, "Ingrese la placa del bus"));
		bus.setCombustible(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese galones de combustible")));
//		bus.setEstado(vehiculo.calcularEstado());
		bus.setBaño(bus.baño());
		bus.setModelo(JOptionPane.showInputDialog(null, "Ingrese el modelo del bus " ));
		bus.setConductor(conductor);
		bus.setRuta(ruta);

		guardarBus(bus);
	}

	public void guardarBus(Bus bus) {
		buses[contadorBus] = bus;
		contadorBus++;

	}
	
	public int bañoContador() {
		int contador = 0;
		for (int i = 0; i < buses.length; i++) {
			if (buses[i].isBaño() == true) {
				contador++;
			}
		}
		return contador;
	}	

	public void createBuseta(String placa, int combustible, int pasajerosDiarios, int estado, String modelo,
			Conductor conductor, Ruta ruta) {
		Buseta buseta = new Buseta();
		buseta.setPlaca(JOptionPane.showInputDialog(null, "Ingrese la placa de la buseta"));
		buseta.setCombustible(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese galones de combustible")));
//		buseta.setEstado(vehiculo.calcularEstado());
		buseta.setNumeroDePasajeros(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de pasajeros")));
		buseta.setModelo(JOptionPane.showInputDialog(null, "Ingrese el modelo de la buseta" ));
		buseta.setConductor(conductor);
		buseta.setRuta(ruta);
		guardarBuseta(buseta);
	}

	public void guardarBuseta(Buseta buseta) {
		busetas[contadorBuseta] = buseta;
		contadorBuseta++;
	}

	public void createConductor(long cc, String name) {
		Conductor conductor = new Conductor();
		conductor.setCc(Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese la cedula de ciudadania del empleado")));
		conductor.setName(JOptionPane.showInputDialog(null, "Ingrese el nombre del conductor"));
		conductor.setFechaDeNaciemiento(JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento en formato dd/mm/aaaa"));
		guardarConductor(conductor);
	}

	public void guardarConductor(Conductor conductor) {
		conductores[contadorConductores] = conductor;
		contadorConductores++;
	}

	public void createRuta(int id, int distancia, String puntoDeInicio, String puntoDeLlegada) {
		Ruta ruta = new Ruta();
		ruta.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de la ruta")));
		ruta.setDistancia(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la distancia de la ruta")));
		ruta.setPuntoDeInicio(JOptionPane.showInputDialog(null, "Ingrese el punto de partida"));
		ruta.setPuntoDeLlegada(JOptionPane.showInputDialog(null, "Ingrese el punto de llegada"));
		guardarRuta(ruta);
	}

	public void guardarRuta(Ruta ruta) {
		rutas[contadorRutas] = ruta;
		contadorRutas++;
	}	

	public Conductor conseguirConductor(long cC){
		Conductor conductor = null;
		JOptionPane.showInputDialog("Ingrese la cedula para asigar a un vehiculo" + conductor);
		for (int i = 0; i < conductores.length; i++) {
			if(conductores[i].getCc() == cC){
				conductor = conductores[i];
			}
		}
		return conductor;
	}
	
	public Ruta conseguirRuta(int codigo){
		Ruta ruta = null;
		JOptionPane.showInputDialog("Ingrese el id de la ruta para asigarnar al vehiculo" +  ruta);
		for (int i = 0; i < rutas.length; i++) {
			if(rutas[i].getId() == codigo){
				ruta = rutas[i];
			}
		}
		return ruta;
	}
	
	public boolean asignarTaxi() {
		Conductor conductor = null;
		Ruta ruta = null;
		Taxi taxi = null;
		String plate = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
		long cC = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cedula para asigar a un vehiculo"));
		int codigo = Integer
				.parseInt((JOptionPane.showInputDialog("Ingrese el id de la ruta para asigarnar al vehiculo")));
		for (int i = 0; i < taxis.length; i++) {
			if (taxis[i].getPlaca().equals(plate)) {
				taxi = taxis[i];
			}
		}
		for (int i = 0; i < conductores.length; i++) {
			if (conductores[i].getCc() == cC) {
				conductor = conductores[i];
			}
		}
		for (int i = 0; i < rutas.length; i++) {
			if (rutas[i].getId() == codigo) {
				ruta = rutas[i];
			}
		}
		taxi.setConductor(conductor);
		taxi.setRuta(ruta);
		return true;
	}

	public boolean asignarBus() {
		Conductor conductor = null;
		Ruta ruta = null;
		Bus bus = null;
		String plate = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
		long cC = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cedula para asigar a un vehiculo"));
		int codigo = Integer
				.parseInt((JOptionPane.showInputDialog("Ingrese el id de la ruta para asigarnar al vehiculo")));
		for (int i = 0; i < buses.length; i++) {
			if (buses[i].getPlaca().equals(plate)) {
				bus = buses[i];
			}
		}
		for (int i = 0; i < conductores.length; i++) {
			if (conductores[i].getCc() == cC) {
				conductor = conductores[i];
			}
		}
		for (int i = 0; i < rutas.length; i++) {
			if (rutas[i].getId() == codigo) {
				ruta = rutas[i];
			}
		}
		bus.setConductor(conductor);
		bus.setRuta(ruta);
		return true;
	}

	public boolean asignarBuseta() {
		Conductor conductor = null;
		Ruta ruta = null;
		Buseta buseta = null;
		String plate = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
		long cC = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cedula para asigar a un vehiculo"));
		int codigo = Integer
				.parseInt((JOptionPane.showInputDialog("Ingrese el id de la ruta para asigarnar al vehiculo")));
		for (int i = 0; i < busetas.length; i++) {
			if (busetas[i].getPlaca().equals(plate)) {
				buseta = busetas[i];
			}
		}
		for (int i = 0; i < conductores.length; i++) {
			if (conductores[i].getCc() == cC) {
				conductor = conductores[i];
			}
		}
		for (int i = 0; i < rutas.length; i++) {
			if (rutas[i].getId() == codigo) {
				ruta = rutas[i];
			}
		}
		buseta.setConductor(conductor);
		buseta.setRuta(ruta);
		return true;
	}
	
	public String imprimirBus(){
		String bus = "";
		for (int i = 0;i<buses.length;i++) {
			if (buses[i]!=null) {
				bus += buses[i].toString()+"Baño: "+ buses[i].isBaño()+ "\n"+"Tarifa: " + buses[i].calcularTarifa() +"\t";
			}	
		}
		return bus;
	}
	
	public String imprimirBuseta(){
		String buseta = "";
		for (int i = 0;i<busetas.length;i++) {
			if (busetas[i]!=null) {
				buseta += busetas[i].toString()+"Pasajeros Diarios: "+ busetas[i].getNumeroDePasajeros()+ "\n"+"Tarifa: " + busetas[i].calcularTarifa() +"\t";
			}	
		}
		return buseta;
	}
	
	public String imprimirTaxi(){
		String taxi = "";
		for (int i = 0;i<taxis.length;i++) {
			if (taxis[i]!=null) {
				taxi += taxis[i].toString()+"Radio comunicador: "+ taxis[i].isComunicador()+ "\n"+"Tarifa: " + taxis[i].calcularTarifa() +"\t";
			}	
		}
		return taxi;
	}
	
	public String imprimirConductor(){
		String conductor = "";
		for (int i = 0;i<conductores.length;i++) {
			if (conductores[i]!=null) {
				conductor += conductores[i].toString();
			}	
		}
		return conductor;
	}
	
	public String imprimirRuta(){
		String ruta = "";
		for (int i = 0;i<rutas.length;i++) {
			if (rutas[i]!=null) {
				ruta += rutas[i].toString();
			}	
		}
		return ruta;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
}