package mvcsample.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import mvcsample.exception.DuplicateUserSaveException;
import mvcsample.exception.UserNotFoundException;
import mvcsample.model.User;
import mvcsample.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ "/users" })
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserController() {
	}

	@RequestMapping(value = "/{userName}", method = GET)
	public String showUserByName(Model model,
			@PathVariable("userName") String name) {
		User user = userRepository.findOneByName(name);
		if (user == null )
			throw new UserNotFoundException();
		model.addAttribute(user);
		return "user";
	}

	@RequestMapping(method = GET)
	public String users(Model model,
			@RequestParam(value = "count", defaultValue = "5") int count) {
		List<User> userList = userRepository.findUsers(Long.MAX_VALUE, count);
		model.addAttribute("userList", userList);
		return "users";
	}

	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(User user) {
		userRepository.save(user);
		return "redirect:/users/" + user.getName();
	}
	
	@ExceptionHandler(DuplicateUserSaveException.class)
	public String handleDuplicateUser(){
		return "error/duplicate";
	}
}
