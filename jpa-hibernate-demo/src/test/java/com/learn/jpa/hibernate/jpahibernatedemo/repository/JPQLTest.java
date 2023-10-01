package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.learn.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class JPQLTest {

	@Autowired
	EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Test
	public void RawQueryJPQLTest() {
		List resultList = entityManager.createQuery("SELECT C FROM Course C").getResultList();
		logger.info("SELECT C FROM COURSE C -> {}",resultList.toString());
	}
	@Test
	public void typedQueryJpQLTest() {
		TypedQuery<Course> getAllCourseQuery = entityManager.createQuery("SELECT C FROM Course C",Course.class);
		List<Course> allCourses = getAllCourseQuery.getResultList();
		logger.info("Typed Query -> {}",allCourses.toString());
				
	}
	
	@Test
	public void whereJPQLTest() {
		TypedQuery<Course> getAllCourseQuery = entityManager.createQuery("SELECT C FROM Course C where name like '%ING'",Course.class);
		List<Course> allCourses = getAllCourseQuery.getResultList();
		logger.info("WHERE CLAUSE Query -> {}",allCourses.toString());
				
	}
	

}
