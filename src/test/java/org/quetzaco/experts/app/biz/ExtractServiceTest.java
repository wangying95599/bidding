package org.quetzaco.experts.app.biz;

import org.junit.Test;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class ExtractServiceTest extends ExpertsApplicationTests{
	@Autowired
	ExtractService service;
	
	@Test
	@Rollback(false)
	public void set() {
		Udset set = new Udset();
		set.setProjectId(123);
		
		
		service.extract(set);
	}
}
