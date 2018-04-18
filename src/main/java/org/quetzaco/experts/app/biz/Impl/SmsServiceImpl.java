package org.quetzaco.experts.app.biz.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quetzaco.experts.app.biz.SmsService;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.app.dao.UdsetresultMapper;
import org.quetzaco.experts.enums.ProjectStatus;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.UdsetresultExample;
import org.quetzaco.experts.model.Udvoicelog;
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
		// getSmsLog 还是udsetresult
	}
	
	public void insertSmslog(Udvoicelog log) {
		try {
			String outId=log.getOutId();
			String[] strs = outId.split("===");
			log.setProjectId(Integer.parseInt(strs[0]));
			log.setExpertId(Integer.parseInt(strs[1]));
			log.setRandomCode(strs[2]);
			
			//TODO
			//smslogMapper.insertSelective(log);
			
			Udsetresult result = new Udsetresult ();
			result.setProjectId(log.getProjectId());
			result.setExpertId(log.getExpertId());
			
			//不接，接了不按，1,2，占线。
			if("1".equals(log.getDtmf())) {
				confirm(result, true);
			}else {
				confirm(result, false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void confirm(Udsetresult result, boolean isAgree) {
		Udsetresult record = new Udsetresult();
		if(isAgree) {
			record.setConfirmStatus("Y");
		}else {
			record.setConfirmStatus("N");
		}
		
		
		UdsetresultExample example = new UdsetresultExample ();
		example.createCriteria().andProjectIdEqualTo(result.getProjectId());
		example.getOredCriteria().get(0).andExpertIdEqualTo(result.getExpertId());
		List<Udsetresult> list = resultMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			Integer notifyNumber = list.get(0).getNotifyNumber()==null?0:list.get(0).getNotifyNumber();
			record.setNotifyNumber(notifyNumber+1);
			resultMapper.updateByExampleSelective(record, example);
		}
		
		updateProjectStatus(result.getProjectId());
	}
	
	/**
	 * 一般就是5个人
	 * @param projectId
	 */
	private void updateProjectStatus(Integer projectId) {
		UdsetresultExample example = new UdsetresultExample ();
		example.createCriteria().andProjectIdEqualTo(projectId);
		example.createCriteria().andConfirmStatusEqualTo("Y");
//		example.getOredCriteria().get(0).and
		long confirmNumber = resultMapper.countByExample(example);
		if(confirmNumber == 5) {
			//TODO
			Udprojects project =new Udprojects();
			project.setId(projectId);
			project.setProjectStatus(ProjectStatus.CONFIRMED.getValue());
			projectMapper.updateByPrimaryKeySelective(project);
		}else {
			//TODO 状态为已通知
			Udprojects project =new Udprojects();
			project.setId(projectId);
			project.setProjectStatus(ProjectStatus.CONFIRM.getValue());
			projectMapper.updateByPrimaryKeySelective(project);
		}		
		
	}
	
	/**
	 * 这样就不要定时几次了，让用户手动点击吧
	 */
	//TODO
	//@Scheduled(cron = "0 * * * * *")  
	public void timer(){  
	    //获取当前时间  
	    LocalDateTime localDateTime =LocalDateTime.now();  
	    System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));  
	    
	}  
}
