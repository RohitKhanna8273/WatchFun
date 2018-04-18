//package com.project.watchfun.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.watchfun.dto.Season;
//import com.project.watchfun.repository.SeasonRepository;
//
//@Service
//public class SeasonService {
//
//	@Autowired
//	SeasonRepository seasonRepository;
//	
//	public List<Season> getAllSeasons() {
//		List<Season> categories= new ArrayList<>();
//	    seasonRepository.findAll().forEach(categories::add);
//	    return categories;
//	}
//}
