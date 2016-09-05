package it.simonecasamassa.spring.restsample.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import it.simonecasamassa.spring.restsample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.simonecasamassa.spring.restsample.model.User;

@Controller
@RequestMapping("/users")
public class UserController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<User> users(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "3") int count) {
		return userRepository.findUsers(max, count);
	}
	
	@RequestMapping(value = "/{userName}", method = GET, produces="application/json")
	public @ResponseBody User showUserByName(Model model,
			@PathVariable("userName") String name) {
		/*
		User user = userRepository.findOneByName(name);
		if (user == null )
			throw new Exception(); //da migliorare poi caso dell'eccezione
		*/
		User user = new User();
		user.setName(name);
		user.setSurname("Cognome");
		return user;
	}
}
