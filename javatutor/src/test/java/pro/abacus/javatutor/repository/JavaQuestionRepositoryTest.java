package pro.abacus.javatutor.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.domain.JavaQuestion;
import pro.abacus.javatutor.repository.JavaQuestionRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class JavaQuestionRepositoryTest {
	
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
	public void setUp(){
		account = new User ("Tom","12345678");
		account2 = new User ("Brigette","12345678");
		javaQuestion = new JavaQuestion(account,"question1","answer1");
		javaQuestion2 = new JavaQuestion(account,"question2","answer2");
		questionList = new ArrayList<JavaQuestion>();
		questionList.add(javaQuestion);
		questionList.add(javaQuestion2);
	}
	
	@After
	public void tearDown(){
		mongoTemplate.getDb().drop();
	}
	
	@Test
	public void shouldFindAllQuestions() throws Exception{
		mongoTemplate.save(javaQuestion);
		mongoTemplate.save(javaQuestion2);
		List<JavaQuestion> foundQuestions =javaQuestionRepository.findAll();
		assertEquals(2,foundQuestions.size());
		assertEquals("question1",foundQuestions.get(0).getQuestion());
	}
	
	@Test
	public void shouldSaveAllQuestions() throws Exception{
		javaQuestionRepository.saveAll(questionList);
		
		List<JavaQuestion> foundQuestions =javaQuestionRepository.findAll();
		assertEquals(2,foundQuestions.size());
		assertEquals("question1",foundQuestions.get(0).getQuestion());
	}
	
	@Test
	public void shouldLookUpQuestionsByAccount() throws Exception{
		mongoTemplate.save(javaQuestion);
		mongoTemplate.save(javaQuestion2);
		List<JavaQuestion> foundQuestions =javaQuestionRepository.findByAccountUsername("Tom");
		assertEquals("question1",foundQuestions.get(0).getQuestion());
		assertEquals("answer1", foundQuestions.get(0).getAnswer());
	}

}
