package pro.abacus.javatutor.services;

import java.util.Collection;

import pro.abacus.javatutor.domain.JavaQuestion;

public interface JavaQuestionsService {

	public Collection<JavaQuestion> findAllQuestions();
	public void saveAllQuestions(Collection<JavaQuestion> javaQuestions);
}
