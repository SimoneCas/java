package it.simone.esempio.javaDi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDI {

	
	
	public static void main (String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanJavaConfiguration.class);
		LettoreMultimediale lettore = (LettoreMultimediale) context.getBean("lettoreMultimediale"); 
		lettore.play();
		
		((ConfigurableApplicationContext) context).close();
	}
}
