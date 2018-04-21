package com.project.watchfun.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.watchfun.dto.TVSeries;
import com.project.watchfun.repository.TVSeriesRepository;

@Service
public class TVSeriesService {

	@Autowired
	TVSeriesRepository tvSeriesRepository;
	
	public List<TVSeries> getAllTVSeries() {
		List<TVSeries> categories = new ArrayList<>();
		tvSeriesRepository.findAll().forEach(categories::add);
		return categories;
	}

	public List<TVSeries> getTVSeriesBySearch(String searchItem) {
		searchItem = searchItem.replace('+', ' ');
		return tvSeriesRepository.findBySearch(searchItem);
	}

	public List<TVSeries> getTVSeriesByLanguage(String languageName) {
		
		return tvSeriesRepository.findByLanguage(languageName);
	}

	public List<TVSeries> getTVSeriesByYear(int year) {
		return tvSeriesRepository.findByYearGreaterThan(year-1);
	}

	public List<TVSeries> getTVSeriesByRating(double rating) {
		return tvSeriesRepository.findByRatingGreaterThan(rating-1);
	}

	public List<TVSeries> getTVSeriesByGenre(String genre) {
		return tvSeriesRepository.findByGenreName(genre);
	}

	public Optional<TVSeries> getTVSeries(int tvseriesId) {
		return tvSeriesRepository.findById(tvseriesId);
	}
	
	
}