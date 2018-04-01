package org.quetzaco.experts.web.restful;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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



 

}
