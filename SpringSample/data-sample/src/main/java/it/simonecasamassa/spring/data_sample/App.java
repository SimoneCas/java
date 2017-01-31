package it.simonecasamassa.spring.data_sample;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import it.simonecasamassa.spring.config.BeanConfig;
import it.simonecasamassa.spring.entity.PersonTB;
import it.simonecasamassa.spring.repository.PersonRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        EntityManagerFactory emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
        System.out.println("EntityManagerFactory configurato");
        
        PersonRepository personRepo = (PersonRepository) context.getBean("personRepository");
        PersonTB person = new PersonTB();
        person = (PersonTB) personRepo.findOneByName("Simone");
        System.out.println("Cognome"+person.getSurname());
        
        PersonTB person2 = new PersonTB();
        person2.setName("Mario");
        person2.setSurname("Aossi");
        person2.setAge(25);
        int count = personRepo.findAll().size();
        System.out.println("Numero persone in tabella (prima salvataggio): "+count);
        personRepo.save(person2);
        
        PersonTB person3 = new PersonTB();
        person3.setName("Claudio");
        person3.setSurname("Atori");
        person3.setAge(25);
        int count2 = personRepo.findAll().size();
        System.out.println("Numero persone in tabella (prima salvataggio): "+count2);
        personRepo.save(person3);
        
        List<PersonTB> people2 = personRepo.findAll();
        count = people2.size();
        System.out.println("Numero persone in tabella (dopo salvataggio): "+count);
        for(PersonTB pers: people2){
        	System.out.println("Surname : "+ pers.getSurname());
        }
        
        List<PersonTB> people = personRepo.findByAgeOrName(25,"Simone");
        count = people.size();
        System.out.println("Numero persone trovate con metodo readpeopleByNameOrAge: "+count);
        for(PersonTB pers: people){
        	System.out.println("Surname : "+ pers.getSurname());
        }
        
        
        //CUSTOM QUERY EXAMPLE
        List<PersonTB> people3 = personRepo.customQuery();
        count = people3.size();
        System.out.println("Numero persone trovate con metodo customQuery: "+count);
        for(PersonTB pers: people3){
        	System.out.println("Surname : "+ pers.getSurname());
        }
        
      //CUSTOM NATIVE QUERY EXAMPLE
        List<PersonTB> people4 = personRepo.customQuery();
        count = people4.size();
        System.out.println("Numero persone trovate con metodo customNativeQuery: "+count);
        for(PersonTB pers: people4){
        	System.out.println("Surname : "+ pers.getSurname());
        }
        
        
        
    }
}
