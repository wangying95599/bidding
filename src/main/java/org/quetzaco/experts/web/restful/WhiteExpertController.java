package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.WhiteExpertService;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetwhite;
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
public class WhiteExpertController extends BaseRestContoller {

    @Autowired
    WhiteExpertService service;
	
    @RequestMapping(value = "/white", method = RequestMethod.POST)
    public HttpEntity<APIEntity> createWhiteExpert(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody Udset set) { //有关不能传递复杂类型的问题： @RequestBody 也是必需的
        service.createWhiteExpert(set);
    	System.out.println("111");
        return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
    }
	
    
	@RequestMapping(value = "/white/get/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> getWhiteExpert(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 Udset "+projectId);
		List<Udexpert> list=null;
		list = service.getWhiteExpert(projectId);
		
        return buildEntity(APIEntity.create(list), HttpStatus.OK);
    }
}
