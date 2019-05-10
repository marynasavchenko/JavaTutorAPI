package pro.abacus.javatutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pro.abacus.javatutor.security.AuthFailureHandler;
import pro.abacus.javatutor.security.AuthSuccessHandler;
import pro.abacus.javatutor.security.LogoutSuccessHandlerImpl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	final static Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

	private UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public AuthSuccessHandler authSuccessHandler() {
		return new AuthSuccessHandler();
	}

	@Bean
	public AuthFailureHandler authFailureHandler() {
		return new AuthFailureHandler();
	}

	@Bean
	public LogoutSuccessHandlerImpl logoutSuccessHandlerImpl() {
		return new LogoutSuccessHandlerImpl();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
				.formLogin()
				.loginProcessingUrl("/api/signin")
				.successHandler(authSuccessHandler())
				.failureHandler(authFailureHandler())
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.rememberMe()
				.and()
				.authorizeRequests()
				.antMatchers("/api/javaquestions/**")
				.hasRole("USER")
				.antMatchers("/api/signin", "/api/signup")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/api/logout")
				.logoutSuccessHandler(logoutSuccessHandlerImpl())
				.permitAll();
	}
}
