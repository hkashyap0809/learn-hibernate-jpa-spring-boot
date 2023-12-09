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
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class CriteriaQueryTest {

	@Autowired
	EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Test
	public void criteriaQuerySelectAll() {

		//SELECT c FROM Course C


		//1. Use criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		//List<Course> is the list of expected result



		//2. Define roots for tables which are involved in the query
		//The table involved in the criteria query is COURSE table
		//root defining means from which table we need the data
		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		//3. Define predicates etc using Criteria Builder
		//4. Add predicates etc to the Criteria Query
		// in this basic query we dont have where clause or oder by so we can skip step 3 and 4

		//5. Build the TypedQuery usin the entity manager and criteria query
		//SELECT c FROM COURSE c
		//using criteria query -> select from roots
		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));


		List<Course> resultList = query.getResultList();
		logger.info("SELECT C FROM COURSE C -> {}",resultList);
	}

	@Test
	public void criteriaQueryWhereName100Step() {

		//SELECT c FROM Course C where name like '%100 Steps'


		//1. Use criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		//List<Course> is the list of expected result



		//2. Define roots for tables which are involved in the query
		//The table involved in the criteria query is COURSE table
		//root defining means from which table we need the data
		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		//3. Define predicates etc using Criteria Builder
		Predicate like100Steps = criteriaBuilder.like(courseRoot.get("name"), "%100 Steps");
		//( column name or attribute, pattern )

		//4. Add predicates etc to the Criteria Query
		criteriaQuery.where(like100Steps);

		//5. Build the TypedQuery usin the entity manager and criteria query
		//SELECT c FROM COURSE c
		//using criteria query -> select from roots
		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));


		List<Course> resultList = query.getResultList();
		logger.info("SELECT C FROM COURSE C -> {}",resultList);
	}

	@Test
	public void allCoursesWithoutStudents() {
		//SELECT c FROM Course C where c.students is empty


		//1. Use criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		//List<Course> is the list of expected result



		//2. Define roots for tables which are involved in the query
		//The table involved in the criteria query is COURSE table
		//root defining means from which table we need the data
		Root<Course> courseRoot = criteriaQuery.from(Course.class);

		//3. Define predicates etc using Criteria Builder
		Predicate studentsIsEmpty = criteriaBuilder.isEmpty(courseRoot.get("students"));
		//( column name or attribute, pattern )

		//4. Add predicates etc to the Criteria Query
		criteriaQuery.where(studentsIsEmpty);

		//5. Build the TypedQuery usin the entity manager and criteria query
		//SELECT c FROM COURSE c
		//using criteria query -> select from roots
		TypedQuery<Course> query = entityManager.createQuery(criteriaQuery.select(courseRoot));


		List<Course> resultList = query.getResultList();
		logger.info("SELECT C FROM COURSE C empty -> {}",resultList);
	}





}
