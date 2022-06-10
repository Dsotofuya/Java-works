package control;

import logic.Eraser;

public class ControlErase {
	private String [] dates;
	private String [] datesUno;
	private String [] datesDos;
	private String [] datesTres;
	
	public ControlErase() {
		dates = new String [3];
		datesUno = new String [3];
		datesDos = new String [3];
		datesTres = new String [3];
	}
	
	public int [] initObjeto(){
		Eraser eraser = new Eraser();
		eraser.setName("Norma");
		eraser.setPrice(350.0);
		eraser.setSize(5);
		
		dates[0] = eraser.getName();
		dates[1] = String.valueOf(eraser.getPrice());
		dates[2] = String.valueOf(eraser.getSize());
		
		Eraser eraserUno = new Eraser();
		eraserUno.setName("Trencito");
		eraserUno.setPrice(50.0);
		eraserUno.setSize(7);
		
		datesUno[0] = eraserUno.getName();
		datesUno[1] = String.valueOf(eraserUno.getPrice());
		datesUno[2] = String.valueOf(eraserUno.getSize());
		
		Eraser eraserDos = new Eraser();
		eraserDos.setName("Miga de pan");
		eraserDos.setPrice(450.0);
		eraserDos.setSize(7);
		
		datesDos[0] = eraserDos.getName();
		datesDos[1] = String.valueOf(eraserDos.getPrice());
		datesDos[2] = String.valueOf(eraserDos.getSize());
	
		Eraser eraserTres = new Eraser();
		eraserTres.setName("faber castell");
		eraserTres.setPrice(1050.0);
		eraserTres.setSize(5);
		
		datesTres[0] = eraserTres.getName();
		datesTres[1] = String.valueOf(eraserTres.getPrice());
		datesTres[2] = String.valueOf(eraserTres.getSize());
		
		int [] prices = new int [4];
		prices[0] = eraser.getSize();
		prices[1] = eraserUno.getSize();
		prices[2] = eraserDos.getSize();
		prices[3] = eraserTres.getSize();
		
		return prices;
 	}
	
	public String [][]  matriz(){
		String [][] resultado = new String [4][3]; 
		
		resultado[0] = dates;
		resultado[1] = datesUno;
		resultado[2] = datesDos;
		resultado[3] = datesTres;
		
		return resultado;
	}
	
	public void printMatriz(String [][] matriz){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+"          ");
			}
			System.out.println();
		}
	}
	
	public void printErase (String [] dates){
		
		for (int i = 0; i < dates.length; i++) {
			System.out.println(dates[i]);
		}
	}

	public  int sumaVector (int [] vector){
		int resultado = 0;
		
		for (int i = 0; i < vector.length; i++) {
			resultado = resultado + vector[i];
		}
		
		return resultado;
	}
	
	public String[] getDates() {
		return dates;
	}

	public void setDates(String[] dates) {
		this.dates = dates;
	}

	public String[] getDatesUno() {
		return datesUno;
	}

	public void setDatesUno(String[] datesUno) {
		this.datesUno = datesUno;
	}

	public String[] getDatesDos() {
		return datesDos;
	}

	public void setDatesDos(String[] datesDos) {
		this.datesDos = datesDos;
	}

	public String[] getDatesTres() {
		return datesTres;
	}

	public void setDatesTres(String[] datesTres) {
		this.datesTres = datesTres;
	}
	
}
