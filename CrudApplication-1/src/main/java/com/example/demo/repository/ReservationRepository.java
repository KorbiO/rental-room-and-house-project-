package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Reservation;
@RepositoryRestResource(collectionResourceRel = "Reservation", path = "reservation")
public interface ReservationRepository extends MongoRepository<Reservation, String>{

}
