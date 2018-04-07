package org.quetzaco.experts.app.biz;

import org.junit.Test;
import org.quetzaco.experts.app.dao.UdexpertMajorMapper;
import org.quetzaco.experts.app.dao.UdmajorMapper;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.Udmajor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * @Description Created by dong on 2017/7/21.
 */
public class ExpertServiceTest extends ExpertsApplicationTests {
	@Autowired
	ExpertService expertService;
	@Autowired
	UdexpertMajorMapper emMapper;
	@Autowired
	UdmajorMapper majorMapper;

	@Rollback(false)
	@Test
	public void TestinitExpert() {
		
		for(int i=1;i<=30;i++) {
			Udexpert expert =new Udexpert();
			expert.setNo(i+"");
			expert.setName("王"+i);
			expert.setRegion("0");
			expert.setCompany("电厂1");
			
			expertService.createExpert(expert);
		}
		
	}
	
	@Rollback(false)
	@Test
	public void initExpertMajor() {
		int j=0;
		for(int i=1;i<=30;i++) {
			UdexpertMajor em =new UdexpertMajor();
			em.setId(i);
			j=i+3;
			Udmajor major = majorMapper.selectByPrimaryKey(j);
			Udexpert expert= expertService.getExpert(j);
			em.setExpertId(expert.getExpertId());
			em.setMajorCode(major.getMajorCode());
			emMapper.insertSelective(em);
		}
		
	}
}