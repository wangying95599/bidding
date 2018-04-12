package org.quetzaco.experts.app.biz.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quetzaco.experts.app.biz.SmsService;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.app.dao.UdsetresultMapper;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.UdsetresultExample;
import org.quetzaco.experts.util.json.JsonUtil;
import org.quetzaco.experts.util.notify.sms.SmsNotify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

	final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

	@Autowired
	UdsetresultMapper resultMapper;
	@Autowired
	UdprojectsMapper projectMapper;
	
	@Override
	public void startSms(Integer projectId) {
		UdsetresultExample example = new UdsetresultExample();
		example.createCriteria().andProjectIdEqualTo(projectId);
		List<Udsetresult> list = resultMapper.selectDetailInfo(projectId);
		
		Udprojects project = projectMapper.selectByPrimaryKey(projectId);
    	
		for(Udsetresult result:list) {
			Map<String,String> map = new HashMap<String,String>();
	    	map.put("name", result.getName());
	    	map.put("projectLocation", project.getBiddingLocation());
	    	map.put("projectDate", project.getBiddingTime()+"");
	    	map.put("projectName", project.getPurchaseProject());
	    	String json=JsonUtil.getJson(map);
	    	 
			try {
				SmsNotify.sendSms(result.getPhone(), json, projectId+"-"+result.getExpertId());
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void getSms(Integer projectId) {
		
	}
	
	
}
