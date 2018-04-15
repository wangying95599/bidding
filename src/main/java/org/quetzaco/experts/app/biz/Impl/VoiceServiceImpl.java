package org.quetzaco.experts.app.biz.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quetzaco.experts.app.biz.VoiceService;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.app.dao.UdsetresultMapper;
import org.quetzaco.experts.app.dao.UdvoicelogMapper;
import org.quetzaco.experts.enums.ProjectStatus;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.UdsetresultExample;
import org.quetzaco.experts.model.Udvoicelog;
import org.quetzaco.experts.util.json.JsonUtil;
import org.quetzaco.experts.util.notify.voice.VoiceNotify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.aliyuncs.dyvmsapi.model.v20170525.IvrCallResponse;
import com.aliyuncs.exceptions.ClientException;

@Service("voiceService")
public class VoiceServiceImpl implements VoiceService {

	final static Logger logger = LoggerFactory.getLogger(VoiceServiceImpl.class);
	@Autowired
	UdsetresultMapper resultMapper;
	@Autowired
	UdprojectsMapper projectMapper;
	
	@Autowired
	UdvoicelogMapper voicelogMapper;
	
	private String getStringNotNull(String str) {
		if(str==null) {
			return "";
		}
		return str;
	}
	
	@Override
	public void startVoice(Integer projectId) {
		UdsetresultExample example = new UdsetresultExample();
		example.createCriteria().andProjectIdEqualTo(projectId);
		List<Udsetresult> list = resultMapper.selectDetailInfo(projectId);
		
		Udprojects project = projectMapper.selectByPrimaryKey(projectId);
    	
		for(Udsetresult result:list) {
			if("Y".equals(result.getConfirmStatus())) {
				continue;
			}
			Map<String,String> map = new HashMap<String,String>();
	    	map.put("name", getStringNotNull(result.getName()));
	    	map.put("projectLocation", getStringNotNull(project.getBiddingLocation()));
	    	map.put("projectDate", project.getBiddingTime()==null?"":project.getBiddingTime()+"");
	    	map.put("projectName", getStringNotNull(project.getPurchaseProject()));
	    	String json=JsonUtil.getJson(map);
	    	 
			try {
				 IvrCallResponse ivrCallResponse = VoiceNotify.ivrCall(result.getPhone(), json, projectId+"==="+result.getExpertId()+"==="+result.getRandomCode());
		         System.out.println("交互式语音应答---------------");
		         System.out.println("RequestId=" + ivrCallResponse.getRequestId());
		         System.out.println("Code=" + ivrCallResponse.getCode());
		         System.out.println("Message=" + ivrCallResponse.getMessage());
		         System.out.println("CallId=" + ivrCallResponse.getCallId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void pauseVoice(Integer projectId) {
		//TODO update 字段为 暂停通知 
		
	}
	@Override
	public void getVoice(Integer projectId) {
		
	}
	
	public void insertVoicelog(Udvoicelog log) {
		try {
			String outId=log.getOutId();
			String[] strs = outId.split("===");
			log.setProjectId(Integer.parseInt(strs[0]));
			log.setExpertId(Integer.parseInt(strs[1]));
			log.setRandomCode(strs[2]);
			
			voicelogMapper.insertSelective(log);
			
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
	 * 现在的表需要加字段， udsetresult加上专业，通知了几次。 udset加上状态。所有的状态就用udset吧，为空就是未设置。已设置、已抽取、部分确认、已确认
	 * 下一个问题，历史的记录怎么处理呢。这个今天不考虑了。
	 */
	
	@Scheduled(cron = "0 * * * * *")  
	public void timer(){  
	    //获取当前时间  
	    LocalDateTime localDateTime =LocalDateTime.now();  
	    System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));  
	    /**
	     * project_set 有状态为语音通知的(且不是暂停通知)，检查还有的未确认的，且通知次数不到的，，是否到了时间，到了就调用通知逻辑。
	     */
	    
	}  
}
