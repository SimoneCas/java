package it.simone.esempio.converters;

import org.springframework.core.convert.converter.Converter;

import it.simone.esempio.converters.model.PersonData;
import it.simone.esempio.converters.model.PersonEntity;

public final class PersonDataToPersonEntity implements Converter<PersonData, PersonEntity> {

	public PersonEntity convert(PersonData source) {
		PersonEntity entity = new PersonEntity(source.getName(), source.getSurname(), source.getAge());
		entity.setCode(source.getName()+source.getAge()+source.getSurname());
		return entity;
	}

}
