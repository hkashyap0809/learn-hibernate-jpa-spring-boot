package com.learn.jpa.hibernate.jpahibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.learn.jpa.hibernate.jpahibernatedemo.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info(" Course 100001 -> {} ",course);
//		courseRepository.deleteById(10001L);
		
		courseRepository.save(new Course( 10010L, "Learn MICROSERVICES"));
		courseRepository.save(new Course( 10010L, "Learn MICROSERVICES WITH SPRING BOOT"));
		
	}

}