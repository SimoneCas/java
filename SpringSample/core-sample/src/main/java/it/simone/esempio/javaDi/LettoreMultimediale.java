package it.simone.esempio.javaDi;


public class LettoreMultimediale {

	SupportoMultimediale supporto;

	public LettoreMultimediale(SupportoMultimediale supporto) {
		this.supporto = supporto;
	}

	public String play() {
		String lettura = supporto.play();
		System.out.println(lettura);
		
		if(lettura.contains("DVD"))
			return "NEW";
			else
				return "OLD";
	}

}
