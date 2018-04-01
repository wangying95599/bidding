package org.quetzaco.experts.app.biz.Impl;

import java.util.List;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.app.dao.UdsetMapper;
import org.quetzaco.experts.app.dao.UdsetcompanyMapper;
import org.quetzaco.experts.app.dao.UdsetexpertMapper;
import org.quetzaco.experts.app.dao.UdsetmajorMapper;
import org.quetzaco.experts.app.dao.UdsetregionMapper;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.UdsetExample;
import org.quetzaco.experts.model.Udsetcompany;
import org.quetzaco.experts.model.UdsetcompanyExample;
import org.quetzaco.experts.model.Udsetexpert;
import org.quetzaco.experts.model.UdsetexpertExample;
import org.quetzaco.experts.model.Udsetmajor;
import org.quetzaco.experts.model.UdsetmajorExample;
import org.quetzaco.experts.model.Udsetregion;
import org.quetzaco.experts.model.UdsetregionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("extractSetService")
public class ExtractSetServiceImpl implements ExtractSetService {
	
	@Autowired
	UdsetMapper setMapper;
	
	@Autowired
	UdsetcompanyMapper companyMapper;
	
	@Autowired
	UdsetexpertMapper expertMapper;
	
	@Autowired
	UdsetmajorMapper majorMapper;
	
	@Autowired
	UdsetregionMapper regionMapper;
	
	@Override
	public void extractSet(Udset set) {
		setMapper.insert(set);
		Udsetcompany company = set.getSetCompany();
		if(company != null) {
			companyMapper.insert(company);
		}
		
		Udsetmajor major = set.getSetMajor();
		if(major != null) {
			majorMapper.insert(major);
		}
		
		Udsetregion region = set.getSetRegion();
		if(region != null) {
			regionMapper.insert(region);
		}
		
		Udsetexpert expert = set.getSetExpert();
		if(expert != null) {
			expertMapper.insert(expert);
		}
	}
	
	
	@Override
	public Udset serachExtractSet(Udset set) {
//		setMapper.insert(set);
		if(set.getProjectId() != null) {
			UdsetExample example = new UdsetExample();
			UdsetExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udset> list = setMapper.selectByExample(example);
			if(list!=null && list.size()==1) {
				set= list.get(0);
			}
		}
		
		if(set.getProjectId() != null) {
			UdsetcompanyExample example = new UdsetcompanyExample();
			UdsetcompanyExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetcompany> list = companyMapper.selectByExample(example);
			if(list!=null && list.size()==1) {
				set.setSetCompany(list.get(0));
			}
		}
		
		if(set.getProjectId() != null) {
			UdsetmajorExample example = new UdsetmajorExample();
			UdsetmajorExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetmajor> list = majorMapper.selectByExample(example);
			if(list!=null && list.size()==1) {
				set.setSetMajor(list.get(0));
			}
		}
		
		if(set.getProjectId() != null) {
			UdsetregionExample example = new UdsetregionExample();
			UdsetregionExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetregion> list = regionMapper.selectByExample(example);
			if(list!=null && list.size()==1) {
				set.setSetRegion(list.get(0));
			}
		}
		
		if(set.getProjectId() != null) {
			UdsetexpertExample example = new UdsetexpertExample();
			UdsetexpertExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetexpert> list = expertMapper.selectByExample(example);
			if(list!=null && list.size()==1) {
				set.setSetExpert(list.get(0));
			}
		}
		
		return set;
	}
}
