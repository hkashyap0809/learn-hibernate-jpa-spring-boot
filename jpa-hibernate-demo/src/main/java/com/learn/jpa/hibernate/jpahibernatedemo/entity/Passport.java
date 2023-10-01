package com.learn.jpa.hibernate.jpahibernatedemo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String number;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return number;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.number = name;
	}
	
	public Passport() {
		
	}
	
	public Passport(Long id, String name) {
		super();
		this.id =id;
		this.number = name;
	}
	public Passport(String name) {
		super();
		this.number = name;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", name=" + number + "]";
	}
	
	

}
