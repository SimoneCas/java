package it.simonecasamassa.spring.restsample.controller;

import java.util.List;

import it.simonecasamassa.spring.restsample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(method = RequestMethod.GET)
	public List<User> users(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "3") int count) {
		return userRepository.findUsers(max, count);
	}
}
