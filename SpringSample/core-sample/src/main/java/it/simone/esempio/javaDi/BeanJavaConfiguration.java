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

	@Bean
	public LettoreMultimediale lettoreMultimediale(
			SupportoMultimediale supportoMultimediale) {
		return new LettoreMultimediale(supportoMultimediale);
	}
}
