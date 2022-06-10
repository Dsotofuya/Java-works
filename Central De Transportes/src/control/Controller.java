package control;

import javax.swing.JOptionPane;
import view.Manager;

public class Controller {
	private Manager manager;
	private String [] nameOfTheBusiness;
	private int [] numberOfEmployees;
	private int [] numberOfBuses;
	private int [] numberOfRutes;
	private String [] startPoint;
	private String [] finishPoint;
	private double [] kilometersOfTheRoute;
	private double [] fuel;
	private int [] code;
	private String[] licensePlate;
	private String [] nameOfTheEmployee;
	private long [] documentOfIdenty;
	private int [] ageOfTheEmployee;
	
		public Controller(){
			manager = new Manager();
			nameOfTheBusiness = new String [3];
			numberOfEmployees = new int [3];
			numberOfBuses = new int [3];
			startPoint = new String [3];
			finishPoint = new String [3];
			kilometersOfTheRoute = new double [3];
			fuel = new double [3];
			code = new int [3];
			licensePlate = new String[3];
			nameOfTheEmployee = new String [3];
			documentOfIdenty = new long [3];
			ageOfTheEmployee = new int [3];
			
		}
 	
		//Menu principal
		
		public void businessMenu() {
			int op = 0;
			do {
				op = manager.businessMenu();

				switch (op) {
				case 1:
					business();
					break;
				case 2:
					employeeMenu();
				case 3:
					busMenu();
				case 4:
					ruteMenu();
				case 5:
					break;
				default:
					manager.showMessage("Opcion incorrecta, por favor solo numeros del 1 al 5");
					break;
				}
			} while (op != 5);
		}	

		// Menu de compañias
		
		public void business() {
			int op = 0;
			do {
				op = manager.business();

				switch (op) {
				case 1:
					addBusiness();
					break;
				case 2:
					modifyBusiness();
					break;
				case 3:
					showBusiness();
					break;
				case 4:	
					businessWithMostTours(numberOfRutes);
					break;
				case 5:
					businessWithMostEmployees(numberOfEmployees);
					break;
				case 6:
					businessWithMostBuses(numberOfBuses);
					break;
				case 7:
					break;
				default:
					manager.showMessage("Seleccion incorrecta, por favor ingrese numeros del 1 al 7");
					break;
				}
			} while (op != 7);

		}
	
		//Menu empleados
		
		public void employeeMenu() {
			int op = 0;
			do {
				op = manager.employeeMenu();

				switch (op) {
				case 1:
					addEmployee();
					break;
				case 2:
					modifyEmployee();
					break;
				case 3:
					showEmployee();
					break;
				case 4:
					employeesByAge(ageOfTheEmployee);
				break;
				case 5:
					break;
				default:
					manager.showMessage("Opcion incorrecta");
					break;
				}
			} while (op != 5);
		}
		
		
		//Menu Buses
		
		public void busMenu() {
			int op = 0;
			do {
				op = manager.busMenu();

				switch (op) {
				case 1:
					createNewBus();
					break;
				case 2:
					modifyBus();
					break;
				case 3:
					showBus();
					break;
				case 4:
					break;
				default:
					manager.showMessage("Opcion incorrecta");
					break;
				}
			} while (op != 4);
		}
		
		//Menu de rutas
		
		public void ruteMenu() {
			int op = 0;
			do {
				op = manager.ruteMenu();

				switch (op) {
				case 1:
					createNewRute();
					break;
				case 2:
					modifyRute();
					break;
				case 3:
					showRutes();
					break;
				case 4:
					break;
				default:
					manager.showMessage("Opcion incorrecta");
					break;
				}
			} while (op != 4);
		}	
		
		
	//Añadir compañias	
		
	public void addBusiness() {
		for (int i = 0; i < nameOfTheBusiness.length; i++) {
			nameOfTheBusiness[i] = JOptionPane.showInputDialog("Ingrese el nombre de la empresa: " + i);
		}
		manager.showMessage("Empresas agregadas correctamente.");
		for (int j = 0; j < numberOfEmployees.length; j++) {
			numberOfEmployees[j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de empleados: " + j));
		}
		manager.showMessage("Empleados agregados correctamente.");
		for (int k = 0; k < numberOfBuses.length; k++) {
			numberOfBuses[k] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de buses: " + k));
		}
		manager.showMessage("Buses agregados correctamente.");
	}

	//Modificar Compañias
	
	public void modifyBusiness() {
		int op;
		op = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar.\n\n 1.Modificar el nombre de la empresa." 
		+ "\n 2.Modificar numero de empleados." +  "\n 3.Modificar numero de buses" + " \n 4.Volver."));
		switch (op) {
		case 1:
			op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del nombre de la empresa que se desea modificar: "));
			if (op >= nameOfTheBusiness.length) {
				manager.showMessage("Ingrese una posicion existente.");
			} else {
				nameOfTheBusiness[op] = String.valueOf(JOptionPane.showInputDialog("Ingrese el nuevo nombre de la empresa: " + op));
			}
			manager.showMessage("Nombre de la empresa se ha modificado correctamente.");
			break;
		case 2:
			op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion numeros de empleados a modificar :" + "\n(Entre 0 y 4)"));
			if (op >= numberOfEmployees.length) {
				manager.showMessage("Ingrese una posicion existente.");
			} 
				else {
				numberOfEmployees[op] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo numero de empleados: " + op));
				}
			manager.showMessage("Numero de empleados modificado.");
			break;
		case 3:
			op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion numeros de buses a modificar: "));
			if (op >= numberOfBuses.length) {
				manager.showMessage("Ingrese una posicion existente.");
			} 
				else {
				numberOfBuses[op] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo numero de buses: " + op));
			}
			manager.showMessage("Numero de buses modificado correctamente.");
			break;
		case 4:
			break;
		default:
			break;
		}
	}
	
	//Mostrar Compañias
	
	public void showBusiness() {
		JOptionPane.showMessageDialog(null,
				"Nombre: Empresa N° 1 : " + nameOfTheBusiness[0] + "\n Numero de empleados: empresa N°1 : "
						+ numberOfEmployees[0] + "\n Numero de buses: Empresa N°1 : " + numberOfBuses[0]
						+ "\n Nombre: empresa N°2 : " + nameOfTheBusiness[1] + "\n Numero de empleados: Empresa N°2 : "
						+ numberOfEmployees[1] + "\n Numero de buses: empresa N°2 : " + numberOfBuses[1]
						+ "\n Nombre: empresa N°3 : " + nameOfTheBusiness[2] + "\n Numero de empleados: empresa N°3 : "
						+ numberOfEmployees[2] + "\n Numero de buses: empresa N°3 : " + numberOfBuses[2]);
	}
	
	//Añadir empleado
	
	public void addEmployee() {

		for (int i = 0; i < nameOfTheEmployee.length; i++) {
			nameOfTheEmployee[i] = JOptionPane.showInputDialog("Ingrese el nombre del empleado: " + i);
		}
		manager.showMessage("Nombres agregados.");
		for (int j = 0; j < documentOfIdenty.length; j++) {
			documentOfIdenty[j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento de identidad del empleado: " + j));
		}
		manager.showMessage("Documentos agregados.");
		for (int j = 0; j < ageOfTheEmployee.length; j++) {
			ageOfTheEmployee[j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado: " + j));
		}
		manager.showMessage("Edades agregadas.");

	}
	
	//Modificar empleados
	
	public void modifyEmployee() {
		int em;
		em = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar. \n\n 1.Modificar nombre."+ "\n 2.Modificar documento de identidad.\n 3.Modificar edad.\n 4.Volver."));
		switch (em) {
		case 1:
			em = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del nombre a modificar: "));
			if (em >= nameOfTheEmployee.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				nameOfTheEmployee[em] = JOptionPane.showInputDialog("Ingrese el nuevo nombre del empleado: ");
			}
			manager.showMessage("Nombre modificado.");
			break;
		case 2:
			em = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del documento de identidad a modificar :"));
			if (em >= documentOfIdenty.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				documentOfIdenty[em] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo documento del empleado: " + em));
			}
			manager.showMessage("documento modificado.");
			break;
		case 3:
			em = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion de la edad a modificar :"));
			if (em >= ageOfTheEmployee.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				ageOfTheEmployee[em] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del empleado: " + em));
			}
			manager.showMessage("Edad modificada.");
			break;
		case 4:
			break;
		default:
			manager.showMessage("Seleccion incorrecta.");
			break;
		}

	}
	
	//Mostrar empleado
	
	public void showEmployee() {

		JOptionPane.showMessageDialog(null,"\nNombre: empleado  N°1 : " + nameOfTheEmployee[0] + "\n Numero de documento: empleado N°1 : " + documentOfIdenty[0]
						+ "\nEdad: empleado N°1 : " + ageOfTheEmployee[0]
						+ "\nNombre: empleado  N°2 : " + nameOfTheEmployee[1] + "\n Numero de documento: empleado  N°2 : "
						+ documentOfIdenty[1] + "\n Edad: empleado  N°2 : " + ageOfTheEmployee[1]
						+ "\nNombre: empleado N°3 : " + nameOfTheEmployee[2] + "\n Numero de documento: empleado  N°3 : "
						+ documentOfIdenty[2] + "\n Edad: empleado  N°3 : " + ageOfTheEmployee[2]);

	}
	
	
	//Añadir Bus
	
	public void createNewBus() {
		for (int i = 0; i < code.length; i++) {
			code[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del bus: " + i));
		}
		manager.showMessage("Codigos agregados.");
		for (int j = 0; j < licensePlate.length; j++) {
			licensePlate[j] = JOptionPane.showInputDialog("Ingrese la placa del bus: " + j);
		}
		manager.showMessage("Placas agregadas.");

	}
	
	//Modificar Bus
	
	public void modifyBus() {

		int bu;

		bu = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar. \n\n1.Modificar codigo." + "\n 2.Modificar placa.\n 3.Volver."));
		switch (bu) {
		case 1:
			bu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del codigo a modificar: " ));
			if (bu >= code.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				code[bu] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo codigo del bus: " + bu));
			}
			manager.showMessage("Codigo modificado.");
			break;
		case 2:
			bu = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la posicion de la placa a modificar :"));
			if (bu >= licensePlate.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			}
				else {
				licensePlate[bu] = JOptionPane.showInputDialog("Ingrese la nueva placa del bus: " + "[" + bu + "]");
			}
			manager.showMessage("Placa modificada.");
			break;

		case 3:
			break;
		default:
			manager.showMessage("Seleccion incorrecta.");
			break;
		}

	}
	
	//Mostrar Bus
	
	public void showBus() {
		JOptionPane.showMessageDialog(null,"Codigo: bus N°1 : " + code[0] + "\n Placa: bus N°1 : " + licensePlate[0]
						+ "\n Codigo: bus N°2 : " + code[1]
						+ "\n Placa: bus N°2 : " + licensePlate[1] 
						+ "\n Codigo: bus N°3 : " + code[2]
						+ "\n Placa: bus N°3 : " + licensePlate[2]);
	}
		
	//Añadir Ruta
	
	public void createNewRute() {
		for (int i = 0; i < startPoint.length; i++) {
			startPoint[i] = JOptionPane.showInputDialog("Ingrese el punto de partida: " + i);
		}
		manager.showMessage("Puntos de salida agregados.");

		for (int j = 0; j < finishPoint.length; j++) {
			finishPoint[j] = JOptionPane.showInputDialog("Ingrese el punto de llegada: " + j);
		}
		manager.showMessage("Puntos de llegada agregados.");

		for (int k = 0; k < kilometersOfTheRoute.length; k++) {
			kilometersOfTheRoute[k] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de kilometros que ocupa el recorrido de la ruta: " + k));
		}
		manager.showMessage("Kilometros agregados.");
		for (int k = 0; k < fuel.length; k++) {
			fuel[k] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la gasolina necesaria para el viaje: " + k));
		}
		manager.showMessage("gasolina necesaria añadida.");
	}
	
	//Modificar rutas
	
	public void modifyRute() {
		int ro;
		ro = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar. \n\n1.Modificar punto de partida."+ "\n 2.Modificar punto de llegada.\n3 .Modificar kilometros de la ruta \n 4.Modificar Galones de combustible del viaje. \n 5.Volver."));
		switch (ro) {
		case 1:
			ro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del punto de partida a modificar: "));
			if (ro >= startPoint.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				startPoint[ro] = String.valueOf(JOptionPane.showInputDialog("Ingrese el nuevo punto de salida: " + ro ));
			}
			manager.showMessage("punto de partida modificado.");
			break;
		case 2:
			ro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del punto de llegada a modificar :"));
			if (ro >= finishPoint.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				finishPoint[ro] = JOptionPane.showInputDialog("Ingrese el nuevo punto de llegada: " + ro );
			}
			manager.showMessage("punto de llegada modificado.");
			break;
		case 3:
			ro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion de los kilometros a modificar: "));
			if (ro >= kilometersOfTheRoute.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				kilometersOfTheRoute[ro] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo numero de kilometros de la ruta: " + ro ));
			}
			manager.showMessage("Kilometros modificados.");
			break;
		case 4:
			ro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion de los kilometros necesarios por modificar: "));
			if (ro >= fuel.length) {
				manager.showMessage("Ingrese una posicion correcta.");
			} else {
				fuel[ro] = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese los nuevos kilometros necesarios para la ruta: " + ro ));
			}
			manager.showMessage("kilometros necesarios modificados.");
			break;
		case 5:
			break;
		default:
			manager.showMessage("Seleccion incorrecta.");
			break;
		}

	}
	
	//Mostrar Rutas
	
	public void showRutes() {

		JOptionPane.showMessageDialog(null,"Ciudad de partida: ruta N° : " + startPoint[0] + "\n Ciudad de llegada: ruta N°1 : " + finishPoint[0]
						+ "\n Numero de kilometros: ruta N°1 : " + kilometersOfTheRoute[0] + "\n gasolina por viaje: ruta N°1 :"
						+ fuel[0]
						+ "\n punto de partida: ruta N°2 : " + startPoint[1] + "\n punto de llegada: ruta N°2 : "
						+ finishPoint[1] + "\n Numero de kilometros: ruta N°2 : " + kilometersOfTheRoute[1]
						+ "\n gasolina necesaria por viaje: ruta N°2 :" + fuel[1]
						+ "\n punto de partida: ruta  N°3 : " + startPoint[2]
						+ "\n punto de llegada: ruta  N°3 : " + finishPoint[2] + "\n Numero de kilometros: ruta  N°3 : "
						+ kilometersOfTheRoute[2] + "\n gasolina necesaria por viaje: ruta N°3 :" + fuel[2]);
	}
	
	//Empresa con mas empleados
	
	public int businessWithMostEmployees(int numberOfEmployees[]) {
		int temp = 0;
		int i, j;
		for (i = 0; i < numberOfEmployees.length; i++) {
			for (j = 0; j < i; j++) {
				if (numberOfEmployees[i] < numberOfEmployees[j]) {
					temp = numberOfEmployees[j];
					numberOfEmployees[j] = numberOfEmployees[i];
					numberOfEmployees[i] = temp;
				}
			}
			JOptionPane.showMessageDialog(null,"\n La empresa: " + nameOfTheBusiness[i] + " tiene " + numberOfEmployees[i] + " empleados.");
		}
		return temp;
	}
	
	//Empresa con mas buses
	
		public int businessWithMostBuses(int numberOfBuses[]) {
			int temp = 0;
			int i, j;
			for (i = 0; i < numberOfBuses.length; i++) {
				for (j = 0; j < i; j++) {
					if (numberOfBuses[i] < numberOfBuses[j]) {
						temp = numberOfBuses[j];
						numberOfBuses[j] = numberOfBuses[i];
						numberOfBuses[i] = temp;
					}
				}
				JOptionPane.showMessageDialog(null,	"\nLa empresa: " + nameOfTheBusiness[i] + " tiene " + numberOfBuses[i] + " buses.");
			}
			return temp;
		}
		
	
	//Empresa con mas rutas
	
	public int businessWithMostTours(int numberOfRutes[]) {
		int temp = 0;
		int i, j;
		for (i = 0; i < numberOfRutes.length; i++) {
			for (j = 0; j < i; j++) {
				if (numberOfRutes[i] < numberOfRutes[j]) {
					temp = numberOfRutes[j];
					numberOfRutes[j] = numberOfRutes[i];
					numberOfRutes[i] = temp;
				}
			}
			JOptionPane.showMessageDialog(null,
					"\n La empresa: " + nameOfTheBusiness[i] + " tiene " + numberOfRutes[i] + " buses.");
		}
		return temp;
	}
	
	//Empleados por edad
	
	public int employeesByAge(int ageOfTheEmployee[]) {
		int temp = 0;
		int i, j;
		for (i = 0; i < ageOfTheEmployee.length; i++) {
			for (j = 0; j < i; j++) {
				if (ageOfTheEmployee[i] < ageOfTheEmployee[j]) {
					temp = ageOfTheEmployee[j];
					ageOfTheEmployee[j] = ageOfTheEmployee[i];
					ageOfTheEmployee[i] = temp;
				}
			}
			JOptionPane.showMessageDialog(null,"\n El empleado " + nameOfTheEmployee[i] + " tiene " + ageOfTheEmployee[i] + " anios de edad.");
		}
		return temp;
	}
}