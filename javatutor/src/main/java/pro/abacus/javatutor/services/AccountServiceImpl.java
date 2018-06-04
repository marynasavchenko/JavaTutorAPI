package pro.abacus.javatutor.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.repository.AccountRepository;
import pro.abacus.javatutor.repository.AuthorityRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private AuthorityRepository authorityRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			AuthorityRepository authorityRepository) {
		this.accountRepository = accountRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public User saveAccount(User account) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		account.setUserAuthorities(new HashSet<>(authorityRepository.findAll()));
		return accountRepository.save(account);

	}

}
