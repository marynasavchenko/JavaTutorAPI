package pro.abacus.javatutor.service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.repository.AuthorityRepository;
import pro.abacus.javatutor.repository.UserRepository;

import java.util.HashSet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationServiceImplTest {
	private static final String UNSECURED_PASSWORD = "1234test";
	private static final String SECURED_PASSWORD = "1BC29B36F623BA82AAF6724FD3B16718";
	
	private UserRegistrationService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Mock
	private AuthorityRepository authorityRepository;
	
	@Mock 
	private User user;
	
	@Before 
	public void setup (){
	userService = new UserRegistrationServiceImpl(userRepository, bCryptPasswordEncoder, authorityRepository);
	}
	
	@Test
	public void shouldSaveUserWithEncryptedPasswordAndAuthority() throws Exception{
		when(user.getPassword()).thenReturn(UNSECURED_PASSWORD);
		when(bCryptPasswordEncoder.encode(UNSECURED_PASSWORD)).thenReturn(SECURED_PASSWORD);
		
		userService.saveUserAccount(user);
		
		verify(user).setPassword(SECURED_PASSWORD);
		verify(user).setUserAuthorities(new HashSet<>()); 
		verify(userRepository).save(user);
	}

}
