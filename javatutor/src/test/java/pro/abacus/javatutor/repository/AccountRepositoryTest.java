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

import pro.abacus.javatutor.domain.Account;
import pro.abacus.javatutor.domain.Authority;
import pro.abacus.javatutor.repository.AccountRepository;

@RunWith(SpringRunner.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class AccountRepositoryTest {
	
	private Account account;
	
	private Authority authority;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	AccountRepository accountRepository;
	
	 @Before
	    public void setUp() {
		 authority = new Authority("user");
		 HashSet<Authority> authorities = new HashSet<>();
		 authorities.add(authority);
		 account = new Account("Ann","1234pass", authorities);
	    }

	   /*@After
	    public void tearDown() {
	    	mongoTemplate.getDb().drop();
	    }*/
	
	@Test
	public void shouldLookUpSavedAccount(){
		
		mongoTemplate.save(account);
		Account foundAccount =accountRepository.findByUsername("Ann");
		assertEquals("1234pass", foundAccount.getPassword());
	}
	

}
