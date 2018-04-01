package org.quetzaco.experts.web.restful;

import javax.servlet.http.HttpSession;

import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.api.APIEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProjectController extends BaseRestContoller {
	ProjectService projectService;

	@RequestMapping(value = "projects/create", method = RequestMethod.POST)
	public HttpEntity<APIEntity> login(Udprojects project, HttpSession httpSession) {
		projectService.createProject(project);
		return buildEntity(APIEntity.create(null), HttpStatus.OK);
	}
}
