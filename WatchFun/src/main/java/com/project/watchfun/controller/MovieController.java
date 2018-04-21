package com.project.watchfun.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.watchfun.dao.MovieService;
import com.project.watchfun.dto.Movie;

@Controller
public class MovieController {

	@Autowired
	private MovieService ms;
	
	@RequestMapping(value = "movie/{movieId}")
	public String movieInfo(Map<String, Object> model, @PathVariable("movieId") String movieId) {
		Optional<Movie> movie = ms.getMovie(movieId);
		((Model) model).addAttribute("movieObject", movie.get());

		return "movie_info";
	}
	
	@RequestMapping(value = "/movies/language/{languageName}")
	public String getMoviesOfLanguage(Map<String, Object> model, @PathVariable("languageName") String languageName) {
		((Model) model).addAttribute("moviesByLanguage", ms.getMovieByLanguage(languageName));
		return "browse_all_movies";
	}

	@RequestMapping(value = "/movies/year/{years}")
	public String getMoviesByYear(Map<String, Object> model, @PathVariable("years") int year) {
		((Model) model).addAttribute("moviesByYear", ms.getMoviesByYear(year));
		return "browse_all_movies";
	}

	@RequestMapping(value = "/movies/rating/{rating}")
	public String getMoviesByRating(Map<String, Object> model, @PathVariable("rating") double rating) {
		((Model) model).addAttribute("moviesByRating", ms.getMoviesByRating(rating));
		return "browse_all_movies";
	}

	@RequestMapping(value = "/movies/genre/{genre}")
	public String getMoviesByGenre(Map<String, Object> model, @PathVariable("genre") String genre) {
		((Model) model).addAttribute("moviesByGenre", ms.getMoviesByGenre(genre));
		return "browse_all_movies";
	}
	

	@RequestMapping(value = "/search/movie/{searchItem}")
	public String doMovieSearch(Map<String, Object> model, @PathVariable("searchItem") String searchItem) {
		((Model) model).addAttribute("searchByMovie", ms.getMoviesBySearch(searchItem));
		return "browse_all_movies";
	}
}
