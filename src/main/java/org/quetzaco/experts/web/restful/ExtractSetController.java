package org.quetzaco.experts.web.restful;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class ExtractSetController extends BaseRestContoller {

	@Autowired
	ExtractSetService service;

    //
	@RequestMapping(value = "/extractset", method = RequestMethod.POST)
    public HttpEntity<APIEntity> createExtractSet(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@RequestBody Udset set){
		
		System.out.println("                 Udset "+set);
		
        return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
    }
}
