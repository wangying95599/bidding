package org.quetzaco.experts.app.biz.Impl;

import java.util.List;

import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.UdprojectsExample;
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
		return project;
	}

	@Override
	public void deleteProejct(Integer id) {

	}

	@Override
	public Udprojects updateProject(Udprojects project) {
		projectMapper.updateByPrimaryKey(project);
		return project;
	}

	@Override
	public Udprojects getProject(String purchaseProject) {
		return null;
	}

	@Override
	public List<Udprojects> getAllProjects() {
		return projectMapper.selectByExample(null);
	}

	@Override
	public Udprojects getProject(Integer id) {
		UdprojectsExample e = new UdprojectsExample();
		UdprojectsExample.Criteria c = e.createCriteria();
		c.andIdEqualTo(id);
		List<Udprojects> result = projectMapper.selectByExample(e);
		return result.get(0);
	}
	
	public static void main(String[] args) {
		ProjectServiceImpl s = new ProjectServiceImpl();
		s.getProject(76);
	}

}
