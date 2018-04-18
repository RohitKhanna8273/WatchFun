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
public class TVSeries extends Entertain implements Serializable {

	/**
	 * Parent id has to be added. and Episode nad Season has yo be deleted.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tvseries_auteur", joinColumns = @JoinColumn(name = "tvseries_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "auteur_id", referencedColumnName = "id"))
	private Set<Auteur> auteurSet = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tvseries_genre", joinColumns = @JoinColumn(name = "tvseries_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	private Set<Genre> genreSet;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tvseries_cast", joinColumns = @JoinColumn(name = "tvseries_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cast_id", referencedColumnName = "id"))
	private Set<Cast> castSet = new HashSet<>();
	// @OneToMany(mappedBy="tvSeries")
	// private Set<Season> seasonSet = new HashSet<>();
	@Id
	private int id;
	private int parentId;

	public TVSeries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TVSeries(int id, int parentId, String name, String img, double rating, double price, String language,
			String downloadLink, String synopsis, double size, String status, Set<Auteur> auteurSet,
			Set<Genre> genreSet, Set<Cast> castSet,int year) {
		super(name, img, rating, price, language, downloadLink, synopsis, size, status,year);
		this.id = id;
		this.parentId = parentId;
		this.auteurSet = auteurSet;
		this.genreSet = genreSet;
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

	public Set<Cast> getCastSet() {
		return castSet;
	}

	public void setCastSet(Set<Cast> castSet) {
		this.castSet = castSet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "TVSeries [auteurSet=" + auteurSet + ", genreSet=" + genreSet + ", castSet=" + castSet + ", id=" + id
				+ ", parentId=" + parentId + "]";
	}

}
