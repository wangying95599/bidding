package org.quetzaco.experts.web.restful;

import java.util.Date;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.model.api.APIEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtractSetController extends BaseRestContoller {

	@Autowired
	ExtractSetService service;

	@RequestMapping(value = "/extractset", method = RequestMethod.POST)
	public HttpEntity<APIEntity> createUser(@Param("loginName") String loginName, @Param("name") String name,
			@Param("deptId") Long deptId) {

//		if (userService.selectUserByLoginName(loginName) != null) {
//			return buildEntity(APIEntity.create("用户名已被使用"), HttpStatus.BAD_REQUEST);
//		}
//
//		User user = new User();
//		user.setLoginName(loginName);
//		user.setPassword(passwordEncoder.encode("123456"));
//		user.setName(name);
//		user.setCreatedDt(new Date());
//		user.setUpdatedDt(user.getCreatedDt());
//
//		userService.createUser(user, deptId);

		return buildEntity(APIEntity.create(null), HttpStatus.CREATED);
	}
}
