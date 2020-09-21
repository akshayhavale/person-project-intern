package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.model.Person;

@Service
public interface EmployeeService {
	public Person createEmployee(Person emp);
	
	public Person updateEmployee(Person emp, long id);
	
	public Person getEmployee(long empid);
	
	public void deletePerson(long empid);
	
	public List<Person>getAllEmployee();
}
