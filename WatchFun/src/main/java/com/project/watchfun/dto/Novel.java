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
public class Novel extends Entertain implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "novel_genre", joinColumns = @JoinColumn(name = "novel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	private Set<Genre> genreSet;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "novel_auteur", joinColumns = @JoinColumn(name = "novel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "auteur_id", referencedColumnName = "id"))
	private Set<Auteur> auteurSet = new HashSet<>();

	@Id
	private String id;

	public Novel(String id, String name, String img, double rating, double price, String language, String downloadLink,
			String synopsis, double size, String status, Set<Genre> genreSet, Set<Auteur> auteurSet,int year) {
		super(name, img, rating, price, language, downloadLink, synopsis, size, status,year);
		this.id = id;
		this.genreSet = genreSet;
		this.auteurSet = auteurSet;
	}

	public Novel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Novel(String name, String img, double rating, double price) {
		super.name = name;
		super.img = img;
		super.rating = rating;
		super.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Genre> getGenreSet() {
		return genreSet;
	}

	public void setGenreSet(Set<Genre> genreSet) {
		this.genreSet = genreSet;
	}

	public Set<Auteur> getAuteurSet() {
		return auteurSet;
	}

	public void setAuteurSet(Set<Auteur> auteurSet) {
		this.auteurSet = auteurSet;
	}

	@Override
	public String toString() {
		return "Novel [id=" + id + ", genreSet=" + genreSet + ", auteurSet=" + auteurSet + "]";
	}

}
