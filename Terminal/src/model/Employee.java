package model;

public class Employee {

	private String firstName;
	private long docId;
	private int age;

	public Employee() {
		firstName = " ";
		docId = 000;
		age = 0;

	}

	public Employee(String firstName, long docId, int age) {
		this.firstName = firstName;
		this.docId = docId;
		this.age = age;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
