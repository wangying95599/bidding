package org.quetzaco.experts.app.biz;

import java.util.List;

import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetresult;

public interface ExtractService {
	public List<Udsetresult> extract(Udset set);
	public void insertExtract(List<Udsetresult> list);
	
	public List<Udsetresult> getExtractResult(Udset set);

	/**
	 * 手动 发送短信
	 */
}
