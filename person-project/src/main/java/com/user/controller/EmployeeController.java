package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.Person;
import com.user.model.PersonSalaryDetail;
import com.user.model.ReadableNameList;
import com.user.repository.PersonRepository;
import com.user.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PersonRepository personRepo;

	@PostMapping("/create")
	public @ResponseBody Person create(@RequestBody Person emp) {
		return employeeService.createEmployee(emp);
	}

	@PutMapping("/update/{id}")
	public @ResponseBody Person update(@RequestBody Person emp, @PathVariable(name = "id") long id) {
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
		employeeService.deletePerson(id);
	}

	// Specific Queries Of DataBase
	@GetMapping("/get/all/names")
	public ReadableNameList getAllNames() {
		ReadableNameList re = new ReadableNameList();
		List<String> names = personRepo.findName();
		re.setNames(names);
		return re;
	}

	@GetMapping("/get/name/{name}")
	public List<Person> getByName(@PathVariable(value = "name") String name) {
		return personRepo.getByName(name);
	}

	// This is mapping is not work because we wont get Map From Repository
//	@GetMapping("/get/salary/detail")
//	public List<PersonSalaryDetail> getSalaryAndName() {
//		List<PersonSalaryDetail> details = new ArrayList<PersonSalaryDetail>();
//		Map<String, Double> map = personRepo.findDetails();
//
//		for (Map.Entry<String, Double> entry : map.entrySet()) {
//			PersonSalaryDetail detail = new PersonSalaryDetail();
//			detail.setName(entry.getKey());
//			detail.setSalary(entry.getValue());
//			details.add(detail);
//		}
//		return details;
//	}

	// Here i Used Java * features
	@GetMapping("/get/salary/{name}")
	public List<PersonSalaryDetail> getSalaryByName(@PathVariable(value = "name") String name) {
		List<Person> people = personRepo.findPersonSalaryDetailsByName(name);
		List<PersonSalaryDetail> details = new ArrayList<PersonSalaryDetail>();
		people.stream().parallel().forEach(action -> {
			PersonSalaryDetail detail = new PersonSalaryDetail();
			detail.setName(action.getName());
			detail.setSalary(action.getSalary());
			details.add(detail);
		});
		return details;
	}

	// this is by query
	@GetMapping("/get/salarybyquery/{name}")
	public List<PersonSalaryDetail> getSalaryByName1(@PathVariable(value = "name") String name) {
		return personRepo.getPersonSalaryDetailByName(name);
	}

	@GetMapping("/get/salaryandname")
	public List<PersonSalaryDetail> getAllSalaryAndName() {
		return personRepo.getAllSalaryAndName();
	}

	// this is by companyName

	@GetMapping("/get/companyname/{name}")
	public List<Person> getByCompanyName(@PathVariable(value = "name") String name) {
		return personRepo.getByCompanyName(name);
	}

}
