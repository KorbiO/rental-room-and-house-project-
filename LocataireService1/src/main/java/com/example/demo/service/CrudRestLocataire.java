package com.example.demo.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Chambre;
import com.example.demo.entity.Client;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Locataire;
import com.example.demo.entity.Maison;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.Reservation;


@FeignClient(name="CrudApplication")
public interface CrudRestLocataire {
	
	//Reclamtion

	@GetMapping("/reclamation")
	public Resources<Reclamation> findAllReclamation();
	
	@PutMapping("/reclamation/{id}")
	public Reclamation updatReclamation(Reclamation reclamation , @PathVariable("id") String id);
	
	@DeleteMapping("/reclamation/{id}")
	public void deleteReclamationById(@PathVariable("id") String id);
	
	@GetMapping("/reclamation/{id}")
	public Optional<Reclamation> findReclamationById(@PathVariable("id") String id);
	
	@PostMapping("/reclamation")
	public Reclamation postReclamation(Reclamation reclamation);
	
	//Locataire
	
	@GetMapping("/locataire/{id}")
	public Optional<Locataire> findLocataireById(@PathVariable("id") String id);
	
	//Chambre
	
	@GetMapping("/chambre")
	public Resources<Chambre> findAllChambre();
	
	@GetMapping("/chambre/{id}")
	public Optional<Chambre> findChambreById(@PathVariable("id") String id);
	
	
	//Maison
	
	@GetMapping("/maison")
	public Resources<Maison> findAllMaison();
	
	@GetMapping("/maison/{id}")
	public Optional<Maison> findMaisonById(@PathVariable("id") String id);
	
	//Reservation
	
	@PostMapping("/reservation")
	public Reclamation postReservation(Reservation reservation);
	
	//Contacter
	
	@PostMapping("/contact")
	public Contact postContact(Contact contact);
	
	@GetMapping("/contact/{id}")
	public Optional<Contact> findContactById(@PathVariable("id") String id);
	@PutMapping("/contact/{id}")
	public Contact putContact( @PathVariable("id") String id , Contact contact);
	@DeleteMapping("/contact/{id}")
	public void deleteContactById(@PathVariable("id") String id);
	@GetMapping("/contact")
	public Resources<Contact> findAllContacts();
	//Client
	
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id);
	
	
		
}
