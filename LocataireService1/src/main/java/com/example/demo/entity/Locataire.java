package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locataire {

	private String id;
	private String mat;
	private String username ; 
	private String password ; 
	private String nom;
	private String prenom;
	private String cin; 
	private String address;
	private String phoneNumber;
	  private String confirmedPassword; 
	 
	
	
	public String getId( ) {
		return this.mat;
	}
}
