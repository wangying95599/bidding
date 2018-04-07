package org.quetzaco.experts.util.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static String getJson(Object obj) {
    	String result=null;

        ObjectMapper mapper = new ObjectMapper();
        

        try {
        	result = mapper.writeValueAsString(obj);

            System.out.println(result);
          
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String args[]) {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("name", "王瑛");
    	map.put("projectLocation", "北京");
    	map.put("projectDate", "2018-3-29");
    	map.put("projectName", "投标需求");
    	getJson(map);
    }
}
