package pro.abacus.javatutor.repository;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.domain.Authority;
import pro.abacus.javatutor.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class UserRepositoryTest {
	
	private User account;
	
	private Authority authority;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	UserRepository accountRepository;
	
	 @Before
	    public void setUp() {
		 authority = new Authority("user");
		 HashSet<Authority> authorities = new HashSet<>();
		 authorities.add(authority);
		 account = new User("Ann","1234pass", authorities);
	    }

	   /*@After
	    public void tearDown() {
	    	mongoTemplate.getDb().drop();
	    }*/
	
	@Test
	public void shouldLookUpSavedAccount(){
		
		mongoTemplate.save(account);
		User foundAccount =accountRepository.findByUsername("Ann");
		assertEquals("1234pass", foundAccount.getPassword());
	}
	

}
