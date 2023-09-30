package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

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
	
	@Test
	@DirtiesContext
	void deleteByIdTest() {
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	void updateTest() {
		//get a course
		Course course = courseRepository.findById(10001L);
		assertEquals("Learn SPRING",course.getName() );
		
		//update details
		course.setName("LEARN SPRING BOOT");
		
		courseRepository.save(course);
		
		//check the value
		Course course1 = courseRepository.findById(10001L);
		
		assertEquals("LEARN SPRING BOOT", course1.getName());
	}

}
