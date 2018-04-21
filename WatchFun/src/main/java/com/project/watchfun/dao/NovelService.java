package com.project.watchfun.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.watchfun.dto.Auteur;
import com.project.watchfun.dto.Genre;
import com.project.watchfun.dto.Novel;
import com.project.watchfun.repository.NovelRepository;

@Service
public class NovelService {

	@Autowired
	NovelRepository novelRepository;
	
	public List<Novel> getAllNovels() {
		List<Novel> categories= new ArrayList<>();
	   novelRepository.findAll().forEach(categories::add);
	 return categories;
	}
	
	public String insertNovel() {
		Set<Auteur> auteurSet = new HashSet<>();
		auteurSet.add(new Auteur("Ram", "Ram's Link"));
		auteurSet.add(new Auteur("Shyam", "Shyam's Link"));
		Set<Genre> genreSet=new HashSet<>();
		genreSet.add(new Genre("comedy"));
		genreSet.add(new Genre("action"));
		genreSet.add(new Genre("fiction"));
		Novel nov= new Novel("id", "name", "img", 20, 20, "language", "downloadLink", "synopsis", 20, "status", genreSet, auteurSet,2018);
		novelRepository.save(nov);
		return "inserted";
	}

public List<Novel> getNovelsByLanguage(String languageName) {
		
		return novelRepository.findByLanguage(languageName);
	}

	public List<Novel> getNovelsByYear(int year) {
		return novelRepository.findByYearGreaterThan(year-1);
	}

	public List<Novel> getNovelsByRating(double rating) {
		return novelRepository.findByRatingGreaterThan(rating-1);
	}

	public List<Novel> getNovelsByGenre(String genre) {
		return novelRepository.findByGenreName(genre);
	}

	
	public List<Novel> getNovelsBySearch(String searchItem) {
		searchItem = searchItem.replace('+', ' ');
		return novelRepository.findBySearch(searchItem);
	}

	public Optional<Novel> getNovel(String novelId) {
		return novelRepository.findById(novelId);
	}
}



