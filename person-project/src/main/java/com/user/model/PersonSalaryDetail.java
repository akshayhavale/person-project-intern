package com.user.model;

public class PersonSalaryDetail {

	private String name;

	private Double salary;

	public PersonSalaryDetail() {
		// TODO Auto-generated constructor stub
	}

	public PersonSalaryDetail(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
