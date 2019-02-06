package pro.abacus.javatutor.service;

import pro.abacus.javatutor.domain.JavaQuestion;

import java.util.Collection;

/**
 * Service interface for managing Java Questions.
 */
public interface JavaQuestionsService {
	Collection<JavaQuestion> findAllQuestions();

	void saveAllQuestions(Collection<JavaQuestion> javaQuestions);
}
