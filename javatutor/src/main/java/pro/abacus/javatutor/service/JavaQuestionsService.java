package pro.abacus.javatutor.service;

import java.util.Collection;

import pro.abacus.javatutor.domain.JavaQuestion;

/**
 * Service interface for managing Java Questions.
 */
public interface JavaQuestionsService {

	public Collection<JavaQuestion> findAllQuestions();
	public void saveAllQuestions(Collection<JavaQuestion> javaQuestions);
}
