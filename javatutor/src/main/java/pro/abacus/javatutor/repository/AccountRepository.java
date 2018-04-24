package pro.abacus.javatutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pro.abacus.javatutor.domain.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
	public Account findByUsername(String username);

}
