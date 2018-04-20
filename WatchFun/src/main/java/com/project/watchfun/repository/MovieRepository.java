package com.project.watchfun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.watchfun.dto.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {
	
	//@Query("SELECT m FROM Movie m WHERE m.id=(SELECT mg.movie_id FROM movie_genre mg WHERE mg.genre_id=(SELECT g.id FROM Genre g WHERE g.name=?1))")
	@Query("SELECT m FROM Movie m INNER JOIN m.genreSet g WHERE g.name = ?1")
	List<Movie> findByGenreName(String name);
	List<Movie> findByLanguage(String language);
	List<Movie> findByYearGreaterThan(int year);
	List<Movie> findByRatingGreaterThan(double rating);
	
}
