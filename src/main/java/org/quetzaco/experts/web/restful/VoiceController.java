package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.VoiceService;
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
public class VoiceController extends BaseRestContoller {

    @Autowired
    VoiceService service;
	
	@RequestMapping(value = "/voice/start/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> startVoice(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 startVoice "+projectId);
		Udset set = new Udset();
		set.setProjectId(projectId);
		service.startVoice(projectId);
		
        return buildEntity(APIEntity.create(null), HttpStatus.OK);
    }
	
    @RequestMapping(value = "/voice/pause/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> pauseVoice(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
    		@PathVariable Integer projectId) { 
        service.pauseVoice(projectId);
    	System.out.println("111");
        return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
    }
    
	@RequestMapping(value = "/voice/get/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> getVoice(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 Udset "+projectId);
		List<Udsetresult> list=null;
//		list = service.getVoice(projectId);
		
        return buildEntity(APIEntity.create(list), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/voice/confirm/{projectId}/{expertId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> confirm(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId,@PathVariable Integer expertId){
		
		System.out.println(projectId+"                 confirm "+expertId);
		
		Udsetresult result = new Udsetresult ();
		result.setProjectId(projectId);
		result.setExpertId(expertId);
		service.confirm(result, true);
		
        return buildEntity(APIEntity.create(null), HttpStatus.OK);
    }
}
