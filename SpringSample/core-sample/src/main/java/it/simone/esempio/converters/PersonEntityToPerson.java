package it.simone.esempio.converters;

import org.springframework.core.convert.converter.Converter;

import it.simone.esempio.converters.model.Person;
import it.simone.esempio.converters.model.PersonEntity;

public class PersonEntityToPerson implements Converter<PersonEntity, Person>{
	
	public Person convert(PersonEntity source) {
		Person person = new Person();
		person.setAge(source.getAge());
		person.setName(source.getName()+" "+source.getSurname());
		return person;
	}

}
