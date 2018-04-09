package org.quetzaco.experts.app.biz;

import java.util.List;

import org.quetzaco.experts.model.Udmajor;

public interface MajorService {
	
	public List<Udmajor> selectByExample(Udmajor major);
	
	public List<Udmajor> selectMajorCodeTree(Udmajor major);
}
