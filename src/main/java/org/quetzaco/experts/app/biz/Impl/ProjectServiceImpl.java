package org.quetzaco.experts.app.biz.Impl;

import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.model.Udprojects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	final static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
	@Autowired
	UdprojectsMapper projectMapper;

	@Override
	public Udprojects createProject(Udprojects project) {
		projectMapper.insertSelective(project);
		//TODO  not sure if useful to return the project for now
		return project;
	}

	@Override
	public void deleteProejct(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Udprojects updateProject(Udprojects project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Udprojects getProject(String purchaseProject) {
		// TODO Auto-generated method stub
		return null;
	}

}
