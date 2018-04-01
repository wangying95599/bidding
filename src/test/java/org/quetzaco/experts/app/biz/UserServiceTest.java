package org.quetzaco.experts.app.biz;

import org.junit.Test;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description Created by dong on 2017/7/21.
 */
public class UserServiceTest extends ExpertsApplicationTests {
    @Autowired
    UserService userService;

   
    @Test
    public void remainToBeDone() {
       User user = new User();
       user.setId(1L);
      userService.remainToBeDone(user);
    }
}