package com.example.demo.entity;

import java.util.Date;

import org.springframework.http.ResponseEntity.BodyBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maison {

	private String id ;
	private String mat ;
	private String description;
	private Boolean meuble ;
	private String etat ;
	private Boolean disponibilite;
	private Date annee_const ;
	private Float prix ;
	private String ville;
	private String rue ;
	private int nbr_piece;
	private Client client;
	private ImageModel imageModel;
	private int nbr_salle_bains ;
	private String type_sol;
	private int etage ;
	private int surface ;
	private String titre ;
	public String getId( ) {
		return this.mat;
	}
	
}
