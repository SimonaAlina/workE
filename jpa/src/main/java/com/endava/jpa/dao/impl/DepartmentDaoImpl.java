package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	private String QUERY_FIND_DEPARTMENT_BY_NAME = "Select d from Department d where d.name = :dep_name";

	public Department find(int id) {
		return entityManager.find(Department.class, id);
	}

	public List<Department> find(String departmentName) {
		return entityManager.createQuery(QUERY_FIND_DEPARTMENT_BY_NAME, Department.class)
				.setParameter("dep_name", departmentName)
				.getResultList();
	}

	public void save(Department toBeSaved) {
		entityManager.persist(toBeSaved);
		entityManager.flush();
	}

	public void update(Department toBeUpdated) {
		entityManager.merge(toBeUpdated);
	}

	public void remove(Department toBeRemoved) {
		entityManager.remove(entityManager.merge(toBeRemoved));
	}
}
