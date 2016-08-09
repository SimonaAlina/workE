package com.endava.service;

import java.util.List;

import com.endava.mvc.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO findOne(Long id);

	List<EmployeeDTO> findAll();

	EmployeeDTO save(EmployeeDTO employeeDTO);

	void delete(Long id);
	
	void update(EmployeeDTO employeeDTO);

}
