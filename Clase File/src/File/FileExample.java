package File;

import java.io.File;
import java.util.Date;

public class FileExample {
	
	
	public FileExample() {
		File file =  new File("src/zData/ModelList.txt");
		
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.exists() ? "Existe" : "No existe");
		System.out.println(file.canRead()? "Si":"no");
		System.out.println(file.canWrite()? "Si":"no");
		System.out.println("is " +(file.isDirectory() ? "" : "not") + " a directory");
		System.out.println(file.isFile() ? "is normal file" : "might be a named pipe"); //si esta llamando al archivo o a un acceso directo
		System.out.println(file.isAbsolute() ? "is absolute" : "is not absolute");	//Si es absoluto
		System.out.println("file last modified " + new Date(file.lastModified())); //ultima modificacion
		System.out.println("file size " + file.length() + " bytes"); //tamaño en bytes

		
		}
		
		public void returnDirectories(String ruta) {
//		String dirName="C:\\Users\\Usuario\\Desktop\\Progra 2";
		File file2 = new File(ruta);
		if (file2.isDirectory()) {
			System.out.println("didectorio de " + ruta );
			String list[] = file2.list();
			for (String string : list) {
				File file3 = new File(file2,string);
				if (file3.isDirectory()) {
					System.out.println(string + " Es un directorio");
					//ejecuta de nuevo, con ruta modificada
					String b = file3.getAbsolutePath();
					System.out.println(b);
					returnDirectories(b);
					
				}else {
					System.out.println(string + "Es un archivo");
				}
			}
		}
	}
	
		
	public static void main(String[] args) {
		FileExample f = new FileExample();
		f.returnDirectories("C:\\Users\\Usuario\\Desktop\\Progra 2");
	}
	
	
	
//	String dirName="/Users";
//	File file2 = new File(dirName);
//	if (file2.isDirectory()) {
//		System.out.println("didectorio de " + dirName );
//		String list[] = file2.list();
//		for (String string : list) {
//			File file3 = new File(file2,string);
//			if (file3.isDirectory()) {
//				System.out.println(string + " Es un directorio");
//				
//				//ejecuta de nuevo, con ruta modificada
//			}else {
//				System.out.println(string + "Es un archivo");
//			}
//		}
//	} else {
//		 System.out.println(dirName + "No es un directorio");
//		}	
}
