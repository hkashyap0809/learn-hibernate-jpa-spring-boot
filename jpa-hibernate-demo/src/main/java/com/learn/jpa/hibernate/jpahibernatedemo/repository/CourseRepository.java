package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
	
	public void playWithEntityManager() {
		Course course1 = new Course("Learn Design Pattern");
		entityManager.persist(course1);
		
		Course course2 = new Course("Learn Architectural Patterns");
		entityManager.persist(course2);
		entityManager.flush();
		
		course1.setName("Learn Design Patterns - updated");
		course2.setName("Learn Architectural Patterns - updated");
		
		entityManager.refresh(course1);
		entityManager.flush();
	}
}
