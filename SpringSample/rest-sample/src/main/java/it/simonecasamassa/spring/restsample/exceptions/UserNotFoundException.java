package it.simonecasamassa.spring.restsample.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,
				reason="User Not Found")
public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1259L;
	private String nameNotFound;
	
	public UserNotFoundException(String name){
		this.nameNotFound = name;
	}
	
	public String getNameNotFound(){
		return this.nameNotFound;
	}
	
}
