package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Review;

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
		Course course1 = new Course("Learn Code Smells");
		entityManager.persist(course1);

		Course course2 = findById(10002L);
		course2.setName("Learn REACTJS");
		entityManager.persist(course2);
	}


	public void addReviewsForCourse() {
		//get the course 10003
		Course course = findById(10003L);

		logger.info("course reviews => {}",course.getReviews());

		//add 2 reviews
		Review review1 = new Review("good course", "5");
		Review review2 = new Review("okayish course", "2");
				
		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		//save to database
		entityManager.persist(review1);
		entityManager.persist(review2);

	}
}
