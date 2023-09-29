package com.learn.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//SELECT * FROM PERSON
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper(Person.class));
	}
	
}
