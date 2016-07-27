package com.endava.jpa.service;

import java.util.List;

import com.endava.jpa.model.Employee;

public interface EmployeeService {

	public Employee find(int id);

	public List<Employee> find(String employeeName);

	public void save(Employee toBeSaved);

	public void update(Employee toBeUpdated);

	public void remove(Employee toBeRemoved);
}
