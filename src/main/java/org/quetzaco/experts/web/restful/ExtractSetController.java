package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetcompany;
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
public class ExtractSetController extends BaseRestContoller {

	@Autowired
	ExtractSetService service;

    //
	@RequestMapping(value = "/extractset/create", method = RequestMethod.POST)
    public HttpEntity<APIEntity> createExtractSet(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user, Udset set,
    		@RequestParam(value = "expertList[]",required = false) Integer[] expertList,
    		@RequestParam(value = "majorList[]",required = false) Integer[] majorList){
		
		System.out.println("                 Udset "+set);
		System.out.println("                 Udset "+expertList);
		System.out.println("                 Udset "+majorList);
		service.extractSet(set);
		
        return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
    }
}
