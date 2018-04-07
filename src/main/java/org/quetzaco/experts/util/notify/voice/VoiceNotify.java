package org.quetzaco.experts.util.notify.voice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quetzaco.experts.util.json.JsonUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dyvmsapi.model.v20170525.IvrCallRequest;
import com.aliyuncs.dyvmsapi.model.v20170525.IvrCallRequest.MenuKeyMap;
import com.aliyuncs.dyvmsapi.model.v20170525.IvrCallResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Created on 17/6/10.
 * 语音API产品的DEMO程序,工程中包含了一个VmsDemo类，直接通过
 * 执行main函数即可体验语音产品API功能(只需要将AK替换成开通了云通信-语音产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dyvmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 */
public class VoiceNotify {

    //产品名称:云通信语音API产品,开发者无需替换
    static final String product = "Dyvmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dyvmsapi.aliyuncs.com";

    //TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAInEp3GgPOr7QN";
    static final String accessKeySecret = "4fiNSZZQncUA3uGsvR6JB5NbrEqSyB";
    static final String showNumber="041188254025";

    
    /**
     * 交互式语音应答
     * @return
     * @throws ClientException
     */
    public static IvrCallResponse ivrCall(String phone,String json,String outId) throws ClientException {
    	
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        IvrCallRequest request = new IvrCallRequest();
        //必填-被叫显号,可在语音控制台中找到所购买的显号
        request.setCalledShowNumber(showNumber);
        //必填-被叫号码
        request.setCalledNumber(phone);
        request.setPlayTimes(3L);
        request.setTimeout(3000);

        //必填-语音文件ID或者tts模板的模板号,有参数的模板需要设置模板变量的值
        request.setStartCode("TTS_129740669");
        request.setStartTtsParams(json);
        
        List<MenuKeyMap> menuKeyMaps = new ArrayList<MenuKeyMap>();
        MenuKeyMap menuKeyMap1 = new MenuKeyMap();
        menuKeyMap1.setKey("1");
        menuKeyMap1.setCode("TTS_129760685");
        menuKeyMaps.add(menuKeyMap1);
        MenuKeyMap menuKeyMap2 = new MenuKeyMap();
        menuKeyMap2.setKey("2");
        menuKeyMap2.setCode("TTS_129760685");
        menuKeyMaps.add(menuKeyMap2);

        request.setMenuKeyMaps(menuKeyMaps);

        //可选-外部扩展字段
        request.setOutId(outId);

        //hint 此处可能会抛出异常，注意catch
        IvrCallResponse ivrCallResponse = acsClient.getAcsResponse(request);

        return ivrCallResponse;
    }


    public static void main(String[] args) throws ClientException, InterruptedException {
	    	String phone="15011118641";
	    	Map<String,String> map = new HashMap<String,String>();
	    	map.put("name", "王瑛");
	    	map.put("projectLocation", "北京");
	    	map.put("projectDate", "2018-3-29");
	    	map.put("projectName", "投标需求");
	    	 String json=JsonUtil.getJson(map);

	    	 System.out.println(json);
    	 IvrCallResponse ivrCallResponse = ivrCall(phone,json,"111");
         System.out.println("交互式语音应答---------------");
         System.out.println("RequestId=" + ivrCallResponse.getRequestId());
         System.out.println("Code=" + ivrCallResponse.getCode());
         System.out.println("Message=" + ivrCallResponse.getMessage());
         System.out.println("CallId=" + ivrCallResponse.getCallId());



        Thread.sleep(20000L);


    }

}
