package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CourseRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	
	//insert or update
//	public Course save(Long id) {
		
//	}
	
//	public Course deleteById(Long id) {
		
//	}
}
