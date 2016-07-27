package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/

	public void findDepartment() {
		Department department = departmentService.find(1);
		System.out.println(department);
	}

	public void findDepartmentByName() {
		List<Department> departments = departmentService.find("Prj");
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	 public void insertDepartment() {
		 Department department = new Department();
		 department.setName("hr");
		 departmentService.save(department);
	 }

	 /**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment() {
		Department department = departmentService.find(1);
		department.setName("ProjectK");
		departmentService.update(department);
	}

	/**
	 * Delete an existing department from the database
	 */
	public void deleteDepartment() {
		Department department = departmentService.find(2);
		departmentService.remove(department);
	}

	//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee() {
		Employee e = new Employee();
		e.setName("Simona");
		e.setSalary(2000.00);
		employeeService.save(e);
	}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){
		List<Employee> employees = employeeService.findByIdAndCity(1, "Bucharest");
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

}
