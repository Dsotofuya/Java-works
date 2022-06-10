package Control;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Model.Inmueble;
import Model.Oferta;
import Model.Propietario;
import Model.TipoInmueble;
import Model.Dao.JsonDao;

public class Controller {

	private List<Inmueble> inmuebles;
	private List<Oferta> ofertas;
	private List<Propietario> propietarios;
	private JsonDao dao;

	public Controller() {
		dao = new JsonDao();
	}
	
	public void menuInmobiliaria() {
		int op = 0;
		do {
			op = optionsMenu();

			switch (op) {
			case 1:
				dao.leerJson();
				break;
			case 2:
				// dao.saveArchive();
				break;
			case 3:
				addObject();
				break;
			default:
				System.out.println("Seleccion incorrecta, por favor ingrese numeros entre 1 y 3");
				break;
			}
		} while (op != 3);

	}

	private void addObject() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Direccion");
		String direccion = sc.nextLine();
		System.out.println("Matricula");
		String matricula = sc.nextLine();

		System.out.println("Id del tipo");
		int idTipo = sc.nextInt();
		System.out.println("Descripcion del tipo");
		String descipcionTipo = sc.nextLine();
		

//		System.out.println("Desea añadir propietario?  si/no");
//		String rta = sc.nextLine();
	
//		do {
			System.out.println("Primer nombre");
			String primernombre = sc.nextLine();
			System.out.println("Segundo nombre");
			String segundoNombre = sc.nextLine();
			System.out.println("Primer Apellido");
			String primerApellido = sc.nextLine();
			System.out.println("Segundo Apellido");
			String segundoApellid = sc.nextLine();
			System.out.println("Porcentaje");
			double porcentaje = sc.nextDouble();
			
			Propietario propietario = new Propietario(primernombre, segundoNombre, primerApellido, segundoApellid,
					porcentaje);
			propietarios.add(propietario);
//		} while (rta == "si");
		
		
		System.out.println("id de la oferta");
		int idOferta = sc.nextInt();
		System.out.println("nombre de la oferta");
		String nombreOferta = sc.nextLine();
		System.out.println("valor de la oferta");
		int valorOferta = sc.nextInt();
		
		Oferta oferta = new Oferta(idOferta, nombreOferta, valorOferta);
		ofertas.add(oferta);

		System.out.println("habitaciones");
		int habitaciones = sc.nextInt();
		System.out.println("baños");
		int banios = sc.nextInt();
		System.out.println("parqueaderos");
		int parqueaderos = sc.nextInt();
		System.out.println("estrato");
		int estrato = sc.nextInt();
		System.out.println("pisos");
		int pisos = sc.nextInt();

		TipoInmueble tipoInmueble = new TipoInmueble(idTipo, descipcionTipo);

		

		

		Inmueble inmueble = new Inmueble(direccion, matricula, tipoInmueble, propietarios, ofertas, habitaciones,
				banios, parqueaderos, estrato, pisos);
		inmuebles.add(inmueble);
	}

	public int optionsMenu() {
		StringBuilder txt = new StringBuilder();
		txt.append("\n" + "1. Cargar Archivo");
		txt.append("\n" + "2. Guardar Archivo");
		txt.append("\n" + "3. Añadir Objeto");
		return readInt(txt.toString());
	}

	public int optionsMenu2() {
		StringBuilder txt = new StringBuilder();
		return readInt(txt.toString());
	}

	public int readInt(String message) {
		String text = JOptionPane.showInputDialog(message);
		return Integer.parseInt(text);
	}
	
	public static void main(String[] args) {
		new Controller().menuInmobiliaria();
	}
}
