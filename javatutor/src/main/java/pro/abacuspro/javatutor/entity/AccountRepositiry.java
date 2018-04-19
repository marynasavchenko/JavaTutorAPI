package pro.abacuspro.javatutor.entity;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepositiry extends MongoRepository<Account, String> {
	
	public Optional<Account> findByUsername(String username);

}
