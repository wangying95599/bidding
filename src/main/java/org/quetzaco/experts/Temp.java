package org.quetzaco.experts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.Udsetcompany;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Temp {
    public static void testUdsetJson() {
        Udset u = new Udset();
        u.setProjectId(1);
        List<Udsetcompany> cList = new ArrayList<Udsetcompany>();
        Udsetcompany c = new Udsetcompany();
        c.setProjectId(1);
        cList.add(c);
        u.setCompanyList(cList);

        ObjectMapper mapper = new ObjectMapper();

        try {
            String uJson = mapper.writeValueAsString(u);
            System.out.println(uJson);
            mapper.readValue(uJson, Udset.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testUdprojectJson() {

        Udprojects u = new Udprojects();
        u.setBiddingLocation("Beijing");
        u.setBiddingLocation("2 hours");
        u.setBiddingTime(new Date());
        u.setExtractCompany("extract company");
        u.setProxyOrg("proxy org");
        u.setPurchaseCode("purchase20180404");
        u.setPurchaseCompany("purchase company");
        u.setPurchaseProject("purchase project name");
        u.setPurchaseType("competitive bidding");
        u.setSmsInfo("Good luck!");

        ObjectMapper mapper = new ObjectMapper();

        try {
            String uJson = mapper.writeValueAsString(u);

//             {"id":null,"purchaseCode":"purchase20180404","purchaseProject":"purchase
//             project name","purchaseCompany":"purchase
//             company","proxyOrg":"proxy org","extractCompany":"extract
//             company","biddingTime":1522826781153,"biddingLocation":"2
//             hours","biddingPeriod":null,"purchaseType":"competitive
//             bidding","smsInfo":"Good luck!","recordFlag":null}
            System.out.println(uJson);
            mapper.readValue(uJson, Udprojects.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public static void random() {
		
        //生成一个包含大小写字母的随机6位字符串；方法1  
          
        String randomcode = "";  
        for(int i=0;i<6;i++)  
        {  
            //52个字母与6个大小写字母间的符号；范围为91~96  
            int value = (int)(Math.random()*58+65);  
            while(value>=91 && value<=96)  
                value = (int)(Math.random()*58+65);  
            randomcode = randomcode + (char)value;  
              
        }  
        System.out.println(randomcode);       
          
        //用字符数组的方式随机  
        String randomcode2 = "";  
        String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
        char[] m = model.toCharArray();  
        String model_num = "1234567890";  
        char[] m_num = model_num.toCharArray();  
          
        for (int j=0;j<2 ;j++ )  
        {  
            char c = m[(int)(Math.random()*26)];  
            randomcode2 = randomcode2 + c;  
        }  
        for (int j=0;j<4 ;j++ )  
        {  
            char c = m_num[(int)(Math.random()*10)];  
            randomcode2 = randomcode2 + c;  
        }  
          
        System.out.println("2                      " +randomcode2);  
  
          
    }  

    public static void main(String args[]) {
        // Temp.testUdsetJson();
        Temp.testUdsetJson();
        random();
    }
}
