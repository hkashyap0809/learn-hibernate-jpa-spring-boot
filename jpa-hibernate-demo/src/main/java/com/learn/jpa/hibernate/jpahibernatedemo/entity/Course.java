package com.learn.jpa.hibernate.jpahibernatedemo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity

@NamedQueries(
		value = {
				@NamedQuery(name="query_get_all_courses",query="SELECT C FROM Course C"),
				@NamedQuery(name="query_get_course_ING",query="SELECT C FROM Course C where name like '%ING'")				
		}
)


public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Course() {
		
	}
	
	public Course(Long id, String name) {
		super();
		this.id =id;
		this.name = name;
	}
	public Course(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	

}
