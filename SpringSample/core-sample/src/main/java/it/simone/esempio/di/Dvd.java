package it.simone.esempio.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dvd implements SupportoMultimediale {

	private String titolo;
	private String descrizione;
	private int durata;

	
	public Dvd(){
		this.titolo = "DVD - Matrix";
		this.descrizione = " Film di fantascienza del 1999";
		this.durata = 136;
	}
	
	public String play() {
		return ("Titolo: " + this.titolo + ", descrizione: "
				+ this.descrizione + ", durata: " + this.durata + " minuti.");
	}

}
