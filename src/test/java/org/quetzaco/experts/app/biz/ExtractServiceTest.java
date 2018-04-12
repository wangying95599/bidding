package org.quetzaco.experts.app.biz;

import org.junit.Test;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class ExtractServiceTest extends ExpertsApplicationTests{
	@Autowired
	ExtractService service;
	
	@Test
	@Rollback(false)
	public void set() {
		Udset set = new Udset();
		set.setProjectId(443);
		
		
		service.extract(set);
	}
	@Test
	public void random() {
		
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
          
        for (int j=0;j<6 ;j++ )  
        {  
            char c = m[(int)(Math.random()*26)];  
            randomcode2 = randomcode2 + c;  
        }  
          
        System.out.println(randomcode2);  
  
          
    }  
}
