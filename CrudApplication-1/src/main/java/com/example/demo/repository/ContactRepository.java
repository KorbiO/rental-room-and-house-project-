package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Administrateur;
import com.example.demo.entity.Contact;

@RepositoryRestResource(collectionResourceRel = "Contact", path = "contact")
public interface ContactRepository extends MongoRepository<Contact, String>{

}
