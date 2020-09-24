package com.example.demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Administrateur;
import com.example.demo.entity.Chambre;
import com.example.demo.entity.Client;
import com.example.demo.entity.ImageModel;
import com.example.demo.entity.Locataire;
import com.example.demo.entity.Maison;
import com.example.demo.entity.Reclamation;



@FeignClient(name = "CrudApplication" )
public interface CrudRestAdmin {

	// Client
	
	@GetMapping("/client")
	public Resources<Client> findAllClient();
	
	@PutMapping("/client/{id}")
	public Client updatClient(Client client , @PathVariable("id") String id);
	
	@DeleteMapping("/client/{id}")
	public void deleteClientById(@PathVariable("id") String id);
	
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id);
	
	@PostMapping("/client")
	public Client postClient(Client client);
	//Locataire
	
	@GetMapping("/locataire")
	public Resources<Locataire> findAlllocataire();
	
	@PutMapping("/locataire/{id}")
	public Locataire updatlocataire(Locataire locataire , @PathVariable("id") String id);
	
	@PostMapping("/locataire")
	public Locataire postLocataire(Locataire locataire);
	
	@DeleteMapping("/locataire/{id}")
	public void deleteLocataireById(@PathVariable("id") String id);
	
	@GetMapping("/locataire/{id}")
	public Optional<Locataire> findLocataireById(@PathVariable("id") String id);
	
	//Maison
	
	@GetMapping("/maison")
	public Resources<Maison> findAllMaison();
	
	@PutMapping("/maison/{id}")
	public Maison updatMaison(Maison maison , @PathVariable("id") String id);
	
	@DeleteMapping("/maison/{id}")
	public void deleteMaisonById(@PathVariable("id") String id);
	
	@PostMapping("/maison")
	public Maison postMaison(Maison maison);
	
	@GetMapping("/maison/{id}")
	public Optional<Maison> findMaisonById(@PathVariable("id") String id);
	
	//Chambre
	
	@GetMapping("/chambre")
	public Resources<Chambre> findAllChambre();
	
	@PutMapping("/chambre/{id}")
	public Chambre updatChambre(Chambre chambre , @PathVariable("id") String id);
	
	@PostMapping("/chambre")
	public Chambre PostChambre(Chambre chambre );
	
	@DeleteMapping("/chambre/{id}")
	public void deleteChambreById(@PathVariable("id") String id);
	
	@GetMapping("/chambre/{id}")
	public Optional<Chambre> findChambreById(@PathVariable("id") String id);
	
	//Admin
	
	
	@PutMapping("/admin/{id}")
	public Administrateur updatAdmin(Administrateur administrateur , @PathVariable("id") String id);
	
	
	@GetMapping("/admin/{id}")
	public Optional<Administrateur> findAdministrateurById(@PathVariable("id") String id);
	
	//Reclamation
	@GetMapping("/reclamation")
	public Resources<Reclamation> findAllReclamation();
	
	@DeleteMapping("/reclamation/{id}")
	public void deleteReclamationById(@PathVariable("id") String id);
	
	@GetMapping("/reclamation/{id}")
	public Optional<Reclamation> findReclamationById(@PathVariable("id") String id);
	
	//Image
	
	@PostMapping("/image")
	 public ImageModel uplaodImag(ImageModel image);
	
	@GetMapping("/image/{name}")
	  public Optional<ImageModel> findImageByname(@PathVariable("name") String name) ;
	@GetMapping("/image/{name}")
	  public ImageModel getImage(@PathVariable("name") String name) throws IOException;
	
	//Admin
	
}
