package org.quetzaco.experts.app.biz;

import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.Udvoicelog;

public interface SmsService {
	public void startSms(Integer id) ;
	public void getSms(Integer id) ;
	public void insertSmslog(Udvoicelog log);
	
	public void confirm(Udsetresult result, boolean isAgree);
}
