package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import connection.Connect;

public class ManagerPlaces {

	private Connect connect;
	private ArrayList<Place> placesList;

	public ManagerPlaces() throws SQLException {
		connect = new Connect();
		placesList = connect.getPlaces();
	}

	public static Place createPlace(int ubicacion, String nombreLugar, String gentilisio, TipoLugar tipolugar) {
		return new Place(ubicacion, nombreLugar, gentilisio, tipolugar);
	}

	public void addPlace(Place place) {
		placesList.add(place);
	}

	public Object[][] generateObjectsFromList() {
		Object[][] grid = new Object[placesList.size()][5];
		Object[] place = { "", "", "", "", "" };
		for (int i = 0; i < placesList.size(); i++) {
			place[0] = placesList.get(i).getIdLugar();
			if (placesList.get(i).getUbicacion() == -1) {
				place[1] = new String("null");
			} else {
				place[1] = placesList.get(i).getUbicacion();
			}
			place[2] = placesList.get(i).getNombreLugar();
			place[3] = placesList.get(i).getNacionalidad();
			place[4] = placesList.get(i).getTipolugar().toString();
			for (int j = 0; j < 5; j++) {
				grid[i][j] = new String(place[j].toString());
			}
		}
		return grid;
	}

	public int newPlaceId() {
		int newId = 0;
		int[] idVector = new int[placesList.size()];
		for (int i = 0; i < placesList.size(); i++) {
			idVector[i] = placesList.get(i).getIdLugar();
		}
		newId = Arrays.stream(idVector).max().getAsInt()+1;
		return newId;
	}

	public Place findPlaceById(int id_lugar) {
		Place auxPlace = null;
		for (Place place : placesList) {
			if (id_lugar == place.getIdLugar()) {
				auxPlace = place;
			}
		}
		return auxPlace;
	}

	public void removePlace(int id_lugar) {
		for (Place place : placesList) {
			if (id_lugar == place.getIdLugar()) {
				placesList.remove(place);
			}
		}
	}

	public void setPlacesList(ArrayList<Place> placesList) {
		this.placesList = placesList;
	}

	public ArrayList<Place> getPlacesList() {
		return placesList;
	}
}
