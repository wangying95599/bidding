package org.quetzaco.experts.app.biz.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quetzaco.experts.app.biz.UserService;
import org.quetzaco.experts.app.dao.UserMapper;
import org.quetzaco.experts.model.User;
import org.quetzaco.experts.util.encoder.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by deya on 2017/7/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
  @Autowired
  UserMapper userMapper;

  @Autowired
  RedisTemplate redisTemplate;
  
  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void createUser(User user, Long deptId) {
    userMapper.insertSelective(user);
    String loginName = user.getLoginName();
    

  }

  @Override
  public User getUserDetails(Long id) {
    return userMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<User> getUserList() {
    return userMapper.getUserList();
  }

  @Override
  public void deactiveUser(Long id) {
    User user = new User();
    user.setState("1");
    user.setId(id);
    user.setUpdatedDt(new Date());
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public void updateUser(User user) {
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public User login(String loginName, String password) {
    User user = userMapper.getUserByLoginName(loginName);
    if (user == null) {
      return null;
    }


      String correctPwd = user.getPassword();
      if (passwordEncoder.isPasswordValid(correctPwd, password)) {
        return user;
      } else {
        return null;
      }
    


  }

  @Override
  public User selectUserByLoginName(String loginName) {
    return userMapper.selectUserByLoginName(loginName);
  }

  @Override
  public boolean isAdmin(long usrId) {
    if (userMapper.isAdmin(usrId) != null) {
      return true;
    } else {
      return false;
    }
  }

  //此方法和上面的deactive方法 重复
  @Override
  public void closeUser(Long usrId) {
    User user = new User();
    user.setId(usrId);
    user.setState("1");
    user.setUpdatedDt(new Date());
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public void activateUser(Long usrId) {
    User user = new User();
    user.setId(usrId);
    user.setState("0");
    user.setUpdatedDt(new Date());
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public Map loadingUser(Long usrId) {
    String userKey = "user_"+usrId;
    Map map = (Map) redisTemplate.opsForValue().get(userKey);
    if(map==null){
      map = userMapper.loadingUser(usrId);
      redisTemplate.opsForValue().set(userKey,map);
    }

    return map;
  }

  @Override
  public boolean updatePassword(Long usrId, String oldPwd, String newPwd) {
    User user = userMapper.selectByPrimaryKey(usrId);
    if (!passwordEncoder.isPasswordValid(user.getPassword(), oldPwd)) {
      return false;
    }
    User newUser = new User();
    newUser.setId(usrId);
    newUser.setPassword(passwordEncoder.encode(newPwd));
    userMapper.updateByPrimaryKeySelective(newUser);
    return true;
  }

  @Override
  public Map remainToBeDone(User user) {
    
    // list1.addAll(list2);
    Map map = new HashMap();
    return map;
  }
}
