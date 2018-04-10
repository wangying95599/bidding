package org.quetzaco.experts.app.biz.Impl;

import java.util.List;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.app.dao.UdexpertMajorMapper;
import org.quetzaco.experts.app.dao.UdexpertMapper;
import org.quetzaco.experts.app.dao.UdexpertRegionMapper;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.UdexpertExample;
import org.quetzaco.experts.model.UdexpertExample.Criteria;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.UdexpertRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("expertService")
public class ExpertServiceImpl implements ExpertService {

	final static Logger logger = LoggerFactory.getLogger(ExpertServiceImpl.class);
	@Autowired
	UdexpertMapper expertMapper;

	@Autowired
	UdexpertMajorMapper majorMapper;

	@Autowired
	UdexpertRegionMapper regionMapper;

	@Override
	public Udexpert createExpert(Udexpert expert) {
		expertMapper.insertSelective(expert);

		int expertId = expert.getExpertId();

		List<UdexpertMajor> majorList = expert.getMajorList();
		if (null != majorList) {
			for (UdexpertMajor major : majorList) {
				major.setExpertId(expertId);
				majorMapper.insertSelective(major);
			}
		}

		List<UdexpertRegion> regionList = expert.getRegionList();
		if (null != regionList) {
			for (UdexpertRegion region : regionList) {
				region.setExpertId(expertId);
				regionMapper.insert(region);
			}
		}
		return expert;
	}

	@Override
	public void deleteExpert(Integer id) {
		expertMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Udexpert updateExpert(Udexpert expert) {
		// TODO Auto-generated method
		// stubexpertMapper.updateByPrimaryKey(expert);
		expertMapper.updateByPrimaryKey(expert);
		return expert;
	}

	@Override
	public Udexpert getExpert(Integer id) {
		// TODO Auto-generated method stub
		return expertMapper.selectByPrimaryKey(id);
	}

	public List<Udexpert> selectByExample(Udexpert expert) {
		if (null != expert) {

			UdexpertExample example = new UdexpertExample();
			example.setDistinct(true);

			Criteria criteria = example.createCriteria();

			if (expert.getName() != null)
				criteria.andNameLike("%" + expert.getName() + "%");

			if (expert.getPhone() != null)
				criteria.andPhoneLike("%" + expert.getPhone() + "%");

			if (expert.getCompany() != null)
				criteria.andCompanyLike("%" + expert.getCompany() + "%");

			return expertMapper.selectByExample(example);
		} else {
			return expertMapper.selectByExample(null);
		}
	}

	@Override
	public List<Udexpert> getCompanyList(Udexpert expert) {
		UdexpertExample example = new UdexpertExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompanyLike(expert.getCompany());
		return expertMapper.selectByExample(example);
	}
}
