package com.project.watchfun.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.watchfun.dao.TVSeriesService;
import com.project.watchfun.dto.TVSeries;

@Controller
public class TVSeriesController {
	
	@Autowired
	private TVSeriesService tvs;

	@RequestMapping(value = "tvseries/{tvseriesId}")
	public String tvSeriesInfo(Map<String, Object> model, @PathVariable("tvseriesId") int tvseriesId) {
		Optional<TVSeries> tvseries = tvs.getTVSeries(tvseriesId);
		((Model) model).addAttribute("tvserieObject", tvseries.get());

		return "tvseries_info";
	}
	
	@RequestMapping(value = "/tvseries/language/{languageName}")
	public String getTVSeriesOfLanguage(Map<String, Object> model, @PathVariable("languageName") String languageName) {
		((Model) model).addAttribute("tvseriesByLanguage", tvs.getTVSeriesByLanguage(languageName));
		return "browse_all_tvseries";
	}

	@RequestMapping(value = "/tvseries/year/{years}")
	public String getTVSeriesByYear(Map<String, Object> model, @PathVariable("years") int year) {
		((Model) model).addAttribute("tvseriesByYear", tvs.getTVSeriesByYear(year));
		return "browse_all_tvseries";
	}

	@RequestMapping(value = "/tvseries/rating/{rating}")
	public String getTVSeriesByRating(Map<String, Object> model, @PathVariable("rating") double rating) {
		((Model) model).addAttribute("tvseriesByRating", tvs.getTVSeriesByRating(rating));
		return "browse_all_tvseries";
	}

	@RequestMapping(value = "/tvseries/genre/{genre}")
	public String getTVSeriesByGenre(Map<String, Object> model, @PathVariable("genre") String genre) {
		((Model) model).addAttribute("tvseriesByGenre", tvs.getTVSeriesByGenre(genre));
		return "browse_all_tvseries";
	}
	
	@RequestMapping(value = "/search/tvseries/{searchItem}")
	public String doTVSeriesSearch(Map<String, Object> model, @PathVariable("searchItem") String searchItem) {
		((Model) model).addAttribute("searchByTVSeries", tvs.getTVSeriesBySearch(searchItem));
		return "browse_all";
	}
}
