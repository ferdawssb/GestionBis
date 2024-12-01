package tn.enig.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tn.enig.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*@Autowired
	DataSource dataSource;*/
	@Autowired
	UserService userserv;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder crt = cryptageMP();
		//inMemory
		// auth.inMemoryAuthentication().withUser("Ali").password(crt.encode("fer")).roles("ADMIN");
		// auth.inMemoryAuthentication().withUser("Hadil").password(crt.encode("fer")).roles("AGENT");
		// auth.inMemoryAuthentication().withUser("Salah").password(crt.encode("fer")).roles("USER");
		//jdbc
		
		/*auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select username as principal,password as credentials,active from user where username=?")
				.authoritiesByUsernameQuery(
						"select username as principal,role as role from user_roles where username=?")
				.passwordEncoder(crt).rolePrefix("ROLE_");*/
		
		//UserDetails
		
		  auth.userDetailsService(userserv).passwordEncoder(crt);
		
		
		
		
		
		
		
		

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().defaultSuccessUrl("/home");

		http.authorizeRequests().antMatchers("/ajoutEmploye", "/saveEmploye", "/ajoutProjet", "/saveProjet")
				.hasRole("ADMIN");

		http.authorizeRequests().antMatchers("/projets/{id}", "/employes/**").hasAnyRole("AGENT", "ADMIN");
		//http.authorizeRequests().antMatchers("/home").hasAnyRole("USER", "AGENT", "ADMIN");

		http.authorizeRequests().anyRequest().authenticated();

		http.csrf();

	}

	@Bean
	public PasswordEncoder cryptageMP() {
		return new BCryptPasswordEncoder();

	}

}
