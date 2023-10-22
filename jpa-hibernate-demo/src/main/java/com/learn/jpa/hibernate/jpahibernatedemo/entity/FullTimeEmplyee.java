package com.learn.jpa.hibernate.jpahibernatedemo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmplyee extends Employee{
	
	private BigDecimal hourlyWage;

	protected FullTimeEmplyee() {
	}

	public FullTimeEmplyee(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	
	

}
