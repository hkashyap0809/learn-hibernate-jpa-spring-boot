package com.learn.jpa.hibernate.jpahibernatedemo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmplyee extends Employee{
	
	private BigDecimal salary;

	protected PartTimeEmplyee() {
	}

	public PartTimeEmplyee(String name,BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	
	
	

}
