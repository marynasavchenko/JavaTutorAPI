package pro.abacus.javatutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pro.abacus.javatutor.domain.User;

public interface AccountRepository extends MongoRepository<User, String> {
	
	public User findByUsername(String username);

}
