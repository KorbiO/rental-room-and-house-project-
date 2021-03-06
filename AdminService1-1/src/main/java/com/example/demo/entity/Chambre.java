package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
	private String id ;
	private String mat ;
	private String description;
	private Boolean meuble ;
	private String etat ;
	private Boolean disponibilite;
	private LocalDateTime annee_const ;
	private Float prix ;
	private String ville;
	private String rue ;
	private int nbr_personne;
	private Client client;
	private ImageModel imageModel;
	public String getId( ) {
		return this.mat;
	}

}
