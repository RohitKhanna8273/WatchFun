package com.project.watchfun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.watchfun.dto.TVSeries;

public interface TVSeriesRepository extends CrudRepository<TVSeries, Integer>{
	
	@Query("SELECT tvs FROM TVSeries tvs INNER JOIN tvs.genreSet g WHERE g.name = ?1")
	List<TVSeries> findByGenreName(String name);
	List<TVSeries> findByLanguage(String language);
	List<TVSeries> findByYearGreaterThan(int year);
	List<TVSeries> findByRatingGreaterThan(double rating);
	@Query("SELECT tv FROM TVSeries tv WHERE tv.name LIKE %?1%")
	List<TVSeries> findBySearch(String searchItem);

}
