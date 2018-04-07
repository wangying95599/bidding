package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.ExtractService;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetresult;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class ExtractController extends BaseRestContoller {

    @Autowired
    ExtractService service;

	
	@RequestMapping(value = "/extract/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> extractStart(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 Udset "+projectId);
		Udset set = new Udset();
		set.setProjectId(projectId);
		List<Udsetresult> list = service.extract(set);
		
        return buildEntity(APIEntity.create(list), HttpStatus.OK);
    }
	
    @RequestMapping(value = "/extract/create", method = RequestMethod.POST)
    public HttpEntity<APIEntity> createExtractSet(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody List<Udsetresult> result) { //有关不能传递复杂类型的问题： @RequestBody 也是必需的
        service.insertExtract(result);
    	System.out.println("111");
        return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
    }
    
	@RequestMapping(value = "/extract/get/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> getExtract(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 Udset "+projectId);
		Udset set = new Udset();
		set.setProjectId(projectId);
		List<Udsetresult> list = service.getExtractResult(set);
		
        return buildEntity(APIEntity.create(list), HttpStatus.OK);
    }
}
