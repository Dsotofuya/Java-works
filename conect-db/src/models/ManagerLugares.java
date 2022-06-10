/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Andres Gonzalez
 */
public class ManagerLugares {
    
    private ArrayList<Lugar> placesList;

    public ManagerLugares() {
        placesList = new ArrayList<>();
    }
    
    public static Lugar createLugar(int ubicacion, String nombreLugar, String gentilisio, TipoLugar tipolugar){
        return new Lugar(ubicacion, nombreLugar, gentilisio, tipolugar);
    }
    
    public void addLugar(Lugar lugar){
        placesList.add(lugar);
    }

    public ArrayList<Lugar> getPlacesList() {
        return placesList;
    }
    
    public void setPlacesList(ArrayList<Lugar> placesList) {
    	this.placesList = placesList;
	}
    
    public Object[][] generateObjectsFromList() {
    	Object[][] grid = new Object[placesList.size()][5];
    	Object[] place = {"", "", "", "", ""};
        for(int i = 0; i < placesList.size(); i++) {
        	place[0] = placesList.get(i).getIdLugar();
        	place[1] = placesList.get(i).getUbicacion();
        	place[2] = placesList.get(i).getNombreLugar();
        	place[3] = placesList.get(i).getGentilisio();
        	place[4] = placesList.get(i).getTipolugar().toString();
                for(int j = 0; j < 5; j++)
                {
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
		newId = Arrays.stream(idVector).max().getAsInt() + 1;
		System.out.println(newId);
		return newId;
	}     
}
