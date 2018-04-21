package com.project.watchfun.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.watchfun.dto.Auteur;
import com.project.watchfun.dto.Cast;
import com.project.watchfun.dto.Genre;
import com.project.watchfun.dto.Movie;
import com.project.watchfun.dto.Novel;
import com.project.watchfun.dto.TVSeries;
import com.project.watchfun.repository.MovieRepository;
import com.project.watchfun.repository.NovelRepository;
import com.project.watchfun.repository.TVSeriesRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private NovelRepository novelRepository;
	@Autowired
	private TVSeriesRepository tvSeriesRepository;

	public List<Movie> getAllMovies() { 
		List<Movie> movieList = new ArrayList<>();
		movieRepository.findAll().forEach(movieList::add);
		return movieList;

	}
	

	public String insertMov(int i) {

		Set<Auteur> auteurSet = new HashSet<>();

		auteurSet.add(new Auteur("Lee Unkrich", "www.imdb.com/name/nm0881279/?ref_=fn_nm_nm_1"));
		auteurSet.add(new Auteur("Adrian Molina", "www.imdb.com/name/nm2937122/?ref_=fn_nm_nm_1"));
		// **************************************
		Set<Genre> genreSet = new HashSet<>();

		genreSet.add(new Genre("Comedy"));
		genreSet.add(new Genre("Adventure"));
		genreSet.add(new Genre("Animation"));
		// **************************************
		Set<Cast> castSet = new HashSet<>();

		castSet.add(new Cast("Anthany Gonzalez", "https://en.wikipedia.org/wiki/Anthony_Gonzalez_(actor)"));
		castSet.add(new Cast("Gael García Bernal", "https://en.wikipedia.org/wiki/Gael_Garc%C3%ADa_Bernal"));
		castSet.add(new Cast("Benjamin Bratt", "https://en.wikipedia.org/wiki/Benjamin_Bratt"));
		castSet.add(new Cast("Alanna Ubach", "https://en.wikipedia.org/wiki/Alanna_Ubach"));
		Movie movie = new Movie("coco"+i, "Coco", "/img/movies/coco.jpg", 8.5, 20, "English", "/source/Coco.torrent",
				"Despite his family's baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.",
				700, "released", castSet, auteurSet, genreSet,2018);
		movieRepository.save(movie);

		return "inserterd";
	}

	public String insertAllmData() {
		for(int i=1;i<=5;i++)
		insertMov(i);
		
		return "done";
	}
	public String insertAllnData() {
		for(int i=1;i<=5;i++)
		insertNovel(i);
		
		return "done";
	}
	public String insertAlltData() {
		for(int i=1;i<=5;i++)
		insertTVSeries(i);
		
		return "done";
	}

	public String insertNovel(int i) {

		Set<Genre> genreSet = new HashSet<>();
		Genre genre1 = new Genre("Sci-fi");
		Genre genre2 = new Genre("comic");
		genreSet.add(genre1);
		genreSet.add(genre2);

		Set<Auteur> auteurSet = new HashSet<>();
		Auteur auteur1 = new Auteur("Nicolas Spark", "NS-link");
		Auteur auteur2 = new Auteur("Charles", "cs-link");
		auteurSet.add(auteur1);
		auteurSet.add(auteur2);

		Novel novel1 = new Novel("id1"+i, "MIB", "/img/movies/.jpg", 8, 20, "English", "/source/novel.pdf", "Connor’s grandmother leaves his dad a letter when she dies, and the letter’s confession shakes their tight-knit Italian-American family: The man who raised Dad is not his birth father.\r\n" + 
				" \r\n" + 
				"But the only clues to this birth father’s identity are a class ring and a pair of pilot’s wings. And so Connor takes it upon himself to investigate—a pursuit that becomes even more pressing when Dad is hospitalized after a stroke. What Connor discovers will lead him and his father to a new, richer understanding of race, identity, and each other.", 20, "released",
				genreSet, auteurSet,2018);

		novelRepository.save(novel1);

		return "novel inserted";
	}

	public String insertTVSeries(int i) {

		Set<Auteur> auteurSet = new HashSet<>();
		Auteur auteur1 = new Auteur("TVS auteur", "link");
		Auteur auteur2 = new Auteur("TVS auteur2", "link");
		auteurSet.add(auteur1);
		auteurSet.add(auteur2);

		Set<Genre> genreSet = new HashSet<>();
		Genre genre1 = new Genre("TVS-Sci-fi");
		Genre genre2 = new Genre("TVS-comic");
		genreSet.add(genre1);
		genreSet.add(genre2);

		Set<Cast> castSet = new HashSet<>();
		Cast cast1 = new Cast("TVS cast", "link");
		Cast cast2 = new Cast("TVS cast1", "link");
		castSet.add(cast1);
		castSet.add(cast2);

		TVSeries tvSeries = new TVSeries(i, 0, "name", "img/tvseries/", 5.0, 20, "english", "/sources/I-origin.torrent", "Back in the girl-power heyday of the 90s, a hit single would easily get you 15 minutes of fame. But today you'd be lucky to get 15 seconds. Maxine, played by People Just Do Nothing's Lily Brazier, never made it big with her teenage girl group Variety and now, as a middle-aged failing music manager, she finds herself in crisis, as the one act she looked after decides to drop her. But Maxine has a plan, a come back. This time bigger, bolder and, well - older. Who cares about a hip young girl group anyway?. What the world really needs is the first ever band of mums. And with Maxine at the helm, how can Mum Pop possibly fail? WANNABE is the story of unfinished business, one last shot at fame and struggling to let go of a dream.", 210,
				"released", auteurSet, genreSet, castSet,2018);
		tvSeriesRepository.save(tvSeries);
		return "tv series inserded";
	}

	public Optional<Movie> getMovie(String movieId) {
		return movieRepository.findById(movieId);
		
	}

	public List<Movie> getMovieByLanguage(String language) {
		return movieRepository.findByLanguage(language);
	}
	
	public List<Movie> getMoviesByYear(int year) {
		return movieRepository.findByYearGreaterThan(year-1);
	}
	public List<Movie> getMoviesByRating(double rating) {
		return movieRepository.findByRatingGreaterThan(rating-1);
	}

	public List<Movie> getMoviesByGenre(String genre) {
		return movieRepository.findByGenreName(genre);
	}

	public List<Movie> getMoviesBySearch(String searchItem) {
		searchItem = searchItem.replace('+', ' ');
		return movieRepository.findBySearch(searchItem);
	}
}

// public String insertCategory() {
// Category category=new Category("120","12","123");
// categoryRepo.save(category);
// return "inserted";
// }