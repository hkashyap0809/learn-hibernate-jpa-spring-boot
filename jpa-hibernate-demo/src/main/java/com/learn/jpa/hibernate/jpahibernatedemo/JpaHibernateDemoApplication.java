package com.learn.jpa.hibernate.jpahibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Review;
import com.learn.jpa.hibernate.jpahibernatedemo.repository.CourseRepository;
import com.learn.jpa.hibernate.jpahibernatedemo.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Review review1 = new Review("good course", "5");
		Review review2 = new Review("okayish gt course", "2");
		
		List<Review> reviews = new ArrayList<>();
		reviews.add(review1);
		reviews.add(review2);

		courseRepository.addReviewsForCourse(10003L,reviews);
		
	}

}
