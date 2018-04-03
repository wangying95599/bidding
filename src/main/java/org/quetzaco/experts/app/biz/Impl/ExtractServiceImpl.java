package org.quetzaco.experts.app.biz.Impl;

import java.util.HashMap;
import java.util.List;

import org.quetzaco.experts.app.biz.ExtractService;
import org.quetzaco.experts.app.dao.UdexpertMajorMapper;
import org.quetzaco.experts.app.dao.UdexpertMapper;
import org.quetzaco.experts.app.dao.UdmajorMapper;
import org.quetzaco.experts.app.dao.UdsetmajorMapper;
import org.quetzaco.experts.app.dao.UdsetresultMapper;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.UdexpertMajorExample;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetmajor;
import org.quetzaco.experts.model.UdsetmajorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("extractService")
public class ExtractServiceImpl implements ExtractService {
	
	@Autowired
	UdsetresultMapper resultMapper;
	
	@Autowired
	UdexpertMapper expertMapper;
	
	@Autowired
	UdmajorMapper majorMapper;
	
	@Autowired
	UdsetmajorMapper setmajorMapper;
	
	@Autowired
	UdexpertMajorMapper expertMajorMapper;

	/**
	 * 抽取的结果从experts表查询， 回避条件是id，company， 选择条件是region，major，id
	 * 这些条件从设置表中查询到。
	 * 子查询 做回避，冻着查询。生成的临时表都是符合条件的
	 * 外层查询 条件
	 * 
	 */
	@Override
	public void extract(Udset set) {
		//1 回避-单位
		//2 回避-专家
		//3 冻结-专家		
		//1 指定-区域
		
		//2 指定-专业 每个还有人数限制，如果不够，上面的统计会看到。
		//3 指定-专家
		List<Udexpert> expertList =expertMapper.extractExpert(set.getProjectId());
		System.out.println(expertList);
		
		
		//select major_id,major_code from udsetmajor;
		//select distinct expert_id from udexpert_major where major_code like code+'%';
		
		/**
		 * 查询 设置要求的专业
		 */
		UdsetmajorExample setmajorExample = new UdsetmajorExample ();
		setmajorExample.createCriteria().andProjectIdEqualTo(set.getProjectId());
		List<Udsetmajor> setmajorList =  setmajorMapper.selectByExample(setmajorExample);
		
		HashMap<String,Long> setmajorMap = new HashMap<String,Long>();
		for(Udsetmajor setmajor:setmajorList) {
			setmajorMap.put(setmajor.getMajorCode(), setmajor.getMajorNumber());
		}
		
		/**
		 * 查询所有的 专家和专业的对应关系，过滤条件majorcode,多对多，用map不合适。
		 */
		HashMap<Integer,UdexpertMajor> pmMap = new HashMap<Integer,UdexpertMajor>();
		for(Udsetmajor setmajor:setmajorList) {
			UdexpertMajorExample expertMajorExample = new UdexpertMajorExample ();
			expertMajorExample.createCriteria().andMajorCodeLike("'%"+setmajor.getMajorCode()+"'");
			List<UdexpertMajor> list = expertMajorMapper.selectByExample(expertMajorExample);
			for(UdexpertMajor pm:list) {
				pmMap.put(pm.getExpertId(), pm);
			}
		}
		
		
		/**
		 * 随机逻辑
		 * 1 加入白名单
		 * 2
		 */
		HashMap<Integer,Udexpert> expertMap = new HashMap<Integer,Udexpert>();
		
		for(Udexpert expert:expertList) {
			
			//已经加入map
			if(expertMap.get(expert.getId()) !=null) {
				continue;
			}
			
			
			/**
			 * 两个退出条件 1：map满员 2 各专业满员
			 * 其中白名单 可能符合各专业，算哪个呢？
			 */
			if(1==1) {
				break;
			}
		}
		System.out.println(expertList);
		
	}
	
	
	
}
