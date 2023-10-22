package com.learn.jpa.hibernate.jpahibernatedemo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private BigDecimal hourlyWage;

	protected FullTimeEmployee() {
	}

	public FullTimeEmployee(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	
	

}
