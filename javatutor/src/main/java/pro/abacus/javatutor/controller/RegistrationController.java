package pro.abacus.javatutor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.services.UserService;

/**
 * REST controller for users registration.
 */
@RestController
@RequestMapping("/api")
public class RegistrationController {

	final static Logger log = LoggerFactory.getLogger(RegistrationController.class);

	private UserService userService;

	@Autowired
	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * POST /signup : register the user.
	 */
	@PostMapping(value = "/signup", consumes = "application/json")
	public void registerUser(@RequestBody User user) {
		userService.saveAccount(user);
	}

	@GetMapping(value = "/signup")
	public @ResponseBody void register() {
	}

}
