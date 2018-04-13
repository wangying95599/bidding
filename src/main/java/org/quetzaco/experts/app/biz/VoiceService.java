package org.quetzaco.experts.app.biz;

import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.Udvoicelog;

public interface VoiceService {
	public void startVoice(Integer id) ;
	public void pauseVoice(Integer id) ;
	public void getVoice(Integer id) ;
	
	public void insertVoicelog(Udvoicelog log);
	
	public void confirm(Udsetresult result, boolean isAgree);
}
