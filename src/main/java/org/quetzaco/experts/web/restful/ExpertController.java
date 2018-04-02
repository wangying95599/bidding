package org.quetzaco.experts.web.restful;

import java.util.List;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.api.APIEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	if("name".equals(type)) {
		expert.setName(value);
	}else if("phone".equals(type)) {
		expert.setPhone(value);
	}else if("company".equals(type)) {
		expert.setCompany(value);
	}
	
    return buildEntity(APIEntity.create(expertService.selectByExample(expert)), HttpStatus.OK);
  }

 

}
