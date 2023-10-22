package com.learn.jpa.hibernate.jpahibernatedemo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
	
	private BigDecimal salary;

	protected PartTimeEmployee() {
	}

	public PartTimeEmployee(String name,BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	
	
	

}
