package it.simone.esempio.converters.model;

public class PersonData {

	String name;
	String surname;
	int age;
	
	public PersonData(){
		
	}
	
	public PersonData(String name, String surname, int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "PersonData Object: "+this.name+"; "+this.surname+"; "+this.age;	
	}
}
