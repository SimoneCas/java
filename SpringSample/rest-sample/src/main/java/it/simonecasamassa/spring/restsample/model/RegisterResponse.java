package it.simonecasamassa.spring.restsample.model;

public class RegisterResponse {

	private int id;
	private String risposta;
	
	public RegisterResponse(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
}
