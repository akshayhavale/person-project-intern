package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.Person;
import com.user.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public @ResponseBody Person create(@RequestBody Person emp) {
		return employeeService.createEmployee(emp);
	}
	
	@PutMapping("/update/{id}")
	public @ResponseBody Person update(@RequestBody Person emp,@PathVariable(name = "id") long id) {
		return employeeService.updateEmployee(emp, id);
	}
	@GetMapping("/get/{id}")
	public @ResponseBody Person get(@PathVariable(name = "id") long id) {
		return employeeService.getEmployee(id);
	}
	@GetMapping("/get/all")
	public @ResponseBody List<Person> getAll() {
		return employeeService.getAllEmployee();
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") long id) {
		 employeeService.deletePerson( id);
	}

}
