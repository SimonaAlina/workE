package com.endava.jpa.service.impl;

import java.util.List;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee find(int id) {
		return employeeDao.find(id);
	}

	public List<Employee> find(String employeeName) {
		return employeeDao.find(employeeName);
	}

	public List<Employee> findByIdAndCity(int id, String city) {
		return employeeDao.findByIdAndCity(id, city);
	}
	
	@Transactional
	public void save(Employee toBeSaved) {
//		SessionFactory sF = new Configuration().configure().buildSessionFactory();
//		Session session = sF.getCurrentSession();
//		session.beginTransaction();
		employeeDao.save(toBeSaved);
//		session.close();
	}

	@Transactional
	public void update(Employee toBeUpdated) {
		employeeDao.update(toBeUpdated);
	}

	@Transactional
	public void remove(Employee toBeRemoved) {
		employeeDao.remove(toBeRemoved);
	}
}
