package pro.abacus.javatutor.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pro.abacus.javatutor.domain.Authority;
import pro.abacus.javatutor.domain.User;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTest {

	private static final String USER_NAME = "Ann";
	private static final String PASSWORD = "1234pass";
	private static final String AUTHORITY_USER = "USER";

	private User user;

	private Authority authority;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	UserRepository userRepository;

	@Before
	public void setUp() {
		authority = new Authority(AUTHORITY_USER);
		HashSet<Authority> authorities = new HashSet<>();
		authorities.add(authority);
		user = new User(USER_NAME, PASSWORD, authorities);
	}

	@After
	public void tearDown() {
		mongoTemplate.getDb().drop();
	}

	@Test
	public void shouldLookUpSavedAccount() {
		mongoTemplate.save(user);
		User foundAccount = userRepository.findByUsername(USER_NAME);
		assertEquals(PASSWORD, foundAccount.getPassword());
	}

}
