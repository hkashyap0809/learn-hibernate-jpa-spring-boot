package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;


@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	void findByIdTest() {
		Course course = courseRepository.findById(10001L);
		assertEquals("Learn SPRING",course.getName());	
	}

}
