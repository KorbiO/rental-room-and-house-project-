package com.example.demo.service;


import java.io.IOException;
import java.util.Optional;


import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Chambre;
import com.example.demo.entity.Client;
import com.example.demo.entity.Contact;
import com.example.demo.entity.ImageModel;
import com.example.demo.entity.Maison;

@FeignClient(name="CrudApplication")
public interface CrudRestClient {
	
	//Maison
	
	@GetMapping("/maison")
	public Resources<Maison> findAllMaison();
	
	@PutMapping("/maison/{id}")
	public Maison updatMaison(Maison maison , @PathVariable("id") String id);
	
	@PostMapping("/maison")
	public Maison postMaison(Maison maison);
	
	@DeleteMapping("/maison/{id}")
	public void deleteMaisonById(@PathVariable("id") String id);
	
	@GetMapping("/maison/{id}")
	public Optional<Maison> findMaisonById(@PathVariable("id") String id);
	
	//Chambre
	
	@GetMapping("/chambre")
	public Resources<Chambre> findAllChambre();
	
	@PutMapping("/chambre/{id}")
	public Chambre updatChambre(Chambre chambre , @PathVariable("id") String id);
	
	@PostMapping("/chambre")
	public Chambre postChambre(Chambre chambre);
	
	@DeleteMapping("/chambre/{id}")
	public void deleteChambreById(@PathVariable("id") String id);
	
	@GetMapping("/chambre/{id}")
	public Optional<Chambre> findChambreById(@PathVariable("id") String id);
	
	//Client
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id);
	
	//Image Model
	
	 @PostMapping("/image")
	 public ImageModel uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException ;
	 @PostMapping("/image")
	 public ImageModel uplaodImag(ImageModel image);
	 @GetMapping("/image/{name}")
	  public ImageModel getImage(@PathVariable("name") String name) throws IOException;
	 
	 @GetMapping("/image/{name}")
	  public Optional<ImageModel> findImageByname(@PathVariable("name") String name) ;
	 
	//Contact
		
		@GetMapping("/contact")
		public Resources<Contact> findAllContact();
		
		@PutMapping("/contact/{id}")
		public Contact updatContact(Contact contact , @PathVariable("id") String id);
		
		
		
		@DeleteMapping("/contact/{id}")
		public void deleteContactById(@PathVariable("id") String id);
		
		@GetMapping("/contact/{id}")
		public Optional<Contact> findContactById(@PathVariable("id") String id);
		
		
		
}
