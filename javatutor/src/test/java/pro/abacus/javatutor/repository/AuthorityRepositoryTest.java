package pro.abacus.javatutor.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pro.abacus.javatutor.domain.Authority;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
//(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class AuthorityRepositoryTest {

	private Authority authorityUser;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setup() {
		authorityUser = new Authority("USER");
	}

	@Test
	public void shouldLookUpAuthorities() {
		mongoTemplate.save(authorityUser);

		List<Authority> foundAuthority = authorityRepository.findAll();
		assertThat(foundAuthority.get(0).getAuthorityName()).isEqualTo("USER");

	}

}
