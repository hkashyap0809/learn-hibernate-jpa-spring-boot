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
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class NativeQueryTest {

	@Autowired
	EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Test
	public void nativeQueryTest() {
		Query query = entityManager.createNativeQuery("SELECT * FROM COURSE",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("NATIVE QUERY SELECT * FROM COURSE -> {}", resultList);
	}
	
	@Test
	public void parameterNativeQueryTest() {
		Query query = entityManager.createNativeQuery("SELECT * FROM COURSE WHERE id = :id",Course.class);
		query.setParameter("id", 10001L);
		List<Course> resultList = query.getResultList();
		logger.info("NATIVE QUERY SELECT * FROM COURSE WHERE ID = 10001 -> {}", resultList);
	}
	
	@Test 
	@Transactional
	public void updateAllCourse() {
		Query query = entityManager.createNativeQuery("UPDATE COURSE SET LAST_UPDATED_DATE=NOW()",Course.class);
		int rowUpdated = query.executeUpdate();
		logger.info("ROWS UPDATED -> {}",rowUpdated);
		
	}

}
