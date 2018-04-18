package com.project.watchfun.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany(mappedBy="genreSet")
	private Set<Movie> movieSet = new HashSet<>();
	@ManyToMany(mappedBy="genreSet")
	private Set<TVSeries> tvseriesSet = new HashSet<>();
	@ManyToMany(mappedBy="genreSet")
	private Set<Novel> novelSet = new HashSet<>();

	public Genre() {

	}

	public Genre(String name) {
		super();

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<Movie> getMovieSet() {
		return movieSet;
	}

	public void setMovieSet(Set<Movie> movieSet) {
		this.movieSet = movieSet;
	}

	public Set<TVSeries> getTvseriesSet() {
		return tvseriesSet;
	}

	public void setTvseriesSet(Set<TVSeries> tvseriesSet) {
		this.tvseriesSet = tvseriesSet;
	}

	public Set<Novel> getNovelSet() {
		return novelSet;
	}

	public void setNovelSet(Set<Novel> novelSet) {
		this.novelSet = novelSet;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}

}
