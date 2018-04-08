package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 *
 */
@RestController
public class ExpertController extends BaseRestContoller {

    @Autowired
    ExpertService expertService;

    @RequestMapping(value = "/expert/search/{type}/{value}", method = RequestMethod.GET)
    HttpEntity<APIEntity<List<Udexpert>>> getExpertList(@PathVariable String type, @PathVariable String value) {

        Udexpert expert = new Udexpert();
        if ("name".equals(type)) {
            expert.setName(value);
        } else if ("phone".equals(type)) {
            expert.setPhone(value);
        } else if ("company".equals(type)) {
            expert.setCompany(value);
        }

        return buildEntity(APIEntity.create(expertService.selectByExample(expert)), HttpStatus.OK);
    }

    @RequestMapping(value = "expert/create", method = RequestMethod.POST)
    public HttpEntity<APIEntity> create(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody Udprojects project) {
        return buildEntity(APIEntity.create(null), HttpStatus.OK);
    }

    @RequestMapping(value = "expert/all", method = RequestMethod.GET)
    public HttpEntity<APIEntity> getAll(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user) {
        List<Udexpert> all = expertService.selectByExample(null);
        return buildEntity(APIEntity.create(all), HttpStatus.OK);
    }

    @RequestMapping(value = "expert/{id}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> getProjectById(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestParam Integer id) {
        Udexpert expert = expertService.getExpert(id);
        return buildEntity(APIEntity.create(expert), HttpStatus.OK);
    }

    @RequestMapping(value = "expert", method = RequestMethod.PUT)
    public HttpEntity<APIEntity> updateProject(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody Udexpert expert) {
        Udexpert updated = expertService.updateExpert(expert);
        return buildEntity(APIEntity.create(updated), HttpStatus.OK);
    }

    @RequestMapping(value = "expert/delete", method = RequestMethod.DELETE)
    public HttpEntity<APIEntity> deleteProjects(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            expertService.deleteExpert(id);
        }
        return buildEntity(APIEntity.create(null), HttpStatus.OK);
    }

}
