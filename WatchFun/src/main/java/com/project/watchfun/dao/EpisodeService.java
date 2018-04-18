//package com.project.watchfun.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.watchfun.dto.Episode;
//import com.project.watchfun.repository.EpisodeRepository;
//
//@Service
//public class EpisodeService {
//	
//	@Autowired
//	EpisodeRepository episodeRepository;
//	
//	public List<Episode> getSingleEpisode(){
//		List<Episode> episode= new ArrayList<>();
//		episodeRepository.findAll().forEach(episode::add);
//		return episode;
//		
//	}
//	
//
//}
