package com.learn.jpa.hibernate.jpahibernatedemo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Employee;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.FullTimeEmployee;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.PartTimeEmployee;
import com.learn.jpa.hibernate.jpahibernatedemo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class EmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//insert an employee
	public void insert( Employee employee) {
		entityManager.persist(employee);
	}
	
	//retrieve all employee
	public List<Employee> retrieveAllEmployee(){
		return entityManager
				.createQuery(" select e from Employee e", Employee.class)
				.getResultList();
	}
	
	
	public List<PartTimeEmployee> retrieveAllPartEmployee(){
		return entityManager
				.createQuery(" select e from PartTimeEmployee e", PartTimeEmployee.class)
				.getResultList();
	}
	public List<FullTimeEmployee> retrieveAllFullEmployee(){
		return entityManager
				.createQuery(" select e from FullTimeEmployee e", FullTimeEmployee.class)
				.getResultList();
	}
}

