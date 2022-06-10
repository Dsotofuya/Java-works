import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class test {
	
	public static void main(String[] args) throws IOException {
		test test = new test();
		test.generateText1();
		test.generateText2();
		test.generateText3();
		test.readText2();
	}	
	
	public void generateText1() throws IOException {
		String[ ]  datos = {"hola", "que", "tal"};
		FileWriter fuente = new FileWriter("IODemo.txt");
		for	(int i=0; i<datos.length; i++){
		fuente.write(i + ": " + datos[i] + "\n");
		}
		fuente.close();
	}
	
	public void generateText2() throws FileNotFoundException {
		String[ ] datos = {"hola", "we", "xdxd"};
		PrintWriter	procesador = new PrintWriter("IODemo2.txt");
		for(int i=0; i<	datos.length; i	++){
		procesador.println(i+ ": " + datos[i]);
		}
		procesador.close();
	}
	
	public void generateText3() throws IOException { //mas optimo
		String[ ] datos = {"hola", "men", "k", "pex"};
		FileWriter fuente = new FileWriter("IODemo3.txt");
		PrintWriter	procesador = new PrintWriter(fuente);
		for	(int i=0; i< datos.length; i++){
		procesador.println(i + ": " + datos[i]);
		}
		procesador.close();
	}
	
	public void readText1() throws IOException { 
		FileReader fuente = new FileReader("C://Users//acwin7ra-01//eclipse-workspace//Archivos planos Ej1//IODemo3.txt") ;
		int caracterLeido;
		while ((caracterLeido = fuente.read()) !=-1) {
			System.out.println(/*Muestra el ascii del caracter */caracterLeido + ": " + (char)caracterLeido);
		} fuente.close();
	}
	
	public void readText2() throws IOException {
		FileReader fuente  = new FileReader("IODemo.txt"); 
		BufferedReader procesador = new BufferedReader(fuente); 
		String	leido;
		while((leido = procesador.readLine()) !=null){
		System.out.println(leido);
		}
		procesador.close(); 
	}
	
	
}
