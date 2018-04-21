package com.project.watchfun;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.watchfun.dao.MovieService;
import com.project.watchfun.dao.NovelService;
import com.project.watchfun.dao.TVSeriesService;

@Controller
public class HomeController {

	@Autowired
	private MovieService ms;
	@Autowired
	private NovelService ns;
	@Autowired
	private TVSeriesService ts;

	@RequestMapping(value = { "/home", "/", "index" })
	public String welcome(Map<String, Object> model) {

		((Model) model).addAttribute("movAll", ms.getAllMovies());
		((Model) model).addAttribute("movLatest", ms.getAllMovies());
		((Model) model).addAttribute("movFav", ms.getAllMovies());
		((Model) model).addAttribute("movUpcoming", ms.getAllMovies());

		((Model) model).addAttribute("novAll", ns.getAllNovels());
		((Model) model).addAttribute("novLatest", ns.getAllNovels());
		((Model) model).addAttribute("novFav", ns.getAllNovels());
		((Model) model).addAttribute("novUpcoming", ns.getAllNovels());

		((Model) model).addAttribute("tvsAll", ts.getAllTVSeries());
		((Model) model).addAttribute("tvsLatest", ts.getAllTVSeries());
		((Model) model).addAttribute("tvsFav", ts.getAllTVSeries());
		((Model) model).addAttribute("tvsUpcoming", ts.getAllTVSeries());

		return "Welcome";
	}

	@RequestMapping(value = "/{category}")
	public String browse(Map<String, Object> model, @PathVariable("category") String category) {

		switch (category) {
		case "movies": {
			((Model) model).addAttribute("mov", ms.getAllMovies());
			return "browse_all_movies";
		}
		case "novels": {
			((Model) model).addAttribute("nov", ns.getAllNovels());
			return "browse_all_novels";
		}
		case "tvseries": {
			((Model) model).addAttribute("tvs", ts.getAllTVSeries());
			return "browse_all_tvseries";
		}

		default:
			return "error";
		}

	}

	@RequestMapping(value = "/contactUs")
	public String contactUs(Map<String, Object> model) {
		return "contact_us";
	}

	@RequestMapping(value = "/aboutUs")
	public String aboutUs(Map<String, Object> model) {
		return "about_us";
	}

	@RequestMapping("/save1")
	public String save1() {
		return ms.insertAllmData();
	}

	@RequestMapping("/save2")
	public String save2() {
		return ms.insertAllnData();
	}

	@RequestMapping("/save3")
	public String save3() {
		return ms.insertAlltData();
	}

}
