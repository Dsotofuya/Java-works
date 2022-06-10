package Utilies;

import java.util.Random;

public class Utilities {

	//Arreglo de sentencias quemadas 
	private String[] sentences = { "Abriendo archivo...",
			" Entrando al archivo...", "Cambiando el modo de acceso para abrir arhivo", "Estado de modo lectura/escritura",
			" xd", "SO Es lo maximo", "El lugar de memoria donde esta la variable es variable khe",
			" cd .. ", "Hola", "intentando abrir el archivo", " Modificando el archivo", "llamando interrupcion DOS",
			" error vamos a explotar", " dir desktop", "si no paso SO", " leer 123", " error:c", " ; ....", "\r\n",
			" leer archivo", " leer:", " mov bx", "handle", " mov cx", "5", " mov dx", "offset leido", " mov ah", "3fh",
			" int 21h", " ;cerramos archivo", " mov bx, handle", " mov ah, 3eh", " int 21h",
			" ;imprimir el contenido de leido", " mov dx, offset leido", " mov ah, 9", " int 21h", " ret",
			"archivo db \"C:\\prueba.txt\", 0 ;ascii del nombre del archivo",
			"leyendo db ", "handle dw ? ;identificador del arhivo" };

	//Generación y asignación aleatoria de las sentencias de cada programa, de un valor hasta de 30 sentencias
	public String[] generateSentences() {
		Random random = new Random();
		String[] sentens = new String[random.nextInt(30)];
		for (int i = 0; i < sentens.length; i++) {
			sentens[i] = sentences[random.nextInt(sentences.length)];
		}
		return sentens;
	}
}
