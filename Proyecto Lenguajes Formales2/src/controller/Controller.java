package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.AutomataFinitoDImple;
import model.Estado;
import model.FuncionTransicion;
import model.IAutomataFinito;
import view.MyFrame;

public class Controller implements ActionListener {

	private IAutomataFinito iAutomata;
	private MyFrame view;

	public Controller() {
		iAutomata = new AutomataFinitoDImple();
		view = new MyFrame(this, iAutomata.getEstados());
	}

	@Override
	public void actionPerformed(ActionEvent even) {
		switch (even.getActionCommand()) {
		case "ADD_ALFABETO": {
			String alfabeto = view.getAlfabeto();
			if (!alfabeto.isEmpty()) {
				iAutomata.agregarAlfabeto(alfabeto);
				System.out.println(alfabeto);
			} else {
				view.showDialog("El alfabeto esta vacio");
			}
			break;
		}
		case "ADD_ESTADO": {
			Estado estado = view.getEstado();
			if (estado == null) {
				return;
			}
			System.out.println("Agregado: _" + estado.toString());
			iAutomata.agregarEstados(estado);
			view.fillEstadosInicialesCheck(iAutomata.getEstados());
			view.showDialog("Agregado estado correctamente");
			view.updateGrafo(iAutomata.getEstados());
			break;
		}
		case "ADD_FUNCION": {
			if (view.getTextFuncion().isEmpty()) {
				return;
			}
			char text = view.getTextFuncion().toCharArray()[0];

			if (text == ' ') {
				view.showDialog("No hay letra en el la función. Intentelo de nuevo.");
			}
			Estado estadoIni = iAutomata.seachEstado(view.getEstadoInitFuncion());
			Estado estadoFin = iAutomata.seachEstado(view.getEstadoFinishFuncion());
			if (estadoIni == null || estadoFin == null) {
				return;
			}
             FuncionTransicion funcionTransicion = new FuncionTransicion(text, estadoIni, estadoFin);
			iAutomata.agregarFunciones(funcionTransicion);
			view.showDialog("Agregada Funcion correctamente");
			view.updateGrafo(iAutomata.getEstados());
			break;
		}
		case "COMPARAR": {
			String text = view.getComprar();
			if (!text.isEmpty()) {
				
				Object[] resultado = iAutomata.evaluarCadena(text, 1);

				if (resultado == null) {
					view.showDialog("Llene primero el automata. No se puede comparar.");
					return;
				}

				if ((boolean) resultado[0]) {
					view.showDialog("Estados recorridos: " + resultado[1].toString() + ", pertenece al alfabeto");
				} else {
					view.showDialog("Estados recorridos: " + resultado[1].toString() + ", NO pertenece al alfabeto");
				}

			} else {
				view.showDialog("No se compraran textos vacios");
			}

			break;
		}

		}

	}
	
	public IAutomataFinito getiAutomata() {
		return iAutomata;
	}
}
