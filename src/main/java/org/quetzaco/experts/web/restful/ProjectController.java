package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class ProjectController extends BaseRestContoller {
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "projects/create", method = RequestMethod.POST)
	public HttpEntity<APIEntity> create(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
			@RequestBody Udprojects project) {
		projectService.createProject(project);
		return buildEntity(APIEntity.create(null), HttpStatus.OK);
	}

	@RequestMapping(value = "projects/all", method = RequestMethod.GET)
	public HttpEntity<APIEntity> getAll(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user) {
		List<Udprojects> all = projectService.getAllProjects();
		return buildEntity(APIEntity.create(all), HttpStatus.OK);
	}
	
	@RequestMapping(value = "projects/{id}", method = RequestMethod.GET)
	public HttpEntity<APIEntity> getProjectById(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user, @RequestParam Integer id) {
		Udprojects project = projectService.getProject(id);
		return buildEntity(APIEntity.create(project), HttpStatus.OK);
	}
	@RequestMapping(value = "projects", method = RequestMethod.PUT)
	public HttpEntity<APIEntity> updateProject(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user, @RequestBody Udprojects project) {
		Udprojects updatedProject = projectService.updateProject(project);
		return buildEntity(APIEntity.create(updatedProject), HttpStatus.OK);
	}
}
