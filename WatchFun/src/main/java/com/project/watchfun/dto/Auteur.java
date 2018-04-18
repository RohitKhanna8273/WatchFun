package com.project.watchfun.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Auteur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String link;
	
	@ManyToMany(mappedBy="auteurSet")
	private Set<Movie> movieSet = new HashSet<>();
	@ManyToMany(mappedBy="auteurSet")
	private Set<Novel> novelSet = new HashSet<>();
	@ManyToMany(mappedBy="auteurSet")
	private Set<TVSeries> tvSeriesSet = new HashSet<>();
	
	public Auteur() {
		
	}

	public Auteur(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Set<Movie> getMovieSet() {
		return movieSet;
	}

	public void setMovieSet(Set<Movie> movieSet) {
		this.movieSet = movieSet;
	}

	public Set<Novel> getNovelSet() {
		return novelSet;
	}

	public void setNovelSet(Set<Novel> novelSet) {
		this.novelSet = novelSet;
	}

	public Set<TVSeries> getTvSeriesSet() {
		return tvSeriesSet;
	}

	public void setTvSeriesSet(Set<TVSeries> tvSeriesSet) {
		this.tvSeriesSet = tvSeriesSet;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", name=" + name + ", link=" + link + "]";
	}
	
	
}
