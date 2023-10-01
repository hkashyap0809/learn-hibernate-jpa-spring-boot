package com.learn.jpa.hibernate.jpahibernatedemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String description;

	public String rating;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}	
	public String getRating() {
		return rating;
	}

	public Review() {

	}
	public Review(String description,String rating) {
		super();
		this.description = description;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + ", rating=" + rating + "]";
	}



}
