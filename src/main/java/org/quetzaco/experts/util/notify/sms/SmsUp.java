package org.quetzaco.experts.util.notify.sms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alicom.mns.tools.DefaultAlicomMessagePuller;
import com.alicom.mns.tools.MessageListener;
import com.aliyun.mns.model.Message;
import com.google.gson.Gson;

/**
 *  短信上行消息接收
 */
@Component
public class SmsUp implements CommandLineRunner {

	final String accessKeyId = "LTAInEp3GgPOr7QN";
	final String accessKeySecret = "4fiNSZZQncUA3uGsvR6JB5NbrEqSyB";

	private Log logger = LogFactory.getLog(SmsUp.class);

	class MyMessageListener implements MessageListener {
		private Gson gson = new Gson();

		@Override
		public boolean dealMessage(Message message) {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 消息的几个关键值
			System.out.println("message receiver time from mns:" + format.format(new Date()));
			System.out.println("message handle: " + message.getReceiptHandle());
			System.out.println("message body: " + message.getMessageBodyAsString());
			System.out.println("message id: " + message.getMessageId());
			System.out.println("message dequeue count:" + message.getDequeueCount());
			System.out.println("Thread:" + Thread.currentThread().getName());
			try {
				Map<String, Object> contentMap = gson.fromJson(message.getMessageBodyAsString(), HashMap.class);

				// TODO 根据文档中具体的消息格式进行消息体的解析
				String phoneNumber = (String) contentMap.get("phone_number");
				String content = (String) contentMap.get("content");
				String signName = (String) contentMap.get("sign_name");
				String sendTime = (String) contentMap.get("send_time");
				String destCode = (String) contentMap.get("dest_code");
				Double sequenceId = (Double) contentMap.get("sequence_id");
				System.out.println("电话                      "+phoneNumber);
				System.out.println("内容                      "+content);
				// TODO 这里开始编写您的业务代码

			} catch (com.google.gson.JsonSyntaxException e) {
				e.printStackTrace();
				logger.error("error_json_format:" + message.getMessageBodyAsString(), e);
				// 理论上不会出现格式错误的情况，所以遇见格式错误的消息，只能先delete,否则重新推送也会一直报错
				return true;
			} catch (Throwable e) {
				e.printStackTrace();
				return false;
			}
			System.out.println("消息处理成功                      ");
			// 消息处理成功，返回true, SDK将调用MNS的delete方法将消息从队列中删除掉
			return true;
		}

	}

	public void run(String... args) throws Exception, ParseException {
		logger.info("    SmsUp        run ");
		DefaultAlicomMessagePuller puller = new DefaultAlicomMessagePuller();
		// 和服务端联调问题时开启,平时无需开启，消耗性能
		// puller.openDebugLog(false);

		String messageType = "SmsUp";// 此处应该替换成相应产品的消息类型
		String queueName = "Alicom-Queue-1983821798243001-SmsUp";// 在云通信页面开通相应业务消息后，就能在页面上获得对应的queueName,格式类似Alicom-Queue-xxxxxx-SmsReport
		puller.startReceiveMsg(accessKeyId, accessKeySecret, messageType, queueName, new MyMessageListener());
	}
	
//	public static void main(String[] args) {
//		
//	}

}
