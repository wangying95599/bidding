package org.quetzaco.experts.util.notify.voice;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.alicom.mns.tools.DefaultAlicomMessagePuller;
import com.alicom.mns.tools.MessageListener;
import com.aliyun.mns.model.Message;
import com.google.gson.Gson;

/**
 * 只能用于接收云通信的消息，不能用于接收其他业务的消息
 * 短信上行消息接收demo
 * 
 * 您正在进行${product}身份验证，验证码${code}，打死不要告诉别人哦！
 * 
 * ${name},您好，${projectName}将于${projectDate}在${projectLocation}召开，请确认是否能够参与，参与回复1，不参与回复2.
 * ${name},您好，会议时间：${projectDate}，会议地点：${projectLocation}，会议主题：${projectName}，望准时参加
 * 
 * 
 */
public class VoiceReceive {

	private static Log logger=LogFactory.getLog(VoiceReceive.class);
	
	static class MyMessageListener implements MessageListener{
		private Gson gson=new Gson();
		@Override
		public boolean dealMessage(Message message) {

			//消息的几个关键值
			System.out.println("message handle: " + message.getReceiptHandle());
            System.out.println("message body: " + message.getMessageBodyAsString());
            System.out.println("message id: " + message.getMessageId());
            System.out.println("message dequeue count:" + message.getDequeueCount());
            
            try{
            	Map<String,Object> contentMap=gson.fromJson(message.getMessageBodyAsString(), HashMap.class);

            	 //依据自己的消息类型，获取对应的字段
                String callId=(String)contentMap.get("call_id");
                String startTime=(String)contentMap.get("start_time");
                String endTime=(String)contentMap.get("end_time");
                String duration=(String)contentMap.get("duration");
                String statusCode=(String)contentMap.get("status_code");
                String statusMsg=(String)contentMap.get("status_msg");
                String outId=(String)contentMap.get("out_id");
                String dtmf=(String)contentMap.get("dtmf");
            	
				//TODO 根据文档中具体的消息格式进行消息体的解析
                String arg = (String) contentMap.get("arg");
                System.out.println("1callId          "+callId);
                System.out.println("1startTime          "+startTime);
                System.out.println("1endTime          "+endTime);
                System.out.println("1duration          "+duration);
                System.out.println("1statusCode          "+statusCode);
                System.out.println("1statusMsg          "+statusMsg);
                System.out.println("1outId          "+outId);
                System.out.println("1dtmf          "+dtmf);

                //TODO 这里开始编写您的业务代码
                
            }catch(com.google.gson.JsonSyntaxException e){
            	logger.error("error_json_format:"+message.getMessageBodyAsString(),e);
				//理论上不会出现格式错误的情况，所以遇见格式错误的消息，只能先delete,否则重新推送也会一直报错
				return true;
            } catch (Throwable e) {
				//您自己的代码部分导致的异常，应该return false,这样消息不会被delete掉，而会根据策略进行重推
				return false;
			}
            System.out.println("消息处理成功");
			//消息处理成功，返回true, SDK将调用MNS的delete方法将消息从队列中删除掉
			return true;
		}
		
	}
	
	public static void main(String[] args) throws com.aliyuncs.exceptions.ClientException, ParseException {

		DefaultAlicomMessagePuller puller=new DefaultAlicomMessagePuller();

		//TODO 此处需要替换成开发者自己的AK信息
		String accessKeyId="LTAInEp3GgPOr7QN";
		String accessKeySecret="4fiNSZZQncUA3uGsvR6JB5NbrEqSyB";

		/*
		* TODO 将messageType和queueName替换成您需要的消息类型名称和对应的队列名称
		*云通信产品下所有的回执消息类型:
		*1:短信回执：SmsReport，
		*2:短息上行：SmsUp
		*3:语音呼叫：VoiceReport
		*4:流量直冲：FlowReport
		*/
		String messageType="VoiceReport";//此处应该替换成相应产品的消息类型
		String queueName="Alicom-Queue-1983821798243001-VoiceReport";//在云通信页面开通相应业务消息后，就能在页面上获得对应的queueName,每一个消息类型
		puller.startReceiveMsg(accessKeyId,accessKeySecret, messageType, queueName, new MyMessageListener());
    }

	
	
}