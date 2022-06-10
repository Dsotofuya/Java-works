package model;

import structures.Grafo;
import structures.Place;

public class GrafoModel {

	static Grafo<String> grafo;
	private NumberComparator compare = new NumberComparator();

	public GrafoModel() {
		grafo = new Grafo<String>(compare);
	}

	public void route(String u, String v) {
		grafo.route(new Place<String>(u), new Place<String>(v));
	}

	public void route(String u, String v, int w) {
		grafo.route(new Place<String>(u), new Place<String>(v), w);
	}

	public void deleteRoute(String u, String v) {
		grafo.deleteRoute(new Place<String>(u), new Place<String>(v));
	}

	public boolean neigthboor(String u, String v) {
		return grafo.adyacente(new Place<String>(u), new Place<String>(v));
	}

	public void newPlace(String u) {
		grafo.newPlace(new Place<String>(u));
	}

	public void deletePlace(String u) {
		grafo.deletePlace(new Place<String>(u));
	}

	public String iterateWidth(Place<String> u) {
		return grafo.iterateWidth(u);
	}

	public Place<String>[] getNodeList(){
		return grafo.getNodeList();
	}

	public String calculateShortestRoad(Place<String> nodoInicio, Place<String> nodoDestino) {
		return grafo.calculateShortestRoad(nodoInicio, nodoDestino);		
	}
}
