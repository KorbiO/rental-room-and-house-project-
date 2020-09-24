package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "Maison")
public class Maison extends Logement{

	private int nbr_piece;
	private int nbr_salle_bains ;
	private String type_sol;
	private int etage ;
	private int surface ;
	private String titre ;
	
}
