package org.quetzaco.experts.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControler {

  final static Logger logger = LoggerFactory.getLogger(PageControler.class);


  @RequestMapping("/")
  public String home() {
    return "login.html";
  }

  //loginAdmin.html
  @RequestMapping("/main")
  public String main() {
    logger.debug(" goto project_parent.html");
    return "project.html";
  }
  
  @RequestMapping("/set")
  public String login2() {
    return "login2.html";
  }

  @RequestMapping("/admin")
  public String admin() {
    return "project2.html";
  }
 
  
}
