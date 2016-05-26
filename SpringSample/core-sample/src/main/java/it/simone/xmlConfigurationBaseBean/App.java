package it.simone.xmlConfigurationBaseBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.*;

public class App 
{
    public static void main( String[] args )
    {
        
    	//Annotazione da utilizzare se i bean sono configurati nel file di configurazione xml
    	//ClassPathXmlApplicationContext context =	new ClassPathXmlApplicationContext("springContext.xml");
    	
    	//Annotazione da utilizzare se i bean sono configurati nella classe java
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigurationBean.class);
    	SpringFather father =(SpringFather) context.getBean("father");
    	father.printChildInfo();
    	
    	System.out.println( "Hello World!" );
    }
}
