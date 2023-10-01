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
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Student;

import jakarta.persistence.EntityManager;


@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	void retrieveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("Student -> {}",student);
		logger.info("Passport -> {}",student.getPassport());


	}


}
