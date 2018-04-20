package com.project.watchfun;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.watchfun.dao.MovieService;
import com.project.watchfun.dao.NovelService;
import com.project.watchfun.dao.TVSeriesService;
import com.project.watchfun.dto.Movie;

@Controller
public class HomeController {

	@Autowired
	private MovieService ms;
	@Autowired
	private NovelService ns;
	@Autowired
	private TVSeriesService ts;

	@RequestMapping(value= {"/home" , "/" , "index"})
	public String welcome(Map<String, Object> model) {

		((Model) model).addAttribute("movAll", ms.getAllMovies());
		((Model) model).addAttribute("movLatest", ms.getAllMovies());
		((Model) model).addAttribute("movFav", ms.getAllMovies());
		((Model) model).addAttribute("movUpcoming", ms.getAllMovies());
		
		((Model) model).addAttribute("nov", ns.getAllNovels());
		((Model) model).addAttribute("tvs", ts.getAllTVSeries());

		return "Welcome";
	}
	
	@RequestMapping(value="/{category}")
	public String browse(Map<String, Object> model, @PathVariable("category") String category) {
		
		switch(category) {
		case "movies" : ((Model) model).addAttribute("mov", ms.getAllMovies()); break;
		case "novels" : ((Model) model).addAttribute("nov", ns.getAllNovels()); break;
		case "tvseries" : ((Model) model).addAttribute("tvs", ts.getAllTVSeries()); break;
		
		default : return "error";
		}
		
		return "browse_all";
	}
	
	@RequestMapping(value="/contactUs")
	public String contactUs(Map<String, Object> model){
		return "contact_us";
	}

	@RequestMapping(value="/aboutUs")
	public String aboutUs(Map<String, Object> model){
		return "about_us";
	}
	
	@RequestMapping(value = "movie/{movieId}")
	public String movieInfo(Map<String, Object> model, @PathVariable("movieId") String movieId) {
		Optional<Movie> movie = ms.getMovie(movieId);
		((Model) model).addAttribute("movieObject", movie.get());

		return "movie_info";
	}

	@RequestMapping("/save1")
	public String save1() {
		return ms.insertMov();
	}

	@RequestMapping("/save2")
	public String save2() {
		return ms.insertNovel();
	}

	@RequestMapping("/save3")
	public String save3() {
		return ms.insertTVSeries();
	}
	@RequestMapping(value="language/{languageName}")
	public String getMoviesOfLanguage(Map<String, Object> model, @PathVariable("languageName") String languageName) {
		((Model) model).addAttribute("moviesByLanguage", ms.getMovieByLanguage(languageName));
		return "browse_all";
	}

	@RequestMapping(value="year/{years}")
	public String getMoviesByYear(Map<String, Object> model, @PathVariable("years") int year) {
		((Model) model).addAttribute("moviesByYear", ms.getMoviesByYear(year));
		return "browse_all";
	}
	
	@RequestMapping(value="rating/{rating}")
	public String getMoviesByRating(Map<String, Object> model, @PathVariable("rating") double rating) {
		((Model) model).addAttribute("moviesByRating", ms.getMoviesByRating(rating));
		return "browse_all";
	}
	
	@RequestMapping(value="genre/{genre}")
	public String getMoviesByGenre(Map<String, Object> model, @PathVariable("genre") String genre) {
		((Model) model).addAttribute("moviesByGenre", ms.getMoviesByGenre(genre));
		return "browse_all";
	}
}

// movieList.add(new Movies("movie1", "latest", "Avengers",
// "img/portfolio/01-large.jpg", "img/portfolio/01-small.jpg"));
