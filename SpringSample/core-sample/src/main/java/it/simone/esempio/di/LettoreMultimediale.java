package it.simone.esempio.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LettoreMultimediale {

	SupportoMultimediale supporto;

	@Autowired
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
