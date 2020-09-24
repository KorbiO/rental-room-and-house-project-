package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "Reclamation")
public class Reclamation {
	@Id
	private String id ;
	private String mat ;
	private LocalDateTime date_rec ;
	private String description ;
	
	private  Locataire locataire;
	
	public String getId() {
		return this.mat;
	}

public void setMat(String mat) {
		
		this.mat=this.id;
	}
}
