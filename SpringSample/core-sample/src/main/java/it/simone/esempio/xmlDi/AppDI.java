package it.simone.esempio.xmlDi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDI {

	
	
	public static void main (String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beanSpringXmlConfiguration.xml");
		LettoreMultimediale lettore = (LettoreMultimediale) context.getBean("lettoreMultimediale"); 
		lettore.play();
		
		((ConfigurableApplicationContext) context).close();
	}
}
