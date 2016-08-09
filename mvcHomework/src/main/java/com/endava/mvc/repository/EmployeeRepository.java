package com.endava.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.endava.mvc.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Employee findByCnp(String cnp);

	Employee findByFirstNameAndLastName(String firstame, String lastName);

}
