package org.quetzaco.experts.app.biz.Impl;

import java.util.List;

import org.quetzaco.experts.app.biz.ExpertService;
import org.quetzaco.experts.app.dao.UdexpertMajorMapper;
import org.quetzaco.experts.app.dao.UdexpertMapper;
import org.quetzaco.experts.app.dao.UdexpertRegionMapper;
import org.quetzaco.experts.enums.RecordFlag;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.UdexpertExample;
import org.quetzaco.experts.model.UdexpertExample.Criteria;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.UdexpertMajorExample;
import org.quetzaco.experts.model.UdexpertRegion;
import org.quetzaco.experts.model.UdexpertRegionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("expertService")
public class ExpertServiceImpl implements ExpertService {

	final static Logger logger = LoggerFactory
			.getLogger(ExpertServiceImpl.class);
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
		Udexpert expert = this.getExpert(id);
		expert.setRecordFlag(RecordFlag.DELETE.getValue());
		UdexpertExample expertExample = new UdexpertExample();
		expertExample.createCriteria().andExpertIdEqualTo(id);
		expertMapper.updateByExample(expert, expertExample);
		
		// delete related major
		UdexpertMajorExample majorExample = new UdexpertMajorExample();
		majorExample.createCriteria().andExpertIdEqualTo(expert.getExpertId());
		UdexpertMajor major = new UdexpertMajor();
		major.setRecordFlag(RecordFlag.DELETE.getValue());
		majorMapper.updateByExample(major, majorExample);

		// delete related region
		UdexpertRegionExample regionExample = new UdexpertRegionExample();
		regionExample.createCriteria().andExpertIdEqualTo(expert.getExpertId());
		UdexpertRegion region = new UdexpertRegion();
		region.setRecordFlag(RecordFlag.DELETE.getValue());
		regionMapper.updateByExample(region, regionExample);
	}

	@Override
	public Udexpert updateExpert(Udexpert expert) {
		UdexpertMajorExample majorExample = new UdexpertMajorExample();
		majorExample.createCriteria().andExpertIdEqualTo(expert.getExpertId());
		majorMapper.deleteByExample(majorExample);

		UdexpertRegionExample regionExample = new UdexpertRegionExample();
		regionExample.createCriteria().andExpertIdEqualTo(expert.getExpertId());
		regionMapper.deleteByExample(regionExample);

		expertMapper.updateByPrimaryKey(expert);
		List<UdexpertMajor> majorList = expert.getMajorList();
		if (null != majorList) {
			for (UdexpertMajor major : majorList) {
				major.setExpertId(expert.getExpertId());
				majorMapper.insertSelective(major);
			}
		}

		List<UdexpertRegion> regionList = expert.getRegionList();
		if (null != regionList) {
			for (UdexpertRegion region : regionList) {
				region.setExpertId(expert.getExpertId());
				region.setRecordFlag(RecordFlag.CREATE.getValue());
				regionMapper.insert(region);
			}
		}
		return expert;
	}

	@Override
	public Udexpert getExpert(Integer id) {
		return expertMapper.selectByPrimaryKey(id);
	}

	public List<Udexpert> selectByExample(Udexpert expert) {
		List<Udexpert> expertList=null;
		try {
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

				if(expert.getRecordFlag() != null){
					criteria.andRecordFlagEqualTo(expert.getRecordFlag());
				}
				if(expert.getExpertId() != null){
					criteria.andExpertIdEqualTo(expert.getExpertId());
				}
				expertList = expertMapper.selectByExample(example);

			} else {
				expertList = expertMapper.selectByExample(null);
			}
			
			//select related major and region
			for (Udexpert obj : expertList) {
				Integer expertId = obj.getExpertId();

				UdexpertMajorExample majorCriteria = new UdexpertMajorExample();
				majorCriteria.createCriteria().andExpertIdEqualTo(expertId);
				List<UdexpertMajor> majorList = majorMapper
						.selectByExample(majorCriteria);
				obj.setMajorList(majorList);

				UdexpertRegionExample regionExample = new UdexpertRegionExample();
				regionExample.createCriteria().andExpertIdEqualTo(expertId);
				List<UdexpertRegion> regionList = regionMapper
						.selectByExample(regionExample);
				obj.setRegionList(regionList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expertList;
	}

	@Override
	public List<Udexpert> getCompanyList(Udexpert expert) {
		UdexpertExample example = new UdexpertExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompanyLike(expert.getCompany());
		return expertMapper.selectByExample(example);
	}
}
