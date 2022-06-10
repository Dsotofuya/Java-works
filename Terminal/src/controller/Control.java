package controller;

import view.Vision;

import javax.swing.JOptionPane;

import model.*;

public class Control {

	private Vision vision;
	private Company[] enterprise;
	private Routes[] roads;
	private Bus[] buses;
	private Employee[] employees;
	private String[] companyName;
	private int[] numberEmployees;
	private int[] numberBuses;
	private String[] departure;
	private String[] destiny;
	private double[] kilometers;
	private int[] fuelPerKilometer;
	private int[] code;
	private String[] licensePlate;
	private String[] firstName;
	private long[] docId;
	private int[] age;

	public Control() {

		vision = new Vision();
		enterprise = new Company[5];
		roads = new Routes[5];
		buses = new Bus[5];
		employees = new Employee[5];
		companyName = new String[5];
		numberEmployees = new int[5];
		numberBuses = new int[5];
		departure = new String[5];
		destiny = new String[5];
		kilometers = new double[5];
		fuelPerKilometer = new int[5];
		code = new int[5];
		licensePlate = new String[5];
		firstName = new String[5];
		docId = new long[5];
		age = new int[5];
	}

	public void headerMenu() {

		int op = 0;

		do {
			op = vision.readHeaderMenu();

			switch (op) {
			case 1:
				companysInfo();
				break;
			case 2:
				routesInfo();
				break;
			case 3:
				busesInfo();
				break;
			case 4:
				employeesInfo();
				break;
			case 5:
				break;
			default:
				vision.showErrorMessage("Seleccion incorrecta.");
				break;
			}
		} while (op != 5);

	}

	public void companysInfo() {

		int co;

		co = 0;

		do {
			co = vision.readCompany();

			switch (co) {
			case 1:
				addCompany();
				break;
			case 2:
				printCompany();
				break;
			case 3:
				modifyCompany();
				break;
			case 4:
				companysForMoreRoutes(co);
				break;
			case 5:
				companysWithMoreBuses(numberBuses);
				break;
			case 6:
				companysWithMoreEmployees(numberEmployees);
				break;
			case 7:
				break;
			default:
				vision.showErrorMessage("Seleccion incorrecta.");
				break;
			}
		} while (co != 7);

	}

	public void addCompany() {

		for (int i = 0; i < companyName.length; i++) {

			companyName[i] = JOptionPane.showInputDialog("Ingrese el nombre de la empresa: " + i);

		}
		vision.showMessage("Empresas agregadas.");

		for (int j = 0; j < numberEmployees.length; j++) {
			numberEmployees[j] = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese numero de empleados de la empresa: " + j));
		}
		vision.showMessage("Empleados agregados.");

		for (int k = 0; k < numberBuses.length; k++) {
			numberBuses[k] = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese numero de buses de la empresa: " + k));

		}
		vision.showMessage("Buses agregados.");

	}

	//Imprimir compañias
	public void printCompany() {

		JOptionPane.showMessageDialog(null,

				"Nombre: empresa [1] : " + companyName[0] + "\nNumero de empleados: empresa [1] : " + numberEmployees[0]
						+ "\nNumero de buses: empresa [1] : " + numberBuses[0] + "\n-----------------------------------"
						+ "\nNombre: empresa [2] : " + companyName[1] + "\nNumero de empleados: empresa [2] : "
						+ numberEmployees[1] + "\nNumero de buses: empresa [2] : " + numberBuses[1]
						+ "\n-----------------------------------" + "\nNombre: empresa [3] : " + companyName[2]
						+ "\nNumero de empleados: empresa [3] : " + numberEmployees[2]
						+ "\nNumero de buses: empresa [3] : " + numberBuses[2] + "\n-----------------------------------"
						+ "\nNombre: empresa [4] : " + companyName[3] + "\nNumero de empleados: empresa [4] : "
						+ numberEmployees[3] + "\nNumero de buses: empresa [4] : " + numberBuses[3]
						+ "\n-----------------------------------" + "\nNombre: empresa [5] : " + companyName[4]
						+ "\nNumero de empleados: empresa [5] : " + numberEmployees[4]
						+ "\nNumero de buses: empresa [5] : " + numberBuses[4]);
	}

	public void modifyCompany() {

		int co;

		co = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar.\n\n1.Modificar nombre de la empresa."
				+ "\n2.Modificar numero de empleados.\n3.Modificar numero de buses\n4.Volver."));

		switch (co) {
		case 1:
			co = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la posicion del nombre de la empresa a modificar: " + "\n(Entre 0 y 4)"));
			if (co >= companyName.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				companyName[co] = String.valueOf(
						JOptionPane.showInputDialog("Ingrese el nuevo nombre de la empresa: " + "[" + co + "]"));
			}
			vision.showMessage("Nombre de la empresa modificado.");
			break;
		case 2:
			co = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la posicion numeros de empleados a modificar :" + "\n(Entre 0 y 4)"));
			if (co >= numberEmployees.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				numberEmployees[co] = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese el nuevo numero de empleados: " + "[" + co + "]"));
			}
			vision.showMessage("Numero de empleados modificado.");
			break;
		case 3:
			co = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la posicion numeros de buses a modificar: " + "\n(Entre 0 y 4)"));
			if (co >= numberBuses.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				numberBuses[co] = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo numero de buses: " + "[" + co + "]"));
			}
			vision.showMessage("Numero de buses modificado.");
			break;
		case 4:
			break;
		default:
			vision.showErrorMessage("Seleccion incorrecta.");
			break;
		}

	}

	public void companysForMoreRoutes(int roads) {

	}

	public int companysWithMoreBuses(int numberBuses[]) {

		int buffer = 0;
		int i, j;

		for (i = 0; i < numberBuses.length; i++) {
			for (j = 0; j < i; j++) {
				if (numberBuses[i] < numberBuses[j]) {
					buffer = numberBuses[j];
					numberBuses[j] = numberBuses[i];
					numberBuses[i] = buffer;

				}
			}
			JOptionPane.showMessageDialog(null,
					"\nLa empresa: " + companyName[i] + " tiene " + numberBuses[i] + " buses.");
		}
		return buffer;

	}

	public int companysWithMoreEmployees(int numberEmployees[]) {

		int buffer = 0;
		int i, j;

		for (i = 0; i < numberEmployees.length; i++) {
			for (j = 0; j < i; j++) {
				if (numberEmployees[i] < numberEmployees[j]) {
					buffer = numberEmployees[j];
					numberEmployees[j] = numberEmployees[i];
					numberEmployees[i] = buffer;

				}
			}
			JOptionPane.showMessageDialog(null,
					"\nLa empresa: " + companyName[i] + " tiene " + numberEmployees[i] + " empleados.");
		}
		return buffer;

	}

	public void routesInfo() {

		int ro = 0;

		do {
			ro = vision.readRoutes();

			switch (ro) {

			case 1:
				addRoutes();
				break;
			case 2:
				printRoutes();
				break;
			case 3:
				modifyRoutes();
				break;
			case 4:
				break;
			default:
				vision.showErrorMessage("Seleccion incorrecta.");
				break;
			}
		} while (ro != 4);

	}

	public void addRoutes() {

		for (int i = 0; i < departure.length; i++) {

			departure[i] = JOptionPane.showInputDialog("Ingrese la ciudad de partida: " + i);

		}
		vision.showMessage("Ciudades agregadas.");

		for (int j = 0; j < destiny.length; j++) {
			destiny[j] = JOptionPane.showInputDialog("Ingrese la ciudad de llegada: " + j);
		}
		vision.showMessage("Ciudades agregadas.");

		for (int k = 0; k < kilometers.length; k++) {
			kilometers[k] = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese numero de kilometros para el viaje: " + k));

		}
		vision.showMessage("Kilometros agregados.");
		for (int k = 0; k < fuelPerKilometer.length; k++) {
			fuelPerKilometer[k] = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese los galones de gasolina para el viaje: " + k));

		}
		vision.showMessage("Galones agregados.");

	}

	public void printRoutes() {

		JOptionPane.showMessageDialog(null,

				"Ciudad de partida: ruta [1] : " + departure[0] + "\nCiudad de llegada: ruta [1] : " + destiny[0]
						+ "\nNumero de kilometros: ruta [1] : " + kilometers[0] + "\nGalones por viaje: ruta [1] :"
						+ fuelPerKilometer[0] + "\n-----------------------------------"
						+ "\nCiudad de partida: ruta [2] : " + departure[1] + "\nCiudad de llegada: ruta [2] : "
						+ destiny[1] + "\nNumero de kilometros: ruta [2] : " + kilometers[1]
						+ "\nGalones por viaje: ruta [2] :" + fuelPerKilometer[1]
						+ "\n-----------------------------------" + "\nCiudad de partida: ruta [3] : " + departure[2]
						+ "\nCiudad de llegada: ruta [3] : " + destiny[2] + "\nNumero de kilometros: ruta [3] : "
						+ kilometers[2] + "\nGalones por viaje: ruta [3] :" + fuelPerKilometer[2]
						+ "\n-----------------------------------" + "\nCiudad de partida: ruta [4] : " + departure[3]
						+ "\nCiudad de llegada: ruta [4] : " + destiny[3] + "\nNumero de kilometros: ruta [4] : "
						+ kilometers[3] + "\nGalones por viaje: ruta [4] :" + fuelPerKilometer[3]
						+ "\n-----------------------------------" + "\nCiudad de partida: ruta [4] : " + departure[4]
						+ "\nCiudad de llegada: ruta [4] : " + destiny[4] + "\nNumero de kilometros: ruta [4] : "
						+ kilometers[4] + "\nGalones por viaje: ruta [4] :" + fuelPerKilometer[4]);
	}

	public void modifyRoutes() {

		int ro;

		ro = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar.\n\n1.Modificar ciudad de partida."
				+ "\n2.Modificar ciudad de llegada.\n3.Modificar kilometros de la ruta\n4.Modificar Galones de combustible del viaje.\n5.Volver."));

		switch (ro) {
		case 1:
			ro = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la posicion de la ciudad de partida a modificar: " + "\n(Entre 0 y 4)"));
			if (ro >= departure.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				departure[ro] = String.valueOf(
						JOptionPane.showInputDialog("Ingrese el nuevo nombre de la ciudad: " + "[" + ro + "]"));
			}
			vision.showMessage("Nombre de la ciudad modificado.");
			break;
		case 2:
			ro = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la posicion de la ciudad de llegada a modificar :" + "\n(Entre 0 y 4)"));
			if (ro >= destiny.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				destiny[ro] = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la ciudad: " + "[" + ro + "]");
			}
			vision.showMessage("Nombre de la ciudad modificado.");
			break;
		case 3:
			ro = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la posicion de los kilometros a modificar: " + "\n(Entre 0 y 4)"));
			if (ro >= kilometers.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				kilometers[ro] = Integer.parseInt(JOptionPane
						.showInputDialog("Ingrese el nuevo numero de kilometros de la ruta: " + "[" + ro + "]"));
			}
			vision.showMessage("Kilometros modificados.");
			break;
		case 4:
			ro = Integer.parseInt(JOptionPane.showInputDialog(
					"Ingrese la posicion de los galones de combustible a modificar: " + "\n(Entre 0 y 4)"));
			if (ro >= fuelPerKilometer.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				fuelPerKilometer[ro] = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese los nuevos galones para la ruta: " + "[" + ro + "]"));
			}
			vision.showMessage("Galones modificados.");
			break;
		case 5:
			break;
		default:
			vision.showErrorMessage("Seleccion incorrecta.");
			break;
		}

	}

	public void busesInfo() {

		int bu = 0;

		do {
			bu = vision.readBuses();

			switch (bu) {
			case 1:
				addBus();
				break;
			case 2:
				printBus();
				break;
			case 3:
				modifyBus();
				break;
			case 4:
				break;
			default:
				vision.showErrorMessage("Seleccion incorrecta.");
				break;
			}
		} while (bu != 4);

	}

	public void addBus() {

		for (int i = 0; i < code.length; i++) {

			code[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del bus: " + i));

		}
		vision.showMessage("Codigos agregados.");

		for (int j = 0; j < licensePlate.length; j++) {
			licensePlate[j] = JOptionPane.showInputDialog("Ingrese la placa del bus: " + j);
		}
		vision.showMessage("Placas agregadas.");

	}

	public void printBus() {
		JOptionPane.showMessageDialog(null,

				"Codigo: bus [1] : " + code[0] + "\nPlaca: bus [1] : " + licensePlate[0] +

						"\n-----------------------------------" + "\nCCodigo: bus [2] : " + code[1]
						+ "\nnPlaca: bus [2] : " + licensePlate[1] +

						"\n-----------------------------------" + "\nCodigo: bus [3] : " + code[2]
						+ "\nnPlaca: bus [3] : " + licensePlate[2] +

						"\n-----------------------------------" + "\nCodigo: bus [4] : " + code[3]
						+ "\nnPlaca: bus [4] : " + licensePlate[3] +

						"\n-----------------------------------" + "\nCodigo: bus [4] : " + code[4]
						+ "\nnPlaca: bus [4] : " + licensePlate[4]);

	}

	public void modifyBus() {

		int bu;

		bu = Integer.parseInt(JOptionPane
				.showInputDialog("Selecion a modificar.\n\n1.Modificar codigo." + "\n2.Modificar placa.\n3.Volver."));

		switch (bu) {
		case 1:
			bu = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la posicion del codigo a modificar: " + "\n(Entre 0 y 4)"));
			if (bu >= code.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				code[bu] = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo codigo del bus: " + "[" + bu + "]"));
			}
			vision.showMessage("Codigo modificado.");
			break;
		case 2:
			bu = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la posicion de la placa a modificar :" + "\n(Entre 0 y 4)"));
			if (bu >= licensePlate.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				licensePlate[bu] = JOptionPane.showInputDialog("Ingrese la nueva placa del bus: " + "[" + bu + "]");
			}
			vision.showMessage("Placa modificada.");
			break;

		case 3:
			break;
		default:
			vision.showErrorMessage("Seleccion incorrecta.");
			break;
		}

	}

	public void employeesInfo() {

		int em = 0;

		do {
			em = vision.readEmployees();

			switch (em) {
			case 1:
				addEmployees();
				break;
			case 2:
				printEmployees();
				break;
			case 3:
				modifyEmployees();
				break;
			case 4:
				employeesForAge(age);
				break;
			case 5:
				salary(em);
				break;
			case 6:
				printSalary(em);
				break;
			case 7:
				break;
			default:
				vision.showErrorMessage("Seleccion incorrecta.");
				break;
			}
		} while (em != 7);

	}

	public void addEmployees() {

		for (int i = 0; i < firstName.length; i++) {

			firstName[i] = JOptionPane.showInputDialog("Ingrese el nombre del empleado: " + i);

		}
		vision.showMessage("Nombres agregados.");

		for (int j = 0; j < docId.length; j++) {
			docId[j] = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese el documento de identidad del empleado: " + j));
		}
		vision.showMessage("Documentos agregados.");
		for (int j = 0; j < age.length; j++) {
			age[j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado: " + j));
		}
		vision.showMessage("Edades agregadas.");

	}

	public void printEmployees() {

		JOptionPane.showMessageDialog(null,

				"\nNombre: empleado [1] : " + firstName[0] + "\nNumero de documento: empleado [1] : " + docId[0]
						+ "\nEdad: empleado [1] : " + age[0] + "\n-----------------------------------"
						+ "\nNombre: empleado [2] : " + firstName[1] + "\nNumero de documento: empleado [2] : "
						+ docId[1] + "\nEdad: empleado [2] : " + age[1] + "\n-----------------------------------"
						+ "\nNombre: empleado [3] : " + firstName[2] + "\nNumero de documento: empleado [3] : "
						+ docId[2] + "\nEdad: empleado [3] : " + age[2] + "\n-----------------------------------"
						+ "\nNombre: empleado [4] : " + firstName[3] + "\nNumero de documento: empleado [4] : "
						+ docId[3] + "\nEdad: empleado [4] : " + age[3] + "\n-----------------------------------"
						+ "\nNombre: empleado [5] : " + firstName[4] + "\nNumero de documento: empleado [5] : "
						+ docId[4] + "\nEdad: empleado [5] : " + age[4]);

	}

	public void modifyEmployees() {

		int em;

		em = Integer.parseInt(JOptionPane.showInputDialog("Selecion a modificar.\n\n1.Modificar nombre."
				+ "\n2.Modificar documento de identidad.\n3.Modificar edad.\n4.Volver."));

		switch (em) {
		case 1:
			em = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la posicion del nombre a modificar: " + "\n(Entre 0 y 4)"));
			if (em >= firstName.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				firstName[em] = JOptionPane.showInputDialog("Ingrese el nuevo nombre del empleado: " + "[" + em + "]");
			}
			vision.showMessage("Nombre modificado.");
			break;
		case 2:
			em = Integer.parseInt(JOptionPane.showInputDialog(
					"Ingrese la posicion del documento de identidad a modificar :" + "\n(Entre 0 y 4)"));
			if (em >= docId.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				docId[em] = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese el nuevo documento del empleado: " + "[" + em + "]"));
			}
			vision.showMessage("documento modificado.");
			break;

		case 3:
			em = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la posicion de la edad a modificar :" + "\n(Entre 0 y 4)"));
			if (em >= age.length) {
				vision.showErrorMessage("Ingrese una posicion correcta.");
			} else {
				age[em] = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del empleado: " + "[" + em + "]"));
			}
			vision.showMessage("Edad modificada.");
			break;
		case 4:
			break;
		default:
			vision.showErrorMessage("Seleccion incorrecta.");
			break;
		}

	}

	public int employeesForAge(int age[]) {

		int buffer = 0;
		int i, j;

		for (i = 0; i < age.length; i++) {
			for (j = 0; j < i; j++) {
				if (age[i] < age[j]) {
					buffer = age[j];
					age[j] = age[i];
					age[i] = buffer;

				}
			}
			JOptionPane.showMessageDialog(null,
					"\nEl empleado " + firstName[i] + " tiene " + age[i] + " años de edad.");
		}
		return buffer;

	}

	public void salary(int kilometers) {

		for (int i = 0; i < firstName.length; i++) {

			kilometers = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese los kilometros acumulados de: " + firstName[i]));
			int salary = kilometers * 700000 / 100;

			if (kilometers > 5) {

				vision.showMessage("El salario del empleado " + firstName[i] + " es : " + salary);

			} else {
				vision.showErrorMessage("El empleado debe tener minimo 5 kilometros recorridos");
			}

		}
	}

	public void printSalary(int salary) {

		JOptionPane.showMessageDialog(null,

				"Salario de los empleados por kilometros. " + "\n-----------------------------------" + "\n"
						+ firstName[0] + ", salario: " + salary + "\n-----------------------------------" + "\n"
						+ firstName[1] + ", salario: " + salary + "\n-----------------------------------" + "\n"
						+ firstName[2] + ", salario: " + salary + "\n-----------------------------------" + "\n"
						+ firstName[3] + ", salario: " + salary + "\n-----------------------------------" + "\n"
						+ firstName[4] + ", salario: " + salary);
	}

}
