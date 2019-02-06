package pro.abacus.javatutor.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.domain.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class JavaQuestionRepositoryTest {

	private static final String USER_NAME_1 = "Tom";
	private static final String PASSWORD_1 = "12345678";
	private static final String USER_NAME_2 = "Bridgette";
	private static final String PASSWORD_2 = "22345678";
	private static final String QUESTION_1 = "question1";
	private static final String QUESTION_2 = "question2";
	private static final String ANSWER_1 = "answer1";
	private static final String ANSWER_2 = "answer2";

	private JavaQuestion javaQuestion;
	private JavaQuestion javaQuestion2;
	private List<JavaQuestion> questionList;

	private User account;
	private User account2;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	JavaQuestionRepository javaQuestionRepository;

	@Before
	public void setUp() {
		account = new User(USER_NAME_1, PASSWORD_1);
		account2 = new User(USER_NAME_2, PASSWORD_2);
		javaQuestion = new JavaQuestion(account, QUESTION_1, ANSWER_1);
		javaQuestion2 = new JavaQuestion(account, QUESTION_2, ANSWER_2);
		questionList = new ArrayList<>();
		questionList.add(javaQuestion);
		questionList.add(javaQuestion2);
	}

	@After
	public void tearDown() {
		mongoTemplate.getDb().drop();
	}

	@Test
	public void shouldFindAllQuestions() throws Exception {
		mongoTemplate.save(javaQuestion);
		mongoTemplate.save(javaQuestion2);
		List<JavaQuestion> foundQuestions = javaQuestionRepository.findAll();
		assertEquals(2, foundQuestions.size());
		assertEquals(QUESTION_1, foundQuestions.get(0).getQuestion());
	}

	@Test
	public void shouldSaveAllQuestions() throws Exception {
		javaQuestionRepository.saveAll(questionList);

		List<JavaQuestion> foundQuestions = javaQuestionRepository.findAll();
		assertEquals(2, foundQuestions.size());
		assertEquals(QUESTION_1, foundQuestions.get(0).getQuestion());
	}

	@Test
	public void shouldLookUpQuestionsByAccount() throws Exception {
		mongoTemplate.save(javaQuestion);
		mongoTemplate.save(javaQuestion2);
		List<JavaQuestion> foundQuestions = javaQuestionRepository.findByAccountUsername(USER_NAME_1);
		assertEquals(QUESTION_1, foundQuestions.get(0).getQuestion());
		assertEquals(ANSWER_1, foundQuestions.get(0).getAnswer());
	}

}
