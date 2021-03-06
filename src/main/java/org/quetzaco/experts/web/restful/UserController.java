package org.quetzaco.experts.web.restful;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.quetzaco.experts.app.biz.UserService;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.quetzaco.experts.util.encoder.password.PasswordEncoder;
import org.quetzaco.experts.web.config.session.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
 * Created by deya on 2017/7/10.
 */
@RestController
public class UserController extends BaseRestContoller {

  @Autowired
  UserService userService;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  RedisTemplate redisTemplate;


  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public HttpEntity<APIEntity> createUser(@Param("loginName") String loginName,
      @Param("name") String name,
      @Param("deptId") Long deptId) {

    if (userService.selectUserByLoginName(loginName) != null) {
      return buildEntity(APIEntity.create("用户名已被使用"), HttpStatus.BAD_REQUEST);
    }

    User user = new User();
    user.setLoginName(loginName);
    user.setPassword(passwordEncoder.encode("123456"));
    user.setName(name);
    user.setCreatedDt(new Date());
    user.setUpdatedDt(user.getCreatedDt());

    userService.createUser(user, deptId);

    return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
  }

  @RequestMapping(value = "/users", method = RequestMethod.PUT)
  public HttpEntity<APIEntity> updateUser(@RequestParam("id") Long id,
	  @RequestParam("password") String password, @RequestParam("name") String name) {
	User user = new User();
	if (id != null) {
	  user.setId(id);
	}
	if (password != null && !"".equals(password)) {
	  user.setPassword(passwordEncoder.encode(password));
	}
	if (name != null && !"".equals(name)) {
	  user.setName(name);
	}
	user.setUpdatedDt(new Date());
	  userService.updateUser(user);

    return buildEntity(APIEntity.create(user), HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
  public HttpEntity<APIEntity<User>> deactiveUser(@PathVariable Long id) {
    userService.deactiveUser(id);
    return buildEntity(APIEntity.create(null), HttpStatus.NO_CONTENT);
  }


  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public HttpEntity<APIEntity<User>> getUserDetails(@PathVariable Long id) {

    return buildEntity(APIEntity.create(userService.getUserDetails(id)), HttpStatus.OK);
  }


  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public HttpEntity<APIEntity<List<User>>> getUserList() {
    return buildEntity(APIEntity.create(userService.getUserList()), HttpStatus.OK);
  }

  @RequestMapping(value = "users/login", method = RequestMethod.POST)
  public HttpEntity<APIEntity> login(User user, HttpSession httpSession) {
	  String loginName=user.getLoginName();
	  String password=user.getPassword();
    user = userService.login("admin".equals(loginName)?loginName:loginName.toUpperCase(), password);
    if (user == null) {
      return buildEntity(APIEntity.create("用户名或密码错误"), HttpStatus.BAD_REQUEST);
    }
    httpSession.setAttribute(WebSecurityConfig.SESSION_KEY, user);
    return buildEntity(APIEntity.create(user), HttpStatus.OK);
//	  return buildEntity(APIEntity.create(null), HttpStatus.OK);
  }

  @RequestMapping(value = "/login/admin", method = RequestMethod.POST)
  public HttpEntity<APIEntity> loginadmin(@RequestParam("loginName") String loginName,
      @RequestParam("password") String password, HttpSession httpSession) {
    //checkadmin role
    User user = userService.login("admin".equals(loginName)?loginName:loginName.toUpperCase(), password);
    if (user == null) {
      return buildEntity(APIEntity.create("用户名或密码错误"), HttpStatus.BAD_REQUEST);
    }

    if (!"admin".equals(loginName)) {
      return buildEntity(APIEntity.create("对不起，您没有管理员权限"), HttpStatus.BAD_REQUEST);
    }
    httpSession.setAttribute(WebSecurityConfig.SESSION_KEY, user);
    return buildEntity(APIEntity.create(user), HttpStatus.OK);
  }
   @RequestMapping(value = "/users/detail", method = RequestMethod.GET)
	public HttpEntity getCurrentUser(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user) {
		return buildEntity(APIEntity.create(user), HttpStatus.OK);
	}

  //关闭用户
  @RequestMapping("/users/close/{usrId}")
  public HttpEntity<APIEntity> closeUser(@PathVariable Long usrId) {
    userService.closeUser(usrId);
    return buildEntity(APIEntity.create(""), HttpStatus.ACCEPTED);
  }

  //激活用户
  @RequestMapping("/users/activate/{usrId}")
  public HttpEntity<APIEntity> activateUser(@PathVariable Long usrId) {
    userService.activateUser(usrId);
    return buildEntity(APIEntity.create(""), HttpStatus.ACCEPTED);
  }


  /*@RequestMapping(value="/login", method=RequestMethod.GET)
  public ModelAndView showLoginPage(){
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }*/

    @RequestMapping("logOut/users")
    public HttpEntity<APIEntity> logOut(HttpSession httpSession,@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user) {
        // HttpSession httpSession = request.getSession();
        redisTemplate.delete("user_"+user.getId());
        httpSession.invalidate();
        return buildEntity(APIEntity.create("退出登录"), HttpStatus.OK);
    }


    @RequestMapping("/users/loading/{usrId}")
    public HttpEntity<APIEntity> loadingUser(@PathVariable Long usrId) {
        return buildEntity(APIEntity.create(userService.loadingUser(usrId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/updatePwd", method = RequestMethod.POST)
    public HttpEntity<APIEntity> updatePassword(Long usrId, String oldPwd, String newPwd,HttpSession httpSession) {
        boolean isUpdate = userService.updatePassword(usrId, oldPwd, newPwd);
        if(isUpdate){
          User user = userService.getUserDetails(usrId);
          httpSession.setAttribute(WebSecurityConfig.SESSION_KEY, user);
        }
        return buildEntity(APIEntity.create(isUpdate),HttpStatus.OK);
    }

    //待办
    @RequestMapping("/users/remain")
    public HttpEntity<APIEntity> remainToBeDone(@SessionAttribute(WebSecurityConfig.SESSION_KEY)User user){
      return buildEntity(APIEntity.create(userService.remainToBeDone(user)),HttpStatus.OK);
    }


}
