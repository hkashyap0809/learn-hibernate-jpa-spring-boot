package com.learn.jpa.hibernate.jpahibernatedemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;

	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	protected Employee() {

	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}



}
