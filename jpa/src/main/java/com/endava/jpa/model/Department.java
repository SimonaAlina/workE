package com.endava.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private int id;

	private String name;

	@OneToMany(mappedBy = "dept")
	private List<Employee> employees;

	public void addEmployee(Employee emp) {
		employees.add(emp);
		if (emp.getDept() != this)
			emp.setDept(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
