package org.quetzaco.experts.app.biz;

import java.util.Date;

import org.junit.Test;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udprojects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * @Description Created by dong on 2017/7/21.
 */
public class ProjectServiceTest extends ExpertsApplicationTests {
	@Autowired
	ProjectService projectService;

	private Udprojects createProjectModel(){
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
		return p;
	}
	@Rollback(false)
	@Test
	public void testCreate() {
		Udprojects p = this.createProjectModel();
		projectService.createProject(p);
	}
	
	@Test
	public void testSelectById() {
		Udprojects p = projectService.getProject(76);
		System.out.println("success");
	}
	
	@Test
	public void testDeleteById() {
		Udprojects p = this.createProjectModel();
		Udprojects created = projectService.createProject(p);
		projectService.getProject(created.getId());
		System.out.println("success");
	}
}