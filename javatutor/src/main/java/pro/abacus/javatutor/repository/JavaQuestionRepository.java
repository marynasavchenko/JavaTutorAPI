package pro.abacus.javatutor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pro.abacus.javatutor.domain.JavaQuestion;

public interface JavaQuestionRepository extends MongoRepository<JavaQuestion, Long> {
	
	public List<JavaQuestion> findByAccountUsername(String username);

}
