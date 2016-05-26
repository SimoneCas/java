package it.simone.javaWiring;

import it.simone.automaticWiring.CdPlayer;
import it.simone.automaticWiring.CompactDisk;
import it.simone.automaticWiring.SgtPeppers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CdPlayerConfigJava {

	// @Bean(name="lonelyHeartsClubBand") se voglio dichiarare esplicitamente l'id
	@Bean  //id automatico del bean compactDisk
	public CompactDisk sgtPeppers(){
		return new SgtPeppers();
	}
	
	/*
	 * QUESTA forma può essere non chiara perchè a prima occhiata sembra che si stia richiamando il metodo e non che
	 * venga passato il bean da spring- sotto altro metodo
	@Bean
	public CdPlayer cdPlayer() {
	return new CdPlayer(sgtPeppers());
	}
	*/
	
	@Bean
	public CdPlayer cdPlayer(CompactDisk compactDisc) {
	return new CdPlayer(compactDisc);
	}
}
