package it.simone.esempio.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;

import it.simone.esempio.converters.model.Person;
import it.simone.esempio.converters.model.PersonData;
import it.simone.esempio.converters.model.PersonEntity;

@Component
public class ConverterTest {
	
	@Autowired
	ConversionService cs;
	
	public void test(PersonData pd){
		System.out.println("***"+pd.toString());
		System.out.println("#########################################");
		PersonEntity pe = cs.convert(pd, PersonEntity.class);
		System.out.println("PersonEntity convertita a partire dall'oggetto PersonData");
		System.out.println(pe.toString());
		System.out.println("#########################################");
		
		Person person = cs.convert(pe, Person.class);
		System.out.println("Person convertita a partire dall'oggetto PersonEntity");
		System.out.println(person.toString());
	}
}
