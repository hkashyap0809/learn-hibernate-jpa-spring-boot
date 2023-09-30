package com.learn.database.databasedemo;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.learn.database.databasedemo.entity.Person;
import com.learn.database.databasedemo.jdbc.PersonJdbcDao;
import com.learn.database.databasedemo.jpa.PersonJpaRepository;


@SpringBootApplication
public class SpringJPADemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("All Persons -> {} ", personJdbcDao.findAll());
		logger.info("User ID 1003 -> {} ", personJpaRepository.findById(1003));
//		logger.info("Deleting ID 1002 -> {} ", personJdbcDao.deleteById(1002));
//		logger.info("All Persons -> {} ", personJdbcDao.findAll());
//		logger.info("All Persons -> {} ", personJdbcDao.findAll());
		logger.info("Insert 1 -> {}", personJpaRepository.insert(new Person("Rachita","Hyderabad",new Date(0))));
//		logger.info("All Persons -> {} ", personJdbcDao.findAll());
		logger.info("Update 1 -> {}", personJpaRepository.update(new Person(1,"Rachita Bangali","Hyderabad",new Date(0))));
//		logger.info("All Persons -> {} ", personJdbcDao.findAll());
	}

}
