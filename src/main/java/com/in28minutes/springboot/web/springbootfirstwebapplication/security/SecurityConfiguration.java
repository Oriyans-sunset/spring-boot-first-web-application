package com.in28minutes.springboot.web.springbootfirstwebapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	//Create User - alok/123
		@Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
	            throws Exception {
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			auth.inMemoryAuthentication().withUser("alok").password(encoder.encode("123")).roles("USER", "ADMIN");
	    }
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().antMatchers("/login").permitAll()
	                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
	                .formLogin();
	        
	        http.csrf().disable();
	        http.headers().frameOptions().disable();
	    }
	
}
