package com.endava.jpa.service;

import java.util.List;

import com.endava.jpa.model.Project;

public interface ProjectService {

	public Project find(int id);

	public List<Project> find(String projectName);

	public void save(Project toBeSaved);

	public void update(Project toBeUpdated);

	public void remove(Project toBeRemoved);
}
