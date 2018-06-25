package pro.abacus.javatutor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pro.abacus.javatutor.domain.JavaQuestion;

/**
 * Spring Data MongoDB repository for the JavaQuestion entity.
 */
@Repository
public interface JavaQuestionRepository extends MongoRepository<JavaQuestion, Long> {
	
	public List<JavaQuestion> findByAccountUsername(String username);

}
