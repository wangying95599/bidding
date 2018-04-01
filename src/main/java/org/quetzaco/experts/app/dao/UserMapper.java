package org.quetzaco.experts.app.dao;

import java.util.List;
import java.util.Map;

import org.quetzaco.experts.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByLoginName(String loginName);

    List<User> getUserList();

    User selectUserByLoginName(String loginName);

    Map isAdmin(long usrId);

    Map loadingUser(Long usrId);
}