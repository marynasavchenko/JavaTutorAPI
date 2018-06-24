package pro.abacus.javatutor.services;

import java.util.Collection;

import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

public class JavaQuestionsServiceImpl implements JavaQuestionsService {

	private JavaQuestionRepository javaQuestionRepository;

	public JavaQuestionsServiceImpl(JavaQuestionRepository javaQuestionRepository) {
		this.javaQuestionRepository = javaQuestionRepository;
	}

	@Override
	public Collection<JavaQuestion> findAllQuestions() {
		return javaQuestionRepository.findAll();
	}

	@Override
	public void saveAllQuestions(Collection<JavaQuestion> javaQuestions) {
		javaQuestionRepository.saveAll(javaQuestions);
	}

}
