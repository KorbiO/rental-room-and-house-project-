package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Chambre;

@RepositoryRestResource(collectionResourceRel = "Chambre", path = "chambre")
public interface ChambreRepository extends MongoRepository<Chambre, String>{

}
