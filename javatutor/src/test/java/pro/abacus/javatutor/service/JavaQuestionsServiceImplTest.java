package pro.abacus.javatutor.service;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

@RunWith(MockitoJUnitRunner.class)
public class JavaQuestionsServiceImplTest {

	private JavaQuestionsService javaQuestionService;

	private ArrayList<JavaQuestion> javaQuestions;

	@Mock
	private JavaQuestionRepository javaQuestionRepository;

	@Before
	public void setup() {
		javaQuestionService = new JavaQuestionsServiceImpl(javaQuestionRepository);
		javaQuestions = new ArrayList<JavaQuestion>();
	}

	@Test
	public void shouldFindAllQuestions() {
		javaQuestionService.findAllQuestions();
		verify(javaQuestionRepository).findAll();
	}

	@Test
	public void shouldSaveAllQuestions() throws Exception {
		javaQuestionService.saveAllQuestions(javaQuestions);
		verify(javaQuestionRepository).saveAll(javaQuestions);
	}

}
