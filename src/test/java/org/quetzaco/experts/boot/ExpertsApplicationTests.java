package org.quetzaco.experts.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quetzaco.experts.ExpertsApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
/**
*默认在测试方法上添加<code>@Rollback</code> 用于测试数据的回滚
*/
@Rollback
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(classes = {ExpertsApplication.class})
@ComponentScan(basePackages = "org.quetzaco.experts")
@ActiveProfiles("dev")
public class ExpertsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
