package it.simone.esempio.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDI {

	
	
	public static void main (String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		LettoreMultimediale lettore = (LettoreMultimediale) context.getBean("lettoreMultimediale"); 
		lettore.play();
	}
}
