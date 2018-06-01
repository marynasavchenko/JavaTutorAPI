package pro.abacus.javatutor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pro.abacus.javatutor.domain.Account;
import pro.abacus.javatutor.domain.UserDetailsImpl;
import pro.abacus.javatutor.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private AccountRepository accountRepository;

	@Autowired
	public UserDetailsServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = accountRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}

}
