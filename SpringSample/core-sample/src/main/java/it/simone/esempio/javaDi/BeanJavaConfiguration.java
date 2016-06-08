package it.simone.esempio.javaDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanJavaConfiguration {

	// @Bean(name="supportoMultimediale") se voglio dichiarare esplicitamente l'id
	// altrimenti l'id è il tipo ritornato con la prima lettera minuscola
	@Bean
	public SupportoMultimediale vhs() {
		return new Vhs();
	}
	
	/*
	 * QUESTA forma può essere non chiara perchè a prima occhiata sembra che si
	 * stia richiamando il metodo e non che venga passato il bean da spring-
	 * sotto altro metodo
	 * 
	 * @Bean 
	 * public CdPlayer cdPlayer() { return new CdPlayer(sgtPeppers()); }
	 */

	@Bean
	public LettoreMultimediale lettoreMultimediale(
			SupportoMultimediale supportoMultimediale) {
		return new LettoreMultimediale(supportoMultimediale);
	}
}
