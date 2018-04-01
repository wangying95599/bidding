package org.quetzaco.experts.app.biz.Impl;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.app.dao.UdsetMapper;
import org.quetzaco.experts.app.dao.UdsetcompanyMapper;
import org.quetzaco.experts.app.dao.UdsetexpertMapper;
import org.quetzaco.experts.app.dao.UdsetmajorMapper;
import org.quetzaco.experts.app.dao.UdsetregionMapper;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetcompany;
import org.quetzaco.experts.model.UdsetcompanyExample;
import org.quetzaco.experts.model.Udsetexpert;
import org.quetzaco.experts.model.Udsetmajor;
import org.quetzaco.experts.model.Udsetregion;
import org.quetzaco.experts.model.UdsetcompanyExample.Criteria;
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
		setMapper.insert(set);
		Udsetcompany company = set.getSetCompany();
		if(company != null) {
			UdsetcompanyExample example = new UdsetcompanyExample();
			UdsetcompanyExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
//			companyMapper.selectByExample(company);
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
		return null;
	}
}
