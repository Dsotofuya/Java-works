/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Andres Gonzalez
 */
public class Lugar {
    private static int counter;
    
    private int idLugar, ubicacion;
    private String nombreLugar, gentilisio;
    private TipoLugar tipolugar;

    public Lugar(int ubicacion, String nombreLugar, String gentilisio, TipoLugar tipolugar) {
        counter++;
        this.idLugar = counter;
        this.ubicacion = ubicacion;
        this.nombreLugar = nombreLugar;
        this.gentilisio = gentilisio;
        this.tipolugar = tipolugar;
    }
    
    public Lugar(int idLugar,int ubicacion, String nombreLugar, String gentilisio, TipoLugar tipolugar) {
        
        this.idLugar = idLugar;
        this.ubicacion = ubicacion;
        this.nombreLugar = nombreLugar;
        this.gentilisio = gentilisio;
        this.tipolugar = tipolugar;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public String getGentilisio() {
        return gentilisio;
    }

    public TipoLugar getTipolugar() {
        return tipolugar;
    }

	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", ubicacion=" + ubicacion + ", nombreLugar=" + nombreLugar
				+ ", gentilisio=" + gentilisio + ", tipolugar=" + tipolugar + "]";
	}
    
    
}
