package com.project.watchfun.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.watchfun.dao.NovelService;
import com.project.watchfun.dto.Novel;

@Controller
public class NovelController {

	@Autowired
	private NovelService ns;
	
	@RequestMapping(value = "novel/{novelId}")
	public String novelInfo(Map<String, Object> model, @PathVariable("novelId") String novelId) {
		Optional<Novel> novel = ns.getNovel(novelId);
		((Model) model).addAttribute("novelObject", novel.get());

		return "novel_info";
	}
	
	@RequestMapping(value = "/novels/language/{languageName}")
	public String getNovelsOfLanguage(Map<String, Object> model, @PathVariable("languageName") String languageName) {
		((Model) model).addAttribute("novelsByLanguage", ns.getNovelsByLanguage(languageName));
		return "browse_all_novels";
	}

	@RequestMapping(value = "/novels/year/{years}")
	public String getNovelsByYear(Map<String, Object> model, @PathVariable("years") int year) {
		((Model) model).addAttribute("novelsByYear", ns.getNovelsByYear(year));
		return "browse_all_novels";
	}

	@RequestMapping(value = "/novels/rating/{rating}")
	public String getNovelsByRating(Map<String, Object> model, @PathVariable("rating") double rating) {
		((Model) model).addAttribute("novelsByRating", ns.getNovelsByRating(rating));
		return "browse_all_novels";
	}

	@RequestMapping(value = "/novels/genre/{genre}")
	public String getNovelsByGenre(Map<String, Object> model, @PathVariable("genre") String genre) {
		((Model) model).addAttribute("novelsByGenre", ns.getNovelsByGenre(genre));
		return "browse_all_novels";
	}
	
	@RequestMapping(value = "/search/novel/{searchItem}")
	public String doNovelSearch(Map<String, Object> model, @PathVariable("searchItem") String searchItem) {
		((Model) model).addAttribute("searchByNovel", ns.getNovelsBySearch(searchItem));
		return "browse_all_novels";
	}
}
