package org.quetzaco.experts.app.biz;

import java.util.List;

import org.quetzaco.experts.model.Udexpert;

public interface ExpertService {
	Udexpert createExpert(Udexpert expert);
	void deleteExpert(Integer id);
	Udexpert updateExpert(Udexpert expert);
	Udexpert getExpert(Integer expertId);
	public List<Udexpert> selectByExample(Udexpert expert);
	public List<Udexpert> getCompanyList(Udexpert expert) ;
}
