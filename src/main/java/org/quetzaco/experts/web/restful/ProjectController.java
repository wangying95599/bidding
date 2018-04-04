package org.quetzaco.experts.web.restful;

import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class ProjectController extends BaseRestContoller {
    ProjectService projectService;

    @RequestMapping(value = "projects/create", method = RequestMethod.POST)
    public HttpEntity<APIEntity> create(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody Udprojects project) {
        projectService.createProject(project);
        return buildEntity(APIEntity.create(null), HttpStatus.OK);
    }
}
