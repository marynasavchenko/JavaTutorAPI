package pro.abacus.javatutor.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import pro.abacus.javatutor.domain.Authority;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AuthorityRepositoryTest {
	
	private Authority authorityUser;
	private Authority authorityAdmin;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Before
	public void setup() {
		authorityUser = new Authority("USER");
		authorityAdmin = new Authority("ADMIN");
	}
	
	@Test
	public void shouldLookUpAuthorities() {
		mongoTemplate.save(authorityUser);
		
		List<Authority> foundAuthority= authorityRepository.findAll();
		assertThat(foundAuthority.get(0).getAuthorityName()).isEqualTo("USER");
		
	}

}
