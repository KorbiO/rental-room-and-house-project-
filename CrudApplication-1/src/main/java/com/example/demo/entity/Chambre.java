package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "Chambre")
public class Chambre extends Logement {

	private int nbr_personne;
	private String titre ;
	private Boolean nbr_salle_bains ;
	private String type_sol;
	private int etage ;
}
