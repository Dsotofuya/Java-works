package models;

public class Place {
    private static int counter;
    
    private int idLugar, ubicacion;
    private String nombreLugar, nacionalidad;
    private TipoLugar tipolugar;

    public Place(int ubicacion, String nombreLugar, String nacionalidad, TipoLugar tipolugar) {
        counter++;
        this.idLugar = counter;
        this.ubicacion = ubicacion;
        this.nombreLugar = nombreLugar;
        this.nacionalidad = nacionalidad;
        this.tipolugar = tipolugar;
    }
    
    public Place(int idLugar,int ubicacion, String nombreLugar, String nacionalidad, TipoLugar tipolugar) {
        this.idLugar = idLugar;
        this.ubicacion = ubicacion;
        this.nombreLugar = nombreLugar;
        this.nacionalidad = nacionalidad;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public TipoLugar getTipolugar() {
        return tipolugar;
    }
}
