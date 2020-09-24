package com.example.demo.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Chambre;
import com.example.demo.entity.Client;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Locataire;
import com.example.demo.entity.Maison;
import com.example.demo.service.CrudRestClient;

@RestController
public class ClientController {

	@Autowired
	private CrudRestClient crudRestClient;
	
	//Maison
	
		@GetMapping("/maison")
		public Resources<Maison> findAllMaison(){
			return crudRestClient.findAllMaison();
		}
		
		@PutMapping("/maison/{id}")
		public Maison updatMaison(@RequestBody Maison maison , @PathVariable("id") String id) throws IOException {
			Optional<Maison> c = crudRestClient.findMaisonById(id);
			Client cl = crudRestClient.findClientById(maison.getClient().getUsername()).orElse(null);
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
			m.setImageModel(crudRestClient.getImage(maison.getImageModel().getMat()));
			if(cl != null) {
				m.setClient(cl);
				}
			crudRestClient.updatMaison(m, id);
			return m;
		}
		@GetMapping("/client/{id}")
		public Optional<Client> findClientById(@PathVariable("id") String id){
			return crudRestClient.findClientById(id);
		}
		
		@PostMapping("/maison")
		public Maison postMaison(@RequestBody Maison maison ) throws IOException {
			Client cl = findClientById(maison.getClient().getUsername()).orElse(null);
		//	Client cl = crudRestClient.findClientById(maison.getClient().getUsername()).orElse(null);
		System.err.println(cl);
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
			m.setImageModel(crudRestClient.findImageByname(maison.getImageModel().getMat()).orElse(null));
			
				
			if(cl != null) {
			m.setClient(cl);
			}
			crudRestClient.postMaison(m);
			return m ;
			
		}
		
		
		@DeleteMapping("/maison/{id}")
		public void deleteMaisonById(@PathVariable("id") String id) {
			crudRestClient.deleteMaisonById(id);
		}
		
		@GetMapping("/maison/{id}")
		public Optional<Maison> findMaisonById(@PathVariable("id") String id){
			return crudRestClient.findMaisonById(id);
		}
		
		//Chambre
		
		@GetMapping("/chambre")
		public Resources<Chambre> findAllChambre(){
			return crudRestClient.findAllChambre();
		}
		
		@PutMapping("/chambre/{id}")
		public Chambre updatChambre(@RequestBody Chambre chambre , @PathVariable("id") String id)throws IOException {
			Optional<Chambre> c = crudRestClient.findChambreById(id);
			Client cl = crudRestClient.findClientById(chambre.getClient().getUsername()).orElse(null);
			Chambre m = new Chambre();
			m.setAnnee_const(chambre.getAnnee_const());
			m.setDescription(chambre.getDescription());
			m.setDisponibilite(chambre.getDisponibilite());
			m.setEtat(chambre.getEtat());
			m.setId(id);
			m.setMat(id);
			m.setMeuble(chambre.getMeuble());
			m.setNbr_personne(chambre.getNbr_personne());
			m.setPrix(chambre.getPrix());
			m.setRue(chambre.getRue());
			m.setVille(chambre.getVille());
			m.setImageModel(crudRestClient.getImage(chambre.getImageModel().getMat()));
			if(cl != null) {
				m.setClient(cl);
				}
			crudRestClient.updatChambre(m, id);
			return m;
		}
		
		@PostMapping("/chambre")
		public Chambre postChambre(@RequestBody Chambre chambre) throws IOException {
			//Client cl = crudRestClient.findClientById(chambre.getClient().getUsername()).orElse(null);
			Client cl = findClientById(chambre.getClient().getUsername()).orElse(null);
			System.err.println(cl);
			Chambre m = new Chambre();
			m.setAnnee_const(chambre.getAnnee_const());
			m.setDescription(chambre.getDescription());
			m.setDisponibilite(chambre.getDisponibilite());
			m.setEtat(chambre.getEtat());
			m.setTitre(chambre.getTitre());
			m.setEtage(chambre.getEtage());
			m.setMat(UUID.randomUUID().toString().replace("-", ""));
			m.setMeuble(chambre.getMeuble());
			m.setNbr_personne(chambre.getNbr_personne());
			m.setPrix(chambre.getPrix());			
			m.setType_sol(chambre.getType_sol());
			m.setNbr_salle_bains(chambre.getNbr_salle_bains());
			m.setRue(chambre.getRue());
			m.setVille(chambre.getVille());
			m.setImageModel(crudRestClient.findImageByname(chambre.getImageModel().getMat()).orElse(null));
			if(cl != null) {
				m.setClient(cl);
				}
			crudRestClient.postChambre(m);
			return m ;
		}
		@DeleteMapping("/chambre/{id}")
		public void deleteChambreById(@PathVariable("id") String id) {
			crudRestClient.deleteChambreById(id);
		}
		
		@GetMapping("/chambre/{id}")
		public Optional<Chambre> findChambreById(@PathVariable("id") String id){
			return crudRestClient.findChambreById(id);
		}
		
		//Contact 
		@DeleteMapping("/contact/{id}")
		public void deleteContactById(@PathVariable("id") String id) {
			crudRestClient.deleteContactById(id);
		}
		
		@GetMapping("/contact/{id}")
		public Optional<Contact> findContactById(@PathVariable("id") String id){
			return crudRestClient.findContactById(id);
		}
		@GetMapping("/contact")
		public Resources<Contact> findAllContact(){
			return crudRestClient.findAllContact();
		}
		
		
		
}
