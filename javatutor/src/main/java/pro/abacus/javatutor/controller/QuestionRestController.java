package pro.abacus.javatutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.service.JavaQuestionsService;

import java.util.Collection;

/**
 * REST controller for managing java questions.
 */
@RestController
@RequestMapping("/api")
public class QuestionRestController {

	private JavaQuestionsService javaQuestionsService;

	@Autowired
	public QuestionRestController(JavaQuestionsService javaQuestionsService) {
		this.javaQuestionsService = javaQuestionsService;
	}

	/**
	 * GET /javaquestions : return java questions.
	 *
	 * @return collection of java questions
	 */
	@GetMapping(value = "/javaquestions")
	public Collection<JavaQuestion> readAllJavaQuestions() {
		return this.javaQuestionsService.findAllQuestions();
	}

	/**
	 * POST /javaquestions : save java questions.
	 *
	 * @param javaQuestions collection of java questions to be saved
	 */
	@PostMapping(value = "/javaquestions", consumes = "application/json")
	public void writeJavaQuestions(@RequestBody Collection<JavaQuestion> javaQuestions) {
		javaQuestionsService.saveAllQuestions(javaQuestions);

	}

}
