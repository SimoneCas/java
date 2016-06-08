package it.simone.esempio.javaDi;


public class Vhs implements SupportoMultimediale {

	private String titolo;
	private String descrizione;
	private int durata;

	public Vhs() {
		this.titolo = "VHS - Il Gladiatore";
		this.descrizione = "Film del 2000 diretto da Ridley Scott";
		this.durata = 155;
	}

	public String play() {
		return ("Titolo: " + this.titolo + ", descrizione: "
				+ this.descrizione + ", durata: " + this.durata + " minuti.");
	}

}
