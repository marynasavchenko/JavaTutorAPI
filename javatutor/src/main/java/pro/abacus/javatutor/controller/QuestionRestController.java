package pro.abacus.javatutor.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.AccountRepository;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

@RestController
@RequestMapping("/{userId}/javaquestions")
public class QuestionRestController {
	
	private JavaQuestionRepository javaQuestionRepository;
	private AccountRepository accountRepository;
	
	@Autowired
	public QuestionRestController(JavaQuestionRepository javaQuestionRepository, AccountRepository accountRepository){
		this.javaQuestionRepository = javaQuestionRepository;
		this.accountRepository=accountRepository;
	}
	
	//get all javaquestions
	@GetMapping
	public Collection<JavaQuestion> readJavaQuestions(@PathVariable String userId){
		return this.javaQuestionRepository.findByAccountUsername(userId);
	}	

}
