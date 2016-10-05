package it.simone.esempio.converters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import it.simone.esempio.converters.model.Person;
import it.simone.esempio.converters.model.PersonData;
import it.simone.esempio.converters.model.PersonEntity;

@Configuration
@ComponentScan
public class BeanConfiguration {

	@Bean
	ConversionService conversionService()
	{
		DefaultConversionService registry = new DefaultConversionService();
		registry.addConverter((Converter<PersonData, PersonEntity>)new PersonDataToPersonEntity());
		registry.addConverter((Converter<PersonEntity, Person>)new PersonEntityToPerson()); 
		return registry;
	}
}
