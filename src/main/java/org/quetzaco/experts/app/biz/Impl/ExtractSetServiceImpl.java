package org.quetzaco.experts.app.biz.Impl;

import org.quetzaco.experts.app.biz.ExtractSetService;
import org.quetzaco.experts.app.dao.UdsetMapper;
import org.quetzaco.experts.model.Udset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("extractSetService")
public class ExtractSetServiceImpl implements ExtractSetService {
	
	@Autowired
	UdsetMapper setMapper;	
	
	@Override
	public void extractSet(Udset set) {
		setMapper.insert(set);
		
	}

}
