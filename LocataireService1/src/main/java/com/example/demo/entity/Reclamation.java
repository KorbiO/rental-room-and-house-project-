package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamation {

	private String id ;
	private String mat ;
	private LocalDateTime date_rec ;
	private String description ;
	
	private  Locataire locataire;
	
	public String getId( ) {
		return this.mat;
	}
}
