package pro.abacus.javatutor;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import pro.abacus.javatutor.security.AuthFailureHandler;
import pro.abacus.javatutor.security.AuthSuccessHandler;
import pro.abacus.javatutor.security.LogoutSuccessHandlerImpl;
import pro.abacus.javatutor.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	final static Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
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
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors();
		http.headers().frameOptions().disable();
		http
			.formLogin()
			.loginProcessingUrl("/api/signin")
			.successHandler(authSuccessHandler())
			.failureHandler(authFailureHandler())
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
		.and()
			.rememberMe()
		.and()
			.headers()
			.frameOptions()
			.disable()
		.and()
			.authorizeRequests()
			.antMatchers("/api/signin").permitAll()
			.antMatchers("/api/signup").permitAll()
			.antMatchers("/api/javaquestions/**").authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.logout()
			.logoutUrl("/api/logout")
			.logoutSuccessHandler(logoutSuccessHandlerImpl())
			.permitAll();

	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	

}
