package pro.abacus.javatutor.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl extends Account implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	public UserDetailsImpl(final Account account) {
		super(account);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getUserAuthorities()
				.stream()
				.map(authority ->new SimpleGrantedAuthority("ROLE"+ authority.getName()))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public String getPassword() {
		return this.getPassword();
	}

	@Override
	public String getUsername() {
		return this.getUsername();
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
