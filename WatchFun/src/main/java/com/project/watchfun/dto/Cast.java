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
public class Cast implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Name;
	private String link;
	@ManyToMany(mappedBy="castSet")
	private Set<Movie> movieSet = new HashSet<>();
	@ManyToMany(mappedBy="castSet")
	private Set<TVSeries> tvseriesSet = new HashSet<>();

	public Cast() {

	}

	public Cast( String name, String link) {
		super();
		
		Name = name;
		this.link = link;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<Movie> getMovieSet(){
		return movieSet;
	}
	public Set<TVSeries> getTvseriesSet() {
		return tvseriesSet;
	}

	public void setTvseriesSet(Set<TVSeries> tvseriesSet) {
		this.tvseriesSet = tvseriesSet;
	}

	@Override
	public String toString() {
		return "Cast [id=" + id + ", Name=" + Name + ", link=" + link  + "]";
	}

	public void setMovieSet(Set<Movie> movieSet) {
		this.movieSet=movieSet;
		
	}

	
	
}
