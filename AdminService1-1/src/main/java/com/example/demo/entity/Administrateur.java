package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrateur {
	
	private String id;
	private String mat;
	private String username ; 
	private String password ; 
	private String nom;
	private String prenom;
	private String code_pin;
	  private String confirmedPassword; 
	  private String gender ;
	
	public String getId( ) {
		return this.mat;
	}

}
