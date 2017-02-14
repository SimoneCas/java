package it.simonecasamassa.spring.restsample.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import it.simonecasamassa.spring.restsample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import it.simonecasamassa.spring.restsample.exceptions.UserNotFoundException;
import it.simonecasamassa.spring.restsample.model.RegisterResponse;
import it.simonecasamassa.spring.restsample.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";


	private UserRepository userRepository;
	
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping( method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<User> users(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "3") int count) {
		return userRepository.findUsers(max, count);
	}
	
	@RequestMapping(value = "/{userName}", method = GET, produces="application/json")
	public /*@ResponseBody*/ User showUserByName(Model model,
			@PathVariable("userName") String name) {
		
		if(!name.equals("simone")) 
			throw new UserNotFoundException(name);
			
		User user = new User();
		user.setName(name);
		user.setSurname("Benedetti");
		return user;
	}
	
	@RequestMapping(value="/register", method = POST, produces="application/json", consumes="application/json")
	public /*@ResponseBody*/ RegisterResponse registerUser(@RequestBody User user){
		
		userRepository.save(user);
		
		RegisterResponse response = new RegisterResponse();
		response.setId(12548);
		response.setRisposta("Utente registrato");
		return response;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Error userNotFound(UserNotFoundException e) {
		String name = e.getNameNotFound();
		
		return new Error("User [" + name + "] not found");
		}
}
