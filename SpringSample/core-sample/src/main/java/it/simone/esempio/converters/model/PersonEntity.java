package it.simone.esempio.converters.model;

public class PersonEntity {
	
	long id;
	String code;
	String name;
	String surname;
	int age;
	
	public PersonEntity(){
		
	}
	
	public PersonEntity(String name, String surname, int age){
		this.id=id;
		this.code=code;
		this.name=name;
		this.surname=surname;
		this.age=age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "PersonEntity Object: "+this.name+"; "+this.surname+"; "+this.age+"; "+this.code;	
	}
}
