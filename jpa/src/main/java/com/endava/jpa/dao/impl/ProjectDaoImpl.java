package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.ProjectDao;
import com.endava.jpa.model.Project;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private String QUERY_FIND_PROJECT_BY_NAME = "Select p from Project p where p.name = :name";

	public Project find(int id) {
		return entityManager.find(Project.class, id);
	}

	public List<Project> find(String projectName) {
		return entityManager.createQuery(QUERY_FIND_PROJECT_BY_NAME, Project.class)
				.setParameter("name", projectName)
				.getResultList();
	}

	public void save(Project toBeSaved) {
		entityManager.persist(toBeSaved);
	}

	public void update(Project toBeUpdated) {
		entityManager.merge(toBeUpdated);
	}

	public void remove(Project toBeRemoved) {
		entityManager.remove(toBeRemoved);
	}
}
