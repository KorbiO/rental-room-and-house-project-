package com.example.demo.web;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Chambre;
import com.example.demo.entity.Client;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Locataire;
import com.example.demo.entity.Maison;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.Reservation;
import com.example.demo.service.CrudRestLocataire;

@RestController
public class LocataireController {
	
	@Autowired 
	private CrudRestLocataire crudRestLocataire;
	
	@GetMapping("/reclamation")
	public Resources<Reclamation> findAllReclamation(){
		return crudRestLocataire.findAllReclamation();
	}
	
	@DeleteMapping("/reclamation/{id}")
	public void deleteReclamationById(@PathVariable("id") String id) {
		crudRestLocataire.deleteReclamationById(id);
	}

	@GetMapping("/reclamation/{id}")
	public Optional<Reclamation> findReclamationById(@PathVariable("id") String id){
		return crudRestLocataire.findReclamationById(id);
	}
	
	@PostMapping("/reclamation")
	public Reclamation postReclamation(@RequestBody Reclamation reclamation) {
		Reclamation r = new Reclamation();
		r.setMat(UUID.randomUUID().toString().replace("-", ""));
		r.setDescription(reclamation.getDescription());
		r.setDate_rec(LocalDateTime.now());
	Locataire c = crudRestLocataire.findLocataireById(reclamation.getLocataire().getUsername()).orElse(null);
		System.err.println(c);
		if(c != null) {
			r.setLocataire(c);
		}
		crudRestLocataire.postReclamation(r);
		return r ;
			
	}
	@PutMapping("/reclamation/{id}")
	public Reclamation updatReclamation(@RequestBody Reclamation reclamation , @PathVariable("id") String id) {
		Reclamation r = new Reclamation();
		r.setId(id);
		r.setMat(id);
		r.setDescription(reclamation.getDescription());
		r.setDate_rec(LocalDateTime.now());
		Locataire c = crudRestLocataire.findLocataireById(reclamation.getLocataire().getUsername()).orElse(null);
			System.err.println(c);
			
				r.setLocataire(c);
			
		crudRestLocataire.updatReclamation(r, id);
		return r ;
	}
	
	//Maison
	
	@GetMapping("/maison")
	public Resources<Maison> findAllMaison(){
		return crudRestLocataire.findAllMaison();
	}
	@GetMapping("/maison/{id}")
	public Optional<Maison> findMaisonById(@PathVariable("id") String id){
		return crudRestLocataire.findMaisonById(id);
	}
	
	//Chambre
	
	@GetMapping("/chambre")
	public Resources<Chambre> findAllChambre(){
		return crudRestLocataire.findAllChambre();
	}
	
	@GetMapping("/chambre/{id}")
	public Optional<Chambre> findChambreById(@PathVariable("id") String id){
		return crudRestLocataire.findChambreById(id);
	}
	
	//Reservation
	
	@PostMapping("/reservation")
	public Reservation postReservation(@RequestBody Reservation reservation) {
		Reservation r = new Reservation();
		r.setDate_reser(reservation.getDate_reser());
		r.setMat(UUID.randomUUID().toString().replace("-", ""));
		r.setReponse(reservation.getReponse());
		Locataire l = crudRestLocataire.findLocataireById(reservation.getLocataire().getUsername()).orElse(null);
		if (l != null) {
			r.setLocataire(l);
		}
		crudRestLocataire.postReservation(r);
		return r ;
	}
	
	//Contact
	
	@PostMapping("/contact")
	public Contact postContact(@RequestBody Contact contact) {
		Contact c = new Contact();
		c.setMat(UUID.randomUUID().toString().replace("-", ""));
		c.setObjet(contact.getObjet());
		c.setMessage(contact.getMessage());
		Locataire l = crudRestLocataire.findLocataireById(contact.getLocataire().getUsername()).orElse(null);
		System.err.println(l);
		Client cl = crudRestLocataire.findClientById(contact.getClient().getUsername()).orElse(null);
		if ( l != null ) {c.setLocataire(l);}
		if (cl != null) {c.setClient(cl);}
		crudRestLocataire.postContact(c);
		return c ;
	}
	@PutMapping("/contact/{id}")
	public Contact postContact(@RequestBody Contact contact , @PathVariable("id") String id) {
		Optional<Contact> c1 = crudRestLocataire.findContactById(id);
		Contact c = new Contact();
		c.setMat(UUID.randomUUID().toString().replace("-", ""));
		c.setObjet(contact.getObjet());
		c.setMessage(contact.getMessage());
		Locataire l = crudRestLocataire.findLocataireById(contact.getLocataire().getUsername()).orElse(null);
		Client cl = crudRestLocataire.findClientById(contact.getClient().getUsername()).orElse(null);
		if ( l != null ) {c.setLocataire(l);}
		if (cl != null) {c.setClient(cl);}
		crudRestLocataire.postContact(c);
		return c ;
	}
	@GetMapping("/contact/{id}")
	public Optional<Contact> findContactById(@PathVariable("id") String id){
		return crudRestLocataire.findContactById(id);
	}
	@DeleteMapping("/contact/{id}")
	public void deleteContactById(@PathVariable("id") String id) {
		crudRestLocataire.deleteContactById(id);
	}
	@GetMapping("/contact")
	public Resources<Contact> findAllContacts(){
		return crudRestLocataire.findAllContacts();
	}
	
	//get Client by id 
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id){
		return crudRestLocataire.findClientById(id);
	}
	
	@GetMapping("/locataire/{id}")
	public Optional<Locataire> findLocataireById(@PathVariable("id") String id){
		return crudRestLocataire.findLocataireById(id);
	}
	
}
