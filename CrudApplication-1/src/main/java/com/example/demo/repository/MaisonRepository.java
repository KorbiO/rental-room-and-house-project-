package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Maison;
@RepositoryRestResource(collectionResourceRel = "Maison", path = "maison")
public interface MaisonRepository extends MongoRepository<Maison, String>{

}
