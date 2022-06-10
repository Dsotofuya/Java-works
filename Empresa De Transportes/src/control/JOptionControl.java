package control;

import view.*;
import model.dao.ControlEmpresa;

public class JOptionControl {
	private Vista vista;
	private ControlEmpresa controlEmpresa;
	public JOptionControl() {
		vista = new Vista();
		controlEmpresa = new ControlEmpresa();
	}

	public void menu() {

		int op = 0;
		do {
			op = vista.showMenu();
			switch (op) {
			case 1:
				controlEmpresa.createConductor(0, null);
				break;
			case 2:
				controlEmpresa.createRuta(0, 0, null, null);
				break;
			case 3:
				subMenu();
				break;
			case 4:
				vista.showMessage(controlEmpresa.imprimirConductor());
				break;
			case 5:
				vista.showMessage(controlEmpresa.imprimirRuta());
				break;
			case 6:
				mostrarMenu();
				break;
			case 7:
				break;
			default:
				vista.showMessage("Opcion incorrecta, ingrese un numero entre 1 y 7");
			}

		} while (op != 7);
	}
	
	public void subMenu() {

		int op = 0;
		do {
			op = vista.readMenu();
			switch (op) {
			case 1:
				controlEmpresa.createTaxi(null, 0, false, false, null, null, null); controlEmpresa.asignarTaxi();
				break;
			case 2:
				controlEmpresa.createBus(null, 0, false, false, null, null, null); controlEmpresa.asignarBus();
				break;
			case 3:
				controlEmpresa.createBuseta(null, 0, 0, 0, null, null, null); controlEmpresa.asignarBuseta();
				break;
			case 4:
				break;
			default:
				vista.showMessage("Opcion incorrecta, ingrese un numero entre 1 y 4");
			}

		} while (op != 4);
	}
	
	public int	mostrarMenu(){
		int op = 0;
		do {
			op = vista.mostrarMenu();
			switch (op) {
			case 1:
				vista.showMessage(controlEmpresa.imprimirBus());
				break;
			case 2:
				vista.showMessage(controlEmpresa.imprimirBuseta());
				break;
			case 3:
				vista.showMessage((controlEmpresa.imprimirTaxi()));
				break;
			case 4:
				break;
			default:
				vista.showMessage("Opcion incorrecta, ingrese un numero entre 1 y 4");
			}

		} while (op != 4);
		return op;
	}
}
