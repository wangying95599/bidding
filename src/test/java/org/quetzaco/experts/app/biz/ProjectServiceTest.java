package org.quetzaco.experts.app.biz;

import java.util.Date;

import org.junit.Test;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udprojects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description Created by dong on 2017/7/21.
 */
public class ProjectServiceTest extends ExpertsApplicationTests {
	@Autowired
	ProjectService projectService;

	@Test
	public void remainToBeDone() {
		Udprojects p = new Udprojects();
		p.setBiddingLocation("Beijing");
		p.setBiddingPeriod("2 hours");
		p.setBiddingTime(new Date());
		p.setExtractCompany("extract company");
		p.setProxyOrg("proxy orgnazation");
		p.setPurchaseCode("a20180401");
		p.setPurchaseCompany("purchase company");
		p.setPurchaseProject("project name");
		p.setPurchaseType("purchase type");
		projectService.createProject(p);
	}
}