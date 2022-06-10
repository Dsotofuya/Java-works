package model;

public class Person {
	private int docId;
	private String firstName;
	private String lastName;
	
	// Metodos constructores
	
	public Person(){
	}
	
	public Person(int docId, String firstName, String lastName){
		setDocId(docId);
		setFirstName(firstName);
		setLastName(lastName);
		
		/* tambien es valido
		this.docId = docId;
		this.firstName = firstName;
		this.lastName = lastName;
		 */
	}
	
	// Metodos modificadores
	public void setDocId(int docId){
		this.docId = docId;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	// Metodos analizadores
	public int getDocId(){
		return docId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String toString(){
		return "Doc. Id: " + getDocId() +
				"\nNombre: " + getFirstName() +
				"\nApellido: " + getLastName();
	}
	
}









