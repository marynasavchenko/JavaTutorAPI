package pro.abacus.javatutor.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pro.abacus.javatutor.domain.Account;
import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.AccountRepository;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

@RestController
@RequestMapping("/api")
public class QuestionRestController {
	
	private JavaQuestionRepository javaQuestionRepository;
	private AccountRepository accountRepository;
	
	@Autowired
	public QuestionRestController(JavaQuestionRepository javaQuestionRepository, AccountRepository accountRepository){
		this.javaQuestionRepository = javaQuestionRepository;
		this.accountRepository=accountRepository;
	}
	@GetMapping(value ="/javaquestions")
	public Collection<JavaQuestion> readAllJavaQuestions(){
		return this.javaQuestionRepository.findAll();
	}	
	
	@PostMapping(value ="/javaquestions", consumes="application/json")
	public void writeJavaQuestions(@RequestBody Collection<JavaQuestion> javaQuestions){
		javaQuestionRepository.saveAll(javaQuestions);
		
	}
	
	//get all javaquestions
	@GetMapping(value ="/{userId}/javaquestions")
	public Collection<JavaQuestion> readJavaQuestions(@PathVariable String userId){
		return this.javaQuestionRepository.findByAccountUsername(userId);
	}	
	
	@PostMapping(value="/signup", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Account registerUser(@RequestBody Account account) {
		
		return accountRepository.save(account);
	}
	
	@GetMapping(value="/signup")
	public void register() {}

}
