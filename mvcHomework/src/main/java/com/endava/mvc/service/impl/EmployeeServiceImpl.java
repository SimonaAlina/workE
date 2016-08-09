package com.endava.mvc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.endava.mvc.dto.EmployeeDTO;
import com.endava.mvc.model.Employee;
import com.endava.mvc.repository.EmployeeRepository;
import com.endava.service.EmployeeService;;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public EmployeeDTO findOne(Long id) {
		Employee employee = employeeRepository.findOne(id);
		return mapper.map(employeeRepository.save(employee), EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> findAll() {
		List<EmployeeDTO> employeesDTO = Collections.emptyList();
		Iterable<Employee> employees = employeeRepository.findAll();
		if (employees != null) {
			employeesDTO = new ArrayList<EmployeeDTO>();
			for (Employee employee : employees) {
				employeesDTO.add(mapper.map(employee, EmployeeDTO.class));
			}
		}
		return employeesDTO;
	}

	@Override
	public EmployeeDTO save(EmployeeDTO employeeDTO) {
		Employee employee = new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getCnp());
		employee.setDepartmentId(employeeDTO.getDepartmentId());
		return mapper.map(employeeRepository.save(employee), EmployeeDTO.class);
	}

	@Override
	public void delete(Long id) {
		Employee employee = employeeRepository.findOne(id);
		employeeRepository.delete(employee);
	}

	@Override
	public void update(EmployeeDTO employeeDTO) {
		Employee employeeDB = employeeRepository.findOne(employeeDTO.getId());
		Employee employee = new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getCnp());
		employee.setDepartmentId(employeeDTO.getDepartmentId());
		employee.setId(employeeDB.getId());
		employeeRepository.save(employee);
	}

}
