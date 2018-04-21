package com.project.watchfun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.watchfun.dto.Novel;

public interface NovelRepository extends CrudRepository<Novel, String>{
	
	@Query("SELECT n FROM Novel n INNER JOIN n.genreSet g WHERE g.name = ?1")
	List<Novel> findByGenreName(String name);
	List<Novel> findByLanguage(String language);
	List<Novel> findByYearGreaterThan(int year);
	List<Novel> findByRatingGreaterThan(double rating);
	@Query("SELECT n FROM Novel n WHERE n.name LIKE %?1%")
	List<Novel> findBySearch(String searchItem);

}
