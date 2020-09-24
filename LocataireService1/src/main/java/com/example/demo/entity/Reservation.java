package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	private String id ;
	private String mat ;
	private LocalDateTime date_reser;
	private Locataire locataire;
	private String reponse ;
	
	public String getId() {
		return this.mat;
	}
}
