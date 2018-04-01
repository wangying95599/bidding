package org.quetzaco.experts.app.biz;

import org.quetzaco.experts.model.Udexpert;

public interface ExpertService {
	Udexpert createExpert(Udexpert expert);
	void deleteExpert(Integer id);
	Udexpert updateExpert(Udexpert expert);
	Udexpert getExpert(Integer expertId);
}
