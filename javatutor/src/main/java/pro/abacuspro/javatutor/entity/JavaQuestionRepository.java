package pro.abacuspro.javatutor.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JavaQuestionRepository extends MongoRepository<JavaQuestion, Account> {
	
	public JavaQuestion findByAccount(Account account);

}
