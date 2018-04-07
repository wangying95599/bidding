package org.quetzaco.experts.app.biz;

import java.util.List;

import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetwhite;

public interface WhiteExpertService {
	
	public void createWhiteExpert(Udset sets);
	
	public List<Udexpert> getWhiteExpert(Integer projectId);
}
