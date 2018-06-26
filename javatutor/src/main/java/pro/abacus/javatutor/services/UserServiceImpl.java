package pro.abacus.javatutor.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.repository.UserRepository;
import pro.abacus.javatutor.repository.AuthorityRepository;

@Service
public class UserServiceImpl implements UserService {

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

	@Override
	public User saveAccount(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserAuthorities(new HashSet<>(authorityRepository.findAll()));
		return userRepository.save(user);

	}

}
