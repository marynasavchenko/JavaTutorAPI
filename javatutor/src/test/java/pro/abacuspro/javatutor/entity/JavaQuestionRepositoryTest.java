package pro.abacuspro.javatutor.entity;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class JavaQuestionRepositoryTest {
	
	private JavaQuestion javaQuestion;
	
	private Account account;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	JavaQuestionRepository javaQuestionRepository;
	
	@Before
	public void setUp(){
		account = new Account ();
		javaQuestion = new JavaQuestion(account,"question1","answer1");
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void shouldLookUpQuestionsByAccount(){
		mongoTemplate.save(javaQuestion);
		List<JavaQuestion> listOfQuestions =javaQuestionRepository.findByAccount(account);
		assertEquals("question1",listOfQuestions.get(0).getQuestion());
	}

}
