package com.example.demo.controller;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter{
	
	@Override
	 public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	    config.getCorsRegistry().addMapping("/**")
	            .allowedOrigins("http://localhost:4200").allowedMethods("PUT", "DELETE",
                        "GET", "POST");;
	  }

}
