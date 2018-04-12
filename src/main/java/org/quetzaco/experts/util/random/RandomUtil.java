package org.quetzaco.experts.util.random;

public class RandomUtil {
	
	public static String getRandomValue() {
		
        //用字符数组的方式随机  
        String randomValue = "";  
        String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
        char[] m = model.toCharArray();  
        String model_num = "1234567890";  
        char[] m_num = model_num.toCharArray();  
          
        for (int j=0;j<2 ;j++ )  
        {  
            char c = m[(int)(Math.random()*26)];  
            randomValue = randomValue + c;  
        }  
        for (int j=0;j<4 ;j++ )  
        {  
            char c = m_num[(int)(Math.random()*10)];  
            randomValue = randomValue + c;  
        }  
          
        System.out.println("2                      " +randomValue);  
        return randomValue;
    }  

	
	public static String getRandomValue_DL() {
		
        //用字符数组的方式随机  
        String randomValue = "DL";  
        String model_num = "1234567890";  
        char[] m_num = model_num.toCharArray();  
   
        for (int j=0;j<8 ;j++ )  
        {  
            char c = m_num[(int)(Math.random()*10)];  
            randomValue = randomValue + c;  
        }  
          
        System.out.println("2                      " +randomValue);  
        return randomValue;
    }  
}
