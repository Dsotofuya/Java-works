package model;

import java.util.ArrayList;

public interface IAutomataFinito {
	
	public void agregarEstados(Estado estado);
	
	public void agregarFunciones(FuncionTransicion estado);
	
	public void agregarAlfabeto(String alfabeto);
	
	public Object[] evaluarCadena(String cadena,  int tipoAutomata); 
	
	public Estado seachEstado(String nameEstado);
	
	public ArrayList<Estado> getEstados();
}
