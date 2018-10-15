package pro.abacus.javatutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pro.abacus.javatutor.domain.JavaQuestion;

import java.util.List;

/**
 * Spring Data MongoDB repository for the JavaQuestion entity.
 */
@Repository
public interface JavaQuestionRepository extends MongoRepository<JavaQuestion, Long> {
	List<JavaQuestion> findByAccountUsername(String username);

}
