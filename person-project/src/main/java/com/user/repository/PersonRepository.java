package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
