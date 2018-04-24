package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.SmsService;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
public class SmsController extends BaseRestContoller {

    @Autowired
    SmsService service;
	
	@RequestMapping(value = "/sms/start/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> startSms(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 SmsController.start "+projectId);
		Udset set = new Udset();
		set.setProjectId(projectId);
		service.startSms(projectId);
		
        return buildEntity(APIEntity.create(null), HttpStatus.OK);
    }
    
	@RequestMapping(value = "/sms/get/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> getSms(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 SmsController.getSms "+projectId);
		List<Udsetresult> list=null;
//		list = service.getSms(projectId);
		
        return buildEntity(APIEntity.create(list), HttpStatus.OK);
    }
	
	
}
