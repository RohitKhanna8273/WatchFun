package com.project.watchfun.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.watchfun.dto.Auteur;
import com.project.watchfun.repository.AuteurRepository;

@Service
public class AuteurService {
    
	@Autowired
	private AuteurRepository auteurRepository;
	
	public List<Auteur> getSingleCategory(){
		List<Auteur> auteur = new ArrayList<>();
		auteurRepository.findAll().forEach(auteur::add);
		return auteur;
	}
	
}
