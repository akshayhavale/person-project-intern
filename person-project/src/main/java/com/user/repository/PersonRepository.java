package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.model.Person;
import com.user.model.PersonSalaryDetail;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

//	@Query("select p.name from Person p where name like '%s%'")
	@Query("select p.name from Person p")
	List<String> findName();

	List<Person> getByName(String name);

	@Query("select p from Person p where name like %?1%")
	List<Person> findPersonSalaryDetailsByName(String name);

	@Query("select new com.user.model.PersonSalaryDetail(p.name, p.salary) from Person p where name like %?1%")
	List<PersonSalaryDetail> getPersonSalaryDetailByName(String name);

	@Query("select p from Person p where p.employeeDetails.companyName like %?1%")
	List<Person> getByCompanyName(String name);

	@Query("select new com.user.model.PersonSalaryDetail(p.name, p.salary) from Person p")
	List<PersonSalaryDetail> getAllSalaryAndName();

}
