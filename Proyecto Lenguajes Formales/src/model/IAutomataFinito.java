package model;

import java.util.List;

public interface IAutomataFinito {
	
	public void agregarEstados(Estado estado);
	
	public void agregarFunciones(FuncionTransicion estado);
	
	public void agregarAlfabeto(String alfabeto);
	
	public Object[] evaluarCadena(String cadena,  int tipoAutomata); 
	
	public Estado seachEstado(String nameEstado);
	
	public List<String> getEstados();
}
