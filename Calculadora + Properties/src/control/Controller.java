package control;

import model.Calculator;
import view.View;

public class Controller {
	
	private Calculator calculator;
	private View view;
	
	public Controller() {
		calculator = new Calculator();
		view = new View();
		runCalculator();
	}
	
	public void runCalculator(){
		int option = view.options();
		switch (option) {
		case 0:
			int x = view.takeDate("Primer dato");
			int y = view.takeDate("Segundo Dato");
			calculator.add(x, y);
			int repeat = view.showOutcome("resultado:");
			if(repeat == 0){
				view.options();
			}
			
			break;

		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
