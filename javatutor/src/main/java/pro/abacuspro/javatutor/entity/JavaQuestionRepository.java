package pro.abacuspro.javatutor.entity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JavaQuestionRepository extends MongoRepository<JavaQuestion, Account> {
	
	public List<JavaQuestion> findByAccount(Account account);

}
