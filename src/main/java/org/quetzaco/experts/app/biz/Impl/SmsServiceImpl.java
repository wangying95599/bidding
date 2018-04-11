package org.quetzaco.experts.app.biz.Impl;

import org.quetzaco.experts.app.biz.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

	final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	
	
	@Override
	public void startSms(Integer projectId) {
		
	}
	

	@Override
	public void getSms(Integer projectId) {
		
	}
	
	
}
