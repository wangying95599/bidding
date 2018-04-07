package org.quetzaco.experts.app.biz.Impl;

import java.util.List;

import org.quetzaco.experts.app.biz.WhiteExpertService;
import org.quetzaco.experts.app.dao.UdsetwhiteMapper;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetwhite;
import org.quetzaco.experts.model.UdsetwhiteExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("whiteService")
public class WhiteExpertServiceImpl implements WhiteExpertService {
	
	@Autowired
	UdsetwhiteMapper whiteMapper;
	

	
	@Override
	public void createWhiteExpert(Udset set) {
		UdsetwhiteExample example = new UdsetwhiteExample();
		example.createCriteria().andProjectIdEqualTo(set.getProjectId());
		whiteMapper.deleteByExample(example);
		for(Udsetwhite white:set.getWhiteList()) {
			white.setProjectId(set.getProjectId());
			whiteMapper.insertSelective(white);
		}

	}
	
	
	@Override
	public List<Udexpert> getWhiteExpert(Integer projectId) {

		List<Udexpert> list = whiteMapper.selectByProjectId(projectId);
		
		return list;
	}
}
