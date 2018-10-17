package pro.abacus.javatutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.repository.AuthorityRepository;
import pro.abacus.javatutor.repository.UserRepository;

import java.util.HashSet;

//TODO: rename to userRegistrationService?
@Service
public class UserServiceImpl implements UserRegistrationService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private AuthorityRepository authorityRepository;

	@Autowired
	public UserServiceImpl(UserRepository accountRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			AuthorityRepository authorityRepository) {
		this.userRepository = accountRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.authorityRepository = authorityRepository;
	}
//TODO: authorityRepository change method
	@Override
	public User saveAccount(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserAuthorities(new HashSet<>(authorityRepository.findAll()));
		return userRepository.save(user);

	}

}
