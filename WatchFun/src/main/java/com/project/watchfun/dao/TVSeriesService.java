package com.project.watchfun.dao;
import java.util.ArrayList;
import java.util.List;

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
	
	
}