package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Administrateur;
import com.example.demo.entity.ImageModel;
import com.example.demo.entity.Maison;

@RepositoryRestResource(collectionResourceRel = "ImageModel", path = "image")
public interface ImageRepository extends MongoRepository<ImageModel, String>{
	Optional<ImageModel> findByName(String name);
	
}
