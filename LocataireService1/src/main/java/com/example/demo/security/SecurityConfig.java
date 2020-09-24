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
	    //    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/fournissur/**").permitAll()/*hasAuthority("FOURNISSEUR")*/;
	        http.authorizeRequests().antMatchers("/chambre/**").hasAuthority("LOCATAIRE");
	        http.authorizeRequests().antMatchers("/reclamation/**").hasAuthority("LOCATAIRE");
	        http.authorizeRequests().antMatchers("/maison/**").hasAuthority("LOCATAIRE");	
	        http.authorizeRequests().antMatchers("/reservation/**").hasAuthority("LOCATAIRE");
	        http.authorizeRequests().antMatchers("/contact/**").hasAuthority("LOCATAIRE");
	        http.authorizeRequests().antMatchers("/client/**").hasAuthority("LOCATAIRE");
	        http.authorizeRequests().antMatchers("/locataire/**").hasAuthority("LOCATAIRE");
	     
	        http.authorizeRequests().anyRequest().authenticated();
	       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
}
