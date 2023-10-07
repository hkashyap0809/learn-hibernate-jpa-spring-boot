package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.learn.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Passport;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

	@Test
//	@Transactional
	void retrieveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("Student -> {}",student);
//		logger.info("Passport -> {}",student.getPassport());

	}
	
	@Test
	@Transactional
	void retrievePassportAndAssociatedStudentDetails() {
		Passport passport = entityManager.find(Passport.class, 30001L);
		logger.info("Passport -> {}",passport);
		logger.info("Student -> {}",passport.getStudent());

	}
	
	@Test
	@Transactional
	void retrieveStudentAndCourses() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("student -> {}",student);
		logger.info("course -> {}", student.getCourses());

	}


}
