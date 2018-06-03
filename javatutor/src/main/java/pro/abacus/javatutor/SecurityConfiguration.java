package pro.abacus.javatutor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import pro.abacus.javatutor.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserDetailsServiceImpl userDetailsServiceImpl;
	private  AuthenticationManagerBuilder authenticationManagerBuilder;

	@Autowired
	public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl, AuthenticationManagerBuilder authenticationManagerBuilder) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
		this.authenticationManagerBuilder=authenticationManagerBuilder;
	}
	
	@PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                .userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(bCryptPasswordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable();
	        http 
	        .authorizeRequests()
            .antMatchers("/api/test/**")  
            .authenticated()
            .anyRequest()
            .permitAll()
            .and()
            .formLogin()
             .loginPage("/api/signin")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/");
	     
	}
	
	

}
