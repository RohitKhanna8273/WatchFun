package com.project.watchfun.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.watchfun.dto.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {

//	List<Movie> findByGenreName(String name);
	List<Movie> findByLanguage(String language);
	List<Movie> findByYearGreaterThan(int year);
	List<Movie> findByRatingGreaterThan(double rating);
	
}
