package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private String QUERY_FIND_EMPLOYEE_BY_NAME = "Select e from Employee e where e.name = :name";

	public Employee find(int id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> find(String employeeName) {
		return entityManager.createQuery(QUERY_FIND_EMPLOYEE_BY_NAME, Employee.class)
				.setParameter("name", employeeName)
				.getResultList();
	}

	public void save(Employee toBeSaved) {
		entityManager.persist(toBeSaved);
	}

	public void update(Employee toBeUpdated) {
		entityManager.merge(toBeUpdated);
	}

	public void remove(Employee toBeRemoved) {
		entityManager.remove(toBeRemoved);
	}
}
