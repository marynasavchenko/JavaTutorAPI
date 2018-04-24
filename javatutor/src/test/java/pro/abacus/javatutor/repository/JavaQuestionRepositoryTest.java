package pro.abacus.javatutor.repository;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import pro.abacus.javatutor.domain.Account;
import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class JavaQuestionRepositoryTest {
	
	private JavaQuestion javaQuestion;
	private JavaQuestion javaQuestion2;
	
	private Account account;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	JavaQuestionRepository javaQuestionRepository;
	
	@Before
	public void setUp(){
		account = new Account ("Tom","12345678");
		javaQuestion = new JavaQuestion(account,"question1","answer1");
		javaQuestion2 = new JavaQuestion(account,"question2","answer2");
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
