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
public class VoiceServiceTest extends ExpertsApplicationTests {
	@Autowired
	VoiceService voiceService;
	

	@Rollback(false)
	@Test
	public void startVoice() {
		voiceService.startVoice(123);
		
	}
	
}