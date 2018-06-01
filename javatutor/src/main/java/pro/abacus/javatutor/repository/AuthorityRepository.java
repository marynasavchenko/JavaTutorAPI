package pro.abacus.javatutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pro.abacus.javatutor.domain.Authority;

/**
 * Spring Data MongoDB repository for the Authority entity.
 */

public interface AuthorityRepository extends MongoRepository<Authority, String> {

}
