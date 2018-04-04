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

    public static void main(String args[]) {
        // Temp.testUdsetJson();
        Temp.testUdprojectJson();
    }
}
