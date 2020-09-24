package com.example.demo.controller;

import java.io.IOException;
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

import com.example.demo.entity.Administrateur;
import com.example.demo.entity.Chambre;
import com.example.demo.entity.Client;
import com.example.demo.entity.Locataire;
import com.example.demo.entity.Maison;
import com.example.demo.entity.Reclamation;
import com.example.demo.service.CrudRestAdmin;


@RestController
public class AdminController {

	@Autowired
	private  CrudRestAdmin crudRestAdmin ;
	
	
	
	//Client 
	
	@GetMapping("/client")
	public Resources<Client> findAllClient(){
		return crudRestAdmin.findAllClient();
	}
	
	@DeleteMapping("/client/{id}")
	public void deleteClientById(@PathVariable("id") String id) {
		crudRestAdmin.deleteClientById(id);
	}
	
	@PostMapping("/client")
	public Client postClient(@RequestBody Client client) {
		Client c1 = new Client();
		c1.setMat(client.getUsername());
		c1.setCin(client.getCin());
		c1.setConfirmedPassword(client.getConfirmedPassword());
		c1.setNom(client.getNom());
		c1.setPrenom(client.getPrenom());
		c1.setPassword(client.getPassword());
		c1.setPhoneNumber(client.getPhoneNumber());
		c1.setUsername(client.getUsername());
		c1.setAddress(client.getAddress());
		
		crudRestAdmin.postClient(c1);
		
		
		return c1;
	}
	
	
	@PutMapping("/client/{id}")
	public Client updatClient(@RequestBody Client client , @PathVariable("id") String id) {
		Optional<Client> c = crudRestAdmin.findClientById(id);
		Client c1 = new Client();
		c1.setMat(client.getUsername());
		c1.setAddress(client.getAddress());
		c1.setCin(client.getCin());
		c1.setNom(client.getNom());
		c1.setPassword(client.getPassword());
		c1.setPhoneNumber(client.getPhoneNumber());
		c1.setPrenom(client.getPrenom());
		
		c1.setAddress(client.getAddress());
		crudRestAdmin.updatClient(c1, id);
		return c1;
	}
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id){
		return crudRestAdmin.findClientById(id);
	}
	
	//Locataire
	
	@GetMapping("/locataire")
	public Resources<Locataire> findAllLocataire(){
		return crudRestAdmin.findAlllocataire();
	}
	
	@DeleteMapping("/locataire/{id}")
	public void deleteLocataireById(@PathVariable("id") String id) {
		crudRestAdmin.deleteLocataireById(id);
	}
	@GetMapping("/locataire/{id}")
	public Optional<Locataire> findLocataireById(@PathVariable("id") String id){
		return crudRestAdmin.findLocataireById(id);
	}
	
	@PutMapping("/locataire/{id}")
	public Locataire updatLocataire(@RequestBody Locataire locataire , @PathVariable("id") String id) {
		Optional<Locataire> c = crudRestAdmin.findLocataireById(id);
		Locataire c1 = new Locataire();
		c1.setMat(locataire.getUsername());
		c1.setAddress(locataire.getAddress());
		c1.setCin(locataire.getCin());
		c1.setNom(locataire.getNom());
		c1.setPassword(locataire.getPassword());
		c1.setPhoneNumber(locataire.getPhoneNumber());
		c1.setPrenom(locataire.getPrenom());
		c1.setUsername(locataire.getUsername());
		crudRestAdmin.updatlocataire(c1, id);
		return c1;
	}
	@PostMapping("/locataire")
	public Locataire postLocataire(@RequestBody Locataire locataire) {
		Locataire c1 = new Locataire();
		c1.setMat(locataire.getUsername());
		c1.setAddress(locataire.getAddress());
		c1.setCin(locataire.getCin());
		c1.setNom(locataire.getNom());
		c1.setPassword(locataire.getPassword());
		c1.setPhoneNumber(locataire.getPhoneNumber());
		c1.setPrenom(locataire.getPrenom());
		c1.setUsername(locataire.getUsername());
		crudRestAdmin.postLocataire(c1);
		return c1;
	}
	
	//Maison
	
	@GetMapping("/maison")
	public Resources<Maison> findAllMaison(){
		return crudRestAdmin.findAllMaison();
	}
	
	@PutMapping("/maison/{id}")
	public Maison updatMaison(@RequestBody Maison maison , @PathVariable("id") String id) throws IOException {
		Optional<Maison> c = crudRestAdmin.findMaisonById(id);
		Client cl = crudRestAdmin.findClientById(maison.getClient().getUsername()).orElse(null);
		Maison m = new Maison();
		m.setAnnee_const(maison.getAnnee_const());
		m.setDescription(maison.getDescription());
		m.setDisponibilite(maison.getDisponibilite());
		m.setEtat(maison.getEtat());
		m.setId(maison.getId());
		m.setMat(maison.getMat());
		m.setNbr_salle_bains(maison.getNbr_salle_bains());
		m.setType_sol(maison.getType_sol());
		m.setEtage(maison.getEtage());
		m.setTitre(maison.getTitre());
		m.setSurface(maison.getSurface());
		m.setMeuble(maison.getMeuble());
		m.setNbr_piece(maison.getNbr_piece());
		m.setPrix(maison.getPrix());
		m.setRue(maison.getRue());
		m.setVille(maison.getVille());
		m.setImageModel(crudRestAdmin.getImage(maison.getImageModel().getMat()));
		if(cl != null) {
			m.setClient(cl);
			}
		crudRestAdmin.updatMaison(m, id);
		return m;
	}
	@PostMapping("/maison")
	public Maison postMaison(@RequestBody Maison maison) throws IOException {
		Client cl = crudRestAdmin.findClientById(maison.getClient().getUsername()).orElse(null);
	
		Maison m = new Maison();
		m.setAnnee_const(maison.getAnnee_const());
		m.setDescription(maison.getDescription());
		m.setDisponibilite(maison.getDisponibilite());
		m.setEtat(maison.getEtat());
		m.setNbr_salle_bains(maison.getNbr_salle_bains());
		m.setType_sol(maison.getType_sol());
		m.setEtage(maison.getEtage());
		m.setTitre(maison.getTitre());
		m.setSurface(maison.getSurface());
		m.setMat(UUID.randomUUID().toString().replace("-", ""));
		m.setMeuble(maison.getMeuble());
		m.setNbr_piece(maison.getNbr_piece());
		m.setPrix(maison.getPrix());
		m.setRue(maison.getRue());
		m.setVille(maison.getVille());
		m.setImageModel(crudRestAdmin.findImageByname(maison.getImageModel().getMat()).orElse(null));
		
		
		if(cl != null) {
		m.setClient(cl);
		}
		crudRestAdmin.postMaison(m);
		return m ;
	}
	
	@DeleteMapping("/maison/{id}")
	public void deleteMaisonById(@PathVariable("id") String id) {
		crudRestAdmin.deleteMaisonById(id);
	}
	
	@GetMapping("/maison/{id}")
	public Optional<Maison> findMaisonById(@PathVariable("id") String id){
		return crudRestAdmin.findMaisonById(id);
	}
	
	//Chambre
	
	@GetMapping("/chambre")
	public Resources<Chambre> findAllChambre(){
		return crudRestAdmin.findAllChambre();
	}
	
	@PutMapping("/chambre/{id}")
	public Chambre updatChambre(@RequestBody Chambre chambre , @PathVariable("id") String id) throws IOException {
		Optional<Chambre> c = crudRestAdmin.findChambreById(id);
		Client cl = crudRestAdmin.findClientById(chambre.getClient().getUsername()).orElse(null);
		Chambre m = new Chambre();
		m.setAnnee_const(chambre.getAnnee_const());
		m.setDescription(chambre.getDescription());
		m.setDisponibilite(chambre.getDisponibilite());
		m.setEtat(chambre.getEtat());
		m.setId(chambre.getId());
		m.setMat(chambre.getMat());
		m.setMeuble(chambre.getMeuble());
		m.setNbr_personne(chambre.getNbr_personne());
		m.setPrix(chambre.getPrix());
		m.setRue(chambre.getRue());
		m.setVille(chambre.getVille());
		m.setImageModel(crudRestAdmin.getImage(chambre.getImageModel().getMat()));
		if(cl != null) {
			m.setClient(cl);
			}
		crudRestAdmin.updatChambre(m, id);
		return m;
	}
	@PostMapping("/chambre")
	public Chambre postChambre(@RequestBody Chambre chambre) throws IOException {
		Client cl = crudRestAdmin.findClientById(chambre.getClient().getUsername()).orElse(null);
	
		Chambre m = new Chambre();
		m.setAnnee_const(chambre.getAnnee_const());
		m.setDescription(chambre.getDescription());
		m.setDisponibilite(chambre.getDisponibilite());
		m.setEtat(chambre.getEtat());
		
		m.setMat(UUID.randomUUID().toString().replace("-", ""));
		m.setMeuble(chambre.getMeuble());
		m.setNbr_personne(chambre.getNbr_personne());
		m.setPrix(chambre.getPrix());
		m.setRue(chambre.getRue());
		m.setVille(chambre.getVille());
		m.setImageModel(crudRestAdmin.findImageByname(chambre.getImageModel().getMat()).orElse(null));
		
		
		if(cl != null) {
		m.setClient(cl);
		}
		crudRestAdmin.PostChambre(m);
		return m ;
	}
	
	@DeleteMapping("/chambre/{id}")
	public void deleteChambreById(@PathVariable("id") String id) {
		crudRestAdmin.deleteChambreById(id);
	}
	
	@GetMapping("/chambre/{id}")
	public Optional<Chambre> findChambreById(@PathVariable("id") String id){
		return crudRestAdmin.findChambreById(id);
	}
	//Reclamation
		@GetMapping("/reclamation")
		public Resources<Reclamation> findAllReclamation(){
			return crudRestAdmin.findAllReclamation();
		}
		
		@DeleteMapping("/reclamation/{id}")
		public void deleteReclamationById(@PathVariable("id") String id) {
			crudRestAdmin.deleteReclamationById(id);
		}
		
		@GetMapping("/reclamation/{id}")
		public Optional<Reclamation> findReclamationById(@PathVariable("id") String id){
			return crudRestAdmin.findReclamationById(id);
		}
		
		@GetMapping("/admin/{id}")
		public Optional<Administrateur> findAdministrateurById(@PathVariable("id") String id){
			return crudRestAdmin.findAdministrateurById(id);
		}
	
}
