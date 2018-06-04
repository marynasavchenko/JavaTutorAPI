package pro.abacus.javatutor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.services.AccountService;

@RestController
@RequestMapping("/api")
public class RegistrationController {
	
	final static Logger log = LoggerFactory.getLogger( RegistrationController.class);

	private AccountService accountService;

	@Autowired
	public RegistrationController(AccountService accountService) {
		this.accountService=accountService;
	}

	@PostMapping(value = "/signup", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@RequestBody User account) {
		return accountService.saveAccount(account);
	}

	@GetMapping(value = "/signup")
	public @ResponseBody void register() {
	}

	@PostMapping(value = "/signin", consumes = "application/json")
	public void processAccount( @RequestBody @AuthenticationPrincipal User account) {
		log.trace("signing in..." + account.getUsername().toString());
		
	}
	
	@GetMapping(value = "/signin")
	public void signin() {
		log.trace("signing in... get");
	}

}
