package org.quetzaco.experts.app.biz;

import java.util.Date;

import org.junit.Test;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class ExtractSetServiceTest extends ExpertsApplicationTests{
	@Autowired
	ExtractSetService service;
	
	@Test
	@Rollback(false)
	public void set() {
		Udset set = new Udset();
		set.setProjectId(123);
		set.setRecordFlag("01");
		set.setCreatedTime(new Date());
		set.setUpdatedTime(new Date());
		
		service.extractSet(set);
	}
}
