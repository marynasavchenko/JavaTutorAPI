package pro.abacus.javatutor.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

@RestController
@RequestMapping("/api")
public class QuestionRestController {

	private JavaQuestionRepository javaQuestionRepository;

	@Autowired
	public QuestionRestController(JavaQuestionRepository javaQuestionRepository) {
		this.javaQuestionRepository = javaQuestionRepository;
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(value = "/javaquestions")
	public Collection<JavaQuestion> readAllJavaQuestions() {
		return this.javaQuestionRepository.findAll();
	}

	@PostMapping(value = "/javaquestions", consumes = "application/json")
	public void writeJavaQuestions(@RequestBody Collection<JavaQuestion> javaQuestions) {
		javaQuestionRepository.saveAll(javaQuestions);

	}

}
