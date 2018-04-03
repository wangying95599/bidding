package org.quetzaco.experts.web.restful;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetcompany;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ExtractSetController extends BaseRestContoller {

    @Autowired
    ExtractSetService service;

    public static void main(String args[]) {
        Udset u = new Udset();
        u.setProjectId(1);
        List<Udsetcompany> cList = new ArrayList<Udsetcompany>();
        Udsetcompany c = new Udsetcompany();
        c.setProjectId(1);
        cList.add(c);
        u.setCompanyList(cList);

        ObjectMapper mapper = new ObjectMapper();

        try {
            String uJson = mapper.writeValueAsString(u);
            System.out.println(uJson);
            mapper.readValue(uJson, Udset.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/extractset/create", method = RequestMethod.POST)
    public HttpEntity<APIEntity> createExtractSet(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,
            @RequestBody Udset set) { //有关不能传递复杂类型的问题： @RequestBody 也是必需的
        service.extractSet(set);
        return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/extractset/get/{projectId}", method = RequestMethod.GET)
    public HttpEntity<APIEntity> searchExtractSet(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@PathVariable Integer projectId){
		
		System.out.println("                 Udset "+projectId);
		Udset set = new Udset();
		set.setProjectId(projectId);
		set = service.serachExtractSet(set);
		
        return buildEntity(APIEntity.create(set), HttpStatus.ACCEPTED);
    }
}
