package com.project.watchfun.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.watchfun.dto.Genre;
import com.project.watchfun.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	GenreRepository genreRepository;
	
	public List<Genre> getSingleGenre(){
		List<Genre> genre= new ArrayList<>();
		genreRepository.findAll().forEach(genre::add);
		return genre;
	}

}
