package model;

import java.util.ArrayList;
import java.util.List;

public class AutomataFinitoDImple implements IAutomataFinito{

	private ArrayList<Estado> estados;
	private ArrayList<Character> listaAlfabeto;

	public AutomataFinitoDImple() {
		estados = new ArrayList<Estado>();
		listaAlfabeto = new ArrayList<Character>();
	}

	@Override
	public void agregarEstados(Estado estado) {
		estados.add(estado);
		System.out.println(estado.toString());
	}

	@Override
	public void agregarFunciones(FuncionTransicion funcion) {
		for (Estado estado : estados) {
			if (estado.equals(funcion.getEstadoInicial())) {
				for (char letra : listaAlfabeto) {
					if (funcion.getLetter() == letra) {
						estado.addTansactyion(funcion);
					}
				}
			}
		}
	}

	@Override
	public void agregarAlfabeto(String alfabeto) {
		char[] letras = alfabeto.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			this.listaAlfabeto.add(letras[i]);
		}
	}

	@Override
	public Estado seachEstado(String nameEstado) {
		for (Estado estado : estados) {
			if (estado.getNombre().equals(nameEstado)) {
				return estado;
			}
		}
		return null;
	}

	@Override
	public Object[] evaluarCadena(String cadena, int tipoAutomata) {
		int posicion = 0;
		char[] letras = cadena.toCharArray();
		ArrayList<String> nombre = new ArrayList<>();
		
		for (Estado estado : estados) {
			if (estado.isInitial()) {
				if(tipoAutomata == 1) {
					return new Object[] {evaluarCadenaAux(letras, estado, posicion, nombre), nombre};
				}else {
					posicion = 0;
					nombre = new ArrayList<>();
					ArrayList<Estado> listEstados = new ArrayList<>();
					listEstados.add(estado);
					
					return new Object[] {auxEvaluarNoDeterminista(letras,listEstados, posicion, nombre), nombre};
				}
				
			}
		}
		return null;
	}

	private boolean evaluarCadenaAux(char[] letras, Estado estado, int posicion, ArrayList<String> nombres) {
		if (estado.isFinal()) {
			
			if(posicion == letras.length) {
				return true;
				
			}else {
				for (FuncionTransicion transaction : estado.getTranciociones()) {
					if (transaction.getLetter() == letras[posicion]) {
						nombres.add(estado.getNombre());
						int aux = posicion + 1;
						return evaluarCadenaAux(letras, transaction.getEstadoFinal(), aux, nombres);
					}
				}
			}
		}else{
			if(posicion <= letras.length) {
				for (FuncionTransicion transaction : estado.getTranciociones()) {
					if (transaction.getLetter() == letras[posicion]) {
						nombres.add(estado.getNombre());
						int aux = posicion + 1;
						return evaluarCadenaAux(letras, transaction.getEstadoFinal(), aux, nombres);
					}
				}
				
			}
		}
		return false;
	}

	@Override
	public List<String> getEstados() {
		List<String> estadosString = new ArrayList<String>();
		for(Estado estado : estados) {
			estadosString.add(estado.getNombre());
		}
		return estadosString;
	}
	
	private boolean auxEvaluarNoDeterminista(char[] letras, ArrayList<Estado> estado, int posicion, ArrayList<String> nombre) {
		for (Estado estaditos : estado) {
			if(estaditos.isFinal()){
				if(posicion == letras.length) {
					return true;
				}
			}
		}	
		
		ArrayList<Estado> estadoAux = new ArrayList<>(); 
		if(posicion <= letras.length) {
			for (Estado estaditos : estado) {
				for(FuncionTransicion transaction : estaditos.getTranciociones()) {
					if(transaction.getLetter() == letras[posicion]) {
						estadoAux.add(transaction.getEstadoFinal());
						
					}
				}
				
			}
			for(Estado aux : estadoAux) {
				nombre.add(aux.getNombre());
			}
			
			int aux = posicion+1;
			return auxEvaluarNoDeterminista(letras, estadoAux, aux, nombre);
		}
		
		return false;
	}
	
	

}
