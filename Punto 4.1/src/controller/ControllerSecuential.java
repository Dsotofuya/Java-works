package controller;

import modelsSecuential.Machine;

//Clase conectora entre el run y la clase Machine
public class ControllerSecuential {
	
	public ControllerSecuential(int programs) {
		new Machine(programs);
		
	}

}
