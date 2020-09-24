package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public String getId( ) {
		return this.mat;
	}
}
