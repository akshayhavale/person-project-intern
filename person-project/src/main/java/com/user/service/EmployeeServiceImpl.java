package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.EmployeeDetails;
import com.user.model.Person;
import com.user.repository.EmployeeDetailsRepository;
import com.user.repository.PersonRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private EmployeeDetailsRepository employeeRepo;

	// name
	// employeeDetails Class
	// companyName
	// position
	@Override
	public Person createEmployee(Person emp) {
		// I am creating EMP DETAILS class first because the Person Class is using The
		// Emp Detail class as a field so to save Person i need to insert data from
		// input to new EMP details and use emp repo to save and that saved emp Details
		// will be added Person and that is saved
		EmployeeDetails persistDetails = new EmployeeDetails();

		persistDetails.setCompanyName(emp.getEmployeeDetails().getCompanyName());
		persistDetails.setPosition(emp.getEmployeeDetails().getPosition());

		EmployeeDetails savedEmployeeDetails = employeeRepo.save(persistDetails);
		
		Person persistPerson = new Person();
		
		persistPerson.setName(emp.getName());
		persistPerson.setEmployeeDetails(savedEmployeeDetails);
		
		return personRepo.save(persistPerson);

	}

	@Override
	public Person updateEmployee(Person emp, long id) {
		
		EmployeeDetails savedEmployeeDetail = employeeRepo.save(emp.getEmployeeDetails());
	
		Person savedPerson = personRepo.findById(id).get();
		savedPerson.setName(emp.getName());
		savedPerson.setEmployeeDetails(savedEmployeeDetail);
		
		return personRepo.save(savedPerson);
		
		
	}

	@Override
	public Person getEmployee(long empid) {
		return personRepo.findById(empid).get();
	}

	@Override
	public void deletePerson(long empid) {
		try {
			personRepo.deleteById(empid);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Person> getAllEmployee() {
		
		return personRepo.findAll();
	}

}
