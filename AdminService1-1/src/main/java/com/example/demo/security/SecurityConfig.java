package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	       http.authorizeRequests().antMatchers("/client/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/locataire/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/maison/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/chambre/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/reclamation/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/image/**").hasAuthority("ADMIN");
	       http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
	        																				
	     
	        http.authorizeRequests().anyRequest().authenticated();
	       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
}
