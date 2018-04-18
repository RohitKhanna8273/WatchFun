package com.project.watchfun.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.watchfun.dto.Genre;

public interface GenreRepository extends CrudRepository<Genre, String> {

}
