package org.quetzaco.archives.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.quetzaco.archives.application.biz.RoleService;
import org.quetzaco.archives.application.dao.FlowFormLendingMapper;
import org.quetzaco.archives.application.dao.FlowsMapper;
import org.quetzaco.archives.model.*;
import org.quetzaco.archives.web.config.session.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PageControler {

  final static Logger logger = LoggerFactory.getLogger(PageControler.class);
  @Autowired
  RoleService roleService;
  @Autowired
  FlowFormLendingMapper flowFormLendingMapper;
  @Autowired
  FlowsMapper flowsMapper;

  @RequestMapping("/")
  public String home() {
    return "0login.html";
  }
  @RequestMapping("/index")
  public String index() {
    return "login.html";
  }

  //loginAdmin.html
  @RequestMapping("/main")
  public String main() {
    logger.debug(" goto main 9_index.html");
    return "9_index.html";
  }

  @RequestMapping("/admin")
  public String admin() {
    return "adminmain.html";
  }
  
  @RequestMapping("/searchgoogle")
  public String searchuse() {
	  System.out.println("searchgoogle ");
    return "search_google.html";
//	  return "searchsite.html";
  }
  
  @RequestMapping("/search")
  public String search(HttpServletRequest request) {
	  System.out.println("searchcontent     "+request.getParameter("searchText"));
	  System.out.println("type      "+request.getParameter("type"));
    return "search_content.html?searchText="+request.getParameter("searchText")+"&type=1";
//	  return "searchsite.html";
  }

//  @RequestMapping("/search")
//  public String search() {
//    return "searchsite.html";
//  }

  @RequestMapping("/history")
  public String history() {
    return "historydata.html";
  }

  @RequestMapping("/view")
  public String view() {
    return "quetviewer.html";
  }

  @RequestMapping("/flowLending/endSwitch")
  public String end(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user,@RequestParam("flowId")Long flowId,@RequestParam("action")String action){
    if(!"ACCEPT".equals(action)){
      return "forward:/flowLending/end/"+action;
    }
    FlowFormLending flowFormLending = flowFormLendingMapper.selectByPrimaryKey(flowId);
    if(user.getId().equals(flowFormLending.getManagerId())){
      return "forward:/flowLending/end/"+action;
    }else{
      return "forward:/flowLending/process";
    }
  }

  @RequestMapping("/flowDestroy/endSwitch")
  public String endDes(@RequestParam("action") String action,@RequestParam("flowId")Long flowId, @RequestParam("usrId") Long usrId) {
    //判断是否为管理员
    /*Role role = roleService.getRoleByDepAndUser(deptId, usrId);
    if (role != null) {
      if (role.getId() == 1L || role.getId() == 3L)
        return "forward:/flowDestroy/end/" + action;
    }
    return "forward:/flowDestroy/process";*/
    if(!"ACCEPT".equals(action))
      return "forward:/flowDestroy/end/" + action;
    Flows flows = flowsMapper.selectByPrimaryKey(flowId);
    if(usrId.equals(flows.getCreatedBy()))
      return "forward:/flowDestroy/end/" + action;
    return "forward:/flowDestroy/process";
  }

  @RequestMapping("/flowFormDeliver/endSwitch")
  public String endTurnOver(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user, @RequestParam("action") String action,@RequestParam("deptId") Long deptId) {
    //如果action是否决的话直接结束流程
    if(!"ACCEPT".equals(action))
      return "forward:/flowFormDeliver/end/" + action;
    //判断是否为管理员
    Role role = roleService.getRoleByDepAndUser(deptId, user.getId());
    if (role != null) {
      if (role.getId() == 1L || role.getId() == 3L)
        return "forward:/flowFormDeliver/end/" + action;
    }
    return "forward:/flowFormDelivers/process";
  }

  @RequestMapping("/flowFormAssist/endSwitch")
  public String endAssist(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user, @RequestParam("action") String action,@RequestParam("deptId") Long deptId) {
    //如果action是否决的话直接结束流程
    if(!"ACCEPT".equals(action))
      return "forward:/flowFormAssist/end/" + action;
    //判断是否为管理员
    Role role = roleService.getRoleByDepAndUser(deptId, user.getId());
    if (role != null) {
      if (role.getId() == 1L || role.getId() == 3L)
        return "forward:/flowFormAssist/end/" + action;
    }
    return "forward:/flowFormAssist/process";
  }
}
