package pro.abacus.javatutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.repository.AuthorityRepository;
import pro.abacus.javatutor.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private AuthorityRepository authorityRepository;

	@Autowired
	public UserRegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
	                                   AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public void saveUserAccount(User user) {
		setEncodedPassword(user);
		setAuthoritiesForAccount(user);
		userRepository.save(user);
	}

	private void setEncodedPassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	private void setAuthoritiesForAccount(User user) {
		user.setUserAuthorities(new HashSet<>(authorityRepository.findAll()));
	}

}
