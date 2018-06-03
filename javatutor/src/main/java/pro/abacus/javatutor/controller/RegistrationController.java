package pro.abacus.javatutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pro.abacus.javatutor.domain.Account;
import pro.abacus.javatutor.repository.AccountRepository;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	private AccountRepository accountRepository;

	@Autowired
	public RegistrationController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@PostMapping(value = "/signup", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Account registerUser(@RequestBody Account account) {
		return accountRepository.save(account);
	}

	@GetMapping(value = "/signup")
	public @ResponseBody void register() {
	}

	@PostMapping(value = "/signin", consumes = "application/json")
	public @ResponseBody void processAccount(Account account) {
		
		System.out.println("In signin ");
	}
	
	@GetMapping(value = "/signin")
	public @ResponseBody void signin() {
	}

}
