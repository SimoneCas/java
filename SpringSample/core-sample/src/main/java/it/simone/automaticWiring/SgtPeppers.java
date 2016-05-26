package it.simone.automaticWiring;

import org.springframework.stereotype.*;

@Component
public class SgtPeppers implements CompactDisk{
	
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	
	public void play(){
		System.out.println("Playing " + title + " by " + artist);
	}
}
