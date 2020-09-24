package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection  = "Contact")
public class Contact {

	@Id
	private String id ;
	private String mat ;
	private Client client ;
	private Locataire locataire;
	private String message;
	private String objet;
	
	public String getId() {
		return this.mat;
	}

public void setMat(String mat) {
		
		this.mat=this.id;
	}
}
