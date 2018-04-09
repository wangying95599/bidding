package org.quetzaco.experts.app.biz.Impl;

import java.util.List;

import org.quetzaco.experts.app.biz.MajorService;
import org.quetzaco.experts.app.dao.UdmajorMapper;
import org.quetzaco.experts.model.Udmajor;
import org.quetzaco.experts.model.UdmajorExample;
import org.quetzaco.experts.model.UdmajorExample.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("majorService")
public class MajorServiceImpl implements MajorService {

	final static Logger logger = LoggerFactory.getLogger(MajorServiceImpl.class);
	@Autowired
	UdmajorMapper majorMapper;

	@Override
	public  List<Udmajor> selectByExample(Udmajor major){
		UdmajorExample example = new UdmajorExample();
		example.setDistinct(true);
		
		Criteria criteria = example.createCriteria();
		
		if(major.getMajorCode()!=null)
			criteria.andMajorCodeLike("%"+major.getMajorCode()+"%");
		
		if(major.getMajorName()!=null)
			criteria.andMajorNameLike("%"+major.getMajorName()+"%");
		
		return majorMapper.selectByExample(example);
	}

	@Override
	public  List<Udmajor> selectMajorCodeTree(Udmajor major){
		if(major == null || major.getMajorCode()==null) {
			return majorMapper.selectMajorCodeTree(null);
		}else{
			return majorMapper.selectMajorCodeTree(major.getMajorCode());
		}
		
	}
}
