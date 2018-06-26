package pro.abacus.javatutor.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pro.abacus.javatutor.domain.User;


public class UserDetailsImpl extends User implements UserDetails {
	final static Logger log = LoggerFactory.getLogger(UserDetailsImpl.class);

	private static final long serialVersionUID = 1L;
	
	public UserDetailsImpl(final User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getUserAuthorities()
				.stream()
				.map(authority ->new SimpleGrantedAuthority("ROLE_" + authority.getAuthorityName()))
				.collect(Collectors.toList());
		
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
