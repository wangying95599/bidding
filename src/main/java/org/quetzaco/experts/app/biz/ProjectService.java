package org.quetzaco.experts.app.biz;

import java.util.List;

import org.quetzaco.experts.model.Udprojects;

public interface ProjectService {
	Udprojects createProject(Udprojects project);
	void deleteProejct(Integer id);
	Udprojects updateProject(Udprojects project);
	Udprojects getProject(String purchaseProject);
	List<Udprojects> getAllProjects();
}
