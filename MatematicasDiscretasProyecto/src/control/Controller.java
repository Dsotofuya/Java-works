package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.GrafoModel;
import structures.Place;
import view.Events;
import view.View;

public class Controller implements ActionListener {
    private View view;
    private GrafoModel gModel;

    public Controller() throws Exception{
        this.gModel = new GrafoModel();
        loadTestData();
        this.view = new View(this, this);
    }

    public void actionPerformed(ActionEvent e){
        try {
            switch (Events.valueOf(e.getActionCommand())) {
                case SHOW_TIME_FLY:
                    view.reload();
                    view.showResult(gModel.calculateShortestRoad(new Place<String>(view.selection1), new Place<String>(view.selection2)));
                    break;
            
                default:
                    break;
            }
        } catch (Exception ex) {
        }
    }

    public String calculateShortestRoad(Place<String> nodoInicio, Place<String> nodoDestino) {
		return gModel.calculateShortestRoad(nodoInicio, nodoDestino);		
	}

    public void loadTestData() {
		gModel.newPlace("Tunja");
		gModel.newPlace("Bogota");
		gModel.newPlace("Cali");
		gModel.newPlace("Medellin");
		gModel.newPlace("Barranquilla");

		gModel.route("Tunja", "Bogota", 15);
		gModel.route("Bogota", "Tunja", 15);
		gModel.route("Bogota", "Barranquilla", 150);
		gModel.route("Barranquilla", "Bogota", 150);
		gModel.route("Tunja", "Medellin", 90);
		gModel.route("Medellin", "Tunja", 90);
		gModel.route("Medellin", "Cali", 50);
		gModel.route("Cali", "Medellin", 50);
		gModel.route("Cali", "Barranquilla", 50);
		gModel.route("Barranquilla", "Cali", 50);
	}

    public Place<String>[] getNodeList(){
        return gModel.getNodeList();
    }

    public static void main(String[] args) {
        try {
            new Controller();
        } catch (Exception e) {
        }
	}
}
