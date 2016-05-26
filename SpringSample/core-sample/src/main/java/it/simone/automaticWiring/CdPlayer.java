package it.simone.automaticWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CdPlayer {

	private CompactDisk cd;
	
	@Autowired
	public CdPlayer(CompactDisk cd){
		this.cd = cd;
	}
	
	public void play(){
		cd.play();
	}
}
