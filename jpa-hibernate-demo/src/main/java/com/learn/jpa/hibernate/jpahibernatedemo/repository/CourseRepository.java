package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CourseRepository {

	@PersistenceContext
	EntityManager entityManager;

	//find by ID
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}


	//insert or update
	public void save(Course course) {
		Course dbCourse = findById(course.getId());
		if( dbCourse == null ) {
			//insert
			entityManager.persist(course);
		}else {
			//update
			entityManager.merge(course);
		}
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
}
