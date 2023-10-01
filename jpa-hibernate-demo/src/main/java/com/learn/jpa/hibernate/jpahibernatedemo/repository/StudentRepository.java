package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Passport;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class StudentRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//find by ID
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}


	//insert or update
	public void save(Student student) {
		Student dbStudent = findById(student.getId());
		if( dbStudent == null ) {
			//insert
			entityManager.persist(student);
		}else {
			//update
			entityManager.merge(student);
		}
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("UKNF683N");
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(passport);
		entityManager.persist(student);
	}
}
