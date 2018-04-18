package com.project.watchfun.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class Entertain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected String img;
	private String status;
	protected double rating;
	protected double price;
	private String language;
	private String downloadLink;
	@Column(length=8000)
	private String synopsis;
	private double size;
	private int year;
	
	public Entertain() {
		
	}

	public Entertain(String name, String img, double rating, double price,
			String language, String downloadLink, String synopsis,double size,String status,int year) {
		super();
		this.name = name;
		this.img = img;
		this.rating = rating;
		this.price = price;
		this.language = language;
		this.downloadLink = downloadLink;
		this.synopsis = synopsis;
		this.size=size;
		this.status=status;
		this.year=year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Entertain [name=" + name + ", img=" + img + ", status=" + status + ", rating=" + rating + ", price="
				+ price + ", language=" + language + ", downloadLink=" + downloadLink + ", synopsis=" + synopsis
				+ ", size=" + size + ", year=" + year + "]";
	}

	
}
