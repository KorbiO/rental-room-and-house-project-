package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Chambre;
import com.example.demo.entity.ImageModel;
import com.example.demo.entity.Maison;
import com.example.demo.repository.ChambreRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.MaisonRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageUploadController {
	@Autowired
	
    private MaisonRepository maisonRepository;
@Autowired
	
    private ImageRepository imageRepo;
@Autowired
private ChambreRepository chambreRepo;
	
	@GetMapping("/allm")
	public List<Maison> getAllMaisons(){
		return maisonRepository.findAll();
	}
	@GetMapping("/allc")
	public List<Chambre> getAllChambres(){
		return chambreRepo.findAll();
	}
	@GetMapping("/img/{id}")
	public Optional<ImageModel> findImageById(@PathVariable("id") String id ){
		return imageRepo.findById(id);
	}
	@GetMapping("/chambrePrix")
	public List<Integer> chambrePrixTrie(){
		List<Integer> i = new ArrayList<Integer>();
		List<Chambre> c = chambreRepo.findAll();
		int prix1 = 0 ;
		int prix2 = 0 ;
		int prix3 = 0;
		int prix4 = 0 ;
		int prix5 = 0 ;
		for ( Chambre c1 : c ) {
			if(c1.getPrix() > 50 && c1.getPrix() <=100) {
				prix1 = prix1 + 1 ;
			}
			if(c1.getPrix() > 101 && c1.getPrix() <=200) {
				prix2 = prix2 + 1 ;
			}
			if(c1.getPrix() > 201 && c1.getPrix() <=300) {
				prix3 = prix3 + 1 ;
			}
			if(c1.getPrix() > 301 && c1.getPrix() <=400) {
				prix4 = prix4 + 1 ;
			}
			if(c1.getPrix() > 401 && c1.getPrix() <=500) {
				prix5 = prix5 + 1 ;
			}
			
		}
		if(prix1 != 0) {
			i.add(prix1);
		}else {
			i.add(0);
		}
		if(prix2 != 0) {
			i.add(prix2);
		}else {
			i.add(0);
		}
		if(prix3 != 0) {
			i.add(prix3);
		}else {
			i.add(0);
		}
		if(prix4 != 0) {
			i.add(prix4);
		}else {
			i.add(0);
		}
		if(prix5 != 0) {
			i.add(prix5);
		}else {
			i.add(0);
		}
		return i ;
	}
	@GetMapping("/maisonPrix")
	public List<Integer> maisonPrixTrie(){
		List<Integer> i = new ArrayList<Integer>();
		List<Maison> c = maisonRepository.findAll();
		int prix1 = 0 ;
		int prix2 = 0 ;
		int prix3 = 0;
		int prix4 = 0 ;
		int prix5 = 0 ;
		for ( Maison c1 : c ) {
			if(c1.getPrix() > 50 && c1.getPrix() <=100) {
				prix1 = prix1 + 1 ;
			}
			if(c1.getPrix() > 101 && c1.getPrix() <=200) {
				prix2 = prix2 + 1 ;
			}
			if(c1.getPrix() > 201 && c1.getPrix() <=300) {
				prix3 = prix3 + 1 ;
			}
			if(c1.getPrix() > 301 && c1.getPrix() <=400) {
				prix4 = prix4 + 1 ;
			}
			if(c1.getPrix() > 401 && c1.getPrix() <=500) {
				prix5 = prix5 + 1 ;
			}
			
		}
		if(prix1 != 0) {
			i.add(prix1);
		}else {
			i.add(0);
		}
		if(prix2 != 0) {
			i.add(prix2);
		}else {
			i.add(0);
		}
		if(prix3 != 0) {
			i.add(prix3);
		}else {
			i.add(0);
		}
		if(prix4 != 0) {
			i.add(prix4);
		}else {
			i.add(0);
		}
		if(prix5 != 0) {
			i.add(prix5);
		}else {
			i.add(0);
		}
		return i ;
	}
	
}
