package pro.abacus.javatutor.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import junitparams.JUnitParamsRunner;

import junitparams.FileParameters;
import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.domain.JavaQuestion;

@RunWith(SpringRunner.class)
@DataMongoTest
public class JavaQuestionsParameterizedTest {
	
	private JavaQuestion javaQuestion;
	private JavaQuestion javaQuestion2;
	
	private User account1;
	private User account2;
	private User account3;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	JavaQuestionRepository javaQuestionRepository;
	
	@Before
	public void setUp(){
		account1 = new User ("Tom","12345678");
		account2 = new User ("Ann","98765421");
		account3 = new User ("Jeremy","12345678");
		javaQuestion = new JavaQuestion(account1, "question1", "answer1");
		javaQuestion2 = new JavaQuestion(account2, "question2", "answer2");
		
	}
	
	/*@After
	public void tearDown(){
		mongoTemplate.getDb().drop();
	}*/
	
	@Test
	public void shouldLookUpQuestionsByAccount(){
		
		mongoTemplate.save(javaQuestion);
		mongoTemplate.save(javaQuestion2);
		List<JavaQuestion> listOfQuestions =javaQuestionRepository.findByAccountUsername("Tom");
		assertEquals("question1",listOfQuestions.get(0).getQuestion());
		assertEquals("answer1", listOfQuestions.get(0).getAnswer());
	}

}

