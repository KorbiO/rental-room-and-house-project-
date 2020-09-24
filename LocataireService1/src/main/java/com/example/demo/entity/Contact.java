package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

	
	private String id ;
	private String mat ;
	private Client client ;
	private Locataire locataire;
	private String message;
	private String objet;
	
	public String getId() {
		return this.mat;
	}
}
