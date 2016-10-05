package it.simone.esempio.converters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.simone.esempio.converters.BeanConfiguration;
import it.simone.esempio.converters.model.PersonData;

public class AppConverter {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		ConverterTest ct = (ConverterTest) context.getBean("converterTest"); 
		PersonData person = new PersonData("Simone", "Casamassa", 28);
		ct.test(person);
		
	}

}
