package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection  = "Locataire")
public class Locataire extends Utilisateur{
	
	private String cin; 
	private String address;
	private String phoneNumber;

	
}
