package pro.abacus.javatutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.repository.AuthorityRepository;
import pro.abacus.javatutor.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private AuthorityRepository authorityRepository;

	@Autowired
	public UserRegistrationServiceImpl(UserRepository accountRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
	                                   AuthorityRepository authorityRepository) {
		this.userRepository = accountRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.authorityRepository = authorityRepository;
	}

//TODO: authorityRepository change method, split to several methods
	@Override
	public void saveUserAccount(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserAuthorities(new HashSet<>(authorityRepository.findAll()));
		userRepository.save(user);
	}
}
