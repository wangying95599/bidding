package org.quetzaco.experts.app.biz.Impl;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.app.dao.UdexpertMapper;
import org.quetzaco.experts.model.Udexpert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("expertService")
public class ExpertServiceImpl implements ExpertService {

	final static Logger logger = LoggerFactory.getLogger(ExpertServiceImpl.class);
	@Autowired
	UdexpertMapper expertMapper;

	@Override
	public Udexpert createExpert(Udexpert expert) {
		expertMapper.insertSelective(expert);
		return expert;
	}

	@Override
	public void deleteExpert(Integer id) {
		expertMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Udexpert updateExpert(Udexpert expert) {
		// TODO Auto-generated method stubexpertMapper.updateByPrimaryKey(expert);
		expertMapper.updateByPrimaryKey(expert);
		return expert;
	}

	@Override
	public Udexpert getExpert(Integer id) {
		// TODO Auto-generated method stub
		return expertMapper.selectByPrimaryKey(id);
	}

}
