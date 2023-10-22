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
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Student;
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
		
//		studentRepository.insertHardCodedStudentAndCourse();
		
		
		Student student = new Student("Jack");
		Course course = new Course("LEARN MICROSERVICES");
		studentRepository.insertStudentAndCourse(student, course);
		
		
	}

}
