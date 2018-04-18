//package com.project.watchfun.dto;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.ElementCollection;
//import javax.persistence.Embeddable;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
//
//@Embeddable
//public class Season implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private String name; 
//	private String url;
//	@ElementCollection
//	@JoinTable(name="episode_table", joinColumns="")
//	private Set<Episode> episodeSet= new HashSet<>();
//	@ManyToOne
//	private TVSeries tvSeries;
//	
//	public Season() {
//		
//	}
//
//	public Season(String id, String url, Auteur auteur,Set<Episode> episodeSet) {
//		super();
//		this.episodeSet=episodeSet;
//		this.id = id;
//		this.url = url;
//		this.auteur = auteur;
//	}
//
//
//
//	
//	
//}
