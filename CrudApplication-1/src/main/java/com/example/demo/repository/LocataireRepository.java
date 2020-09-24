package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.entity.Locataire;

@RepositoryRestResource(collectionResourceRel = "Locataire", path = "locataire")
public interface LocataireRepository  extends MongoRepository<Locataire, String>{

}
