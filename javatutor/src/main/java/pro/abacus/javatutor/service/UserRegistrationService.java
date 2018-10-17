package pro.abacus.javatutor.service;

import pro.abacus.javatutor.domain.User;

/**
 * Service interface for managing users registrations.
 */
public interface UserRegistrationService {
	void saveUserAccount(User user);

}
