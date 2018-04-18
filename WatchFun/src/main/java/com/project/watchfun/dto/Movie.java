package com.project.watchfun.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie extends Entertain implements Serializable {

	@Id
	private String id;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cast_id", referencedColumnName = "id"))
	private Set<Cast> castSet = new HashSet<>();

	private static final long serialVersionUID = 1L;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_auteur", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "auteur_id", referencedColumnName = "id"))
	private Set<Auteur> auteurSet = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	private Set<Genre> genreSet;

	public Movie() {
		super();
	}

	public Movie(String name, String img, double rating, double price) {
		super.name = name;
		super.img = img;
		super.rating = rating;
		super.price = price;
	}

	public Movie(String id, String name, String img, double rating, double price, String language, String downloadLink,
			String synopsis, double size, String status, Set<Cast> castSet, Set<Auteur> auteurSet,
			Set<Genre> genreSet,int year) {
		super(name, img, rating, price, language, downloadLink, synopsis, size, status,year);
		this.id = id;
		this.castSet = castSet;
		this.auteurSet = auteurSet;
		this.genreSet = genreSet;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Cast> getCastSet() {
		return castSet;
	}

	public void setCastSet(Set<Cast> castSet) {
		this.castSet = castSet;
	}

	public Set<Auteur> getAuteurSet() {
		return auteurSet;
	}

	public void setAuteurSet(Set<Auteur> auteurSet) {
		this.auteurSet = auteurSet;
	}

	public Set<Genre> getGenreSet() {
		return genreSet;
	}

	public void setGenreSet(Set<Genre> genreSet) {
		this.genreSet = genreSet;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", castSet=" + castSet + ", auteurSet=" + auteurSet + ", genreSet=" + genreSet + "]";
	}

}
