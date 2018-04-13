package org.quetzaco.experts.app.biz.Impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.app.biz.ProjectService;
import org.quetzaco.experts.app.dao.UdexpertMajorMapper;
import org.quetzaco.experts.app.dao.UdprojectsMapper;
import org.quetzaco.experts.app.dao.UdsetMapper;
import org.quetzaco.experts.app.dao.UdsetcompanyMapper;
import org.quetzaco.experts.app.dao.UdsetexpertMapper;
import org.quetzaco.experts.app.dao.UdsetmajorMapper;
import org.quetzaco.experts.app.dao.UdsetregionMapper;
import org.quetzaco.experts.enums.ProjectStatus;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.UdexpertMajorExample;
import org.quetzaco.experts.model.Udprojects;
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
	UdsetmajorMapper setmajorMapper;
	
	@Autowired
	UdsetregionMapper regionMapper;
	
	@Autowired
	UdexpertMajorMapper expertMajorMapper;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	UdprojectsMapper projectMapper;
	
	@Override
	public void extractSet(Udset set) {
		
		UdsetExample setExample = new UdsetExample();
		setExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		List list = setMapper.selectByExample(setExample);
		if(list!=null && list.size()==0) {
			set.setCreatedTime(new Date());
			setMapper.insert(set);
			
			Udprojects project =new Udprojects();
			project.setId(set.getProjectId());
			project.setProjectStatus(ProjectStatus.SET.getValue());
			projectMapper.updateByPrimaryKeySelective(project);
		}
		
		UdsetcompanyExample companyexample = new UdsetcompanyExample();
		companyexample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		companyMapper.deleteByExample(companyexample);
		
		UdsetmajorExample setmajorExample = new UdsetmajorExample();
		setmajorExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		setmajorMapper.deleteByExample(setmajorExample);
		
		UdsetregionExample regionExample = new UdsetregionExample();
		regionExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		regionMapper.deleteByExample(regionExample);
		
		UdsetexpertExample expertExample = new UdsetexpertExample();
		expertExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		expertMapper.deleteByExample(expertExample);
		
		if(set.getCompanyList()!= null) {
			for(Udsetcompany company:set.getCompanyList()) {
				company.setProjectId(set.getProjectId());
				companyMapper.insertSelective(company);
			}
		}
		if(set.getMajorList() !=null) {
			for(Udsetmajor major:set.getMajorList()) {
				major.setProjectId(set.getProjectId());
				setmajorMapper.insert(major);
			}
		}
		if(set.getRegionList() !=null) {
			for(Udsetregion region:set.getRegionList()) {
				region.setProjectId(set.getProjectId());
				regionMapper.insert(region);
			}
		}
		if(set.getExpertList() !=null) {
			for(Udsetexpert expert:set.getExpertList()) {
				expert.setProjectId(set.getProjectId());
				expertMapper.insert(expert);
			}
		}

	}
	
	
	@Override
	public Udset serachExtractSet(Udset set) {
		
		if(set.getProjectId() != null) {
			set.setProject(projectService.getProject(set.getProjectId()));
		}

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
			set.setCompanyList(list);
		}
		
		if(set.getProjectId() != null) {
			UdsetmajorExample example = new UdsetmajorExample();
			UdsetmajorExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetmajor> list = setmajorMapper.selectById(set.getProjectId());
			set.setMajorList(list);
		}
		
		if(set.getProjectId() != null) {
			UdsetregionExample example = new UdsetregionExample();
			UdsetregionExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetregion> list = regionMapper.selectByExample(example);
			set.setRegionList(list);
		}
		
		if(set.getProjectId() != null) {
			UdsetexpertExample example = new UdsetexpertExample();
			UdsetexpertExample.Criteria criteria = example.createCriteria();
			criteria.andProjectIdEqualTo(set.getProjectId());
			List<Udsetexpert> list = expertMapper.selectById(set.getProjectId());
			set.setExpertList(list);
		}
		
		HashSet<Integer> expertForMajorSet = new HashSet<Integer>();
		
		if(set.getMajorList() !=null && set.getMajorList().size()>0) {
			//可能 有重复的 0103 下 有的人多个专家
			Long expertNumForMajor=0l;
			for(Udsetmajor major:set.getMajorList()) {
				UdexpertMajorExample example = new UdexpertMajorExample();
				example.setDistinct(true);
				example.createCriteria().andMajorCodeLike("'"+major.getMajorCode()+"%'");
				List<UdexpertMajor> list = expertMajorMapper.selectByExample(example);
				if(list!=null && list.size()>0) {//not list is id
					
					for(UdexpertMajor expert:list) {
						expertForMajorSet.add(expert.getExpertId());
					}
				}			
			}
			expertNumForMajor += expertForMajorSet.size();
			set.setExpertNumForMajor(expertNumForMajor);
		}
		
		//回避 1 指定回避专家  回避2 单位专家 回避3冻结专家 3种可能重复，set
		Long expertNumForAvoid=0l;
		
		
		
		set.setExpertNumForAvoid(expertNumForAvoid);
		
		return set;
	}
}
