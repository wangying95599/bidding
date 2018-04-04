package org.quetzaco.experts.app.biz;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.quetzaco.experts.app.dao.UdmajorMapper;
import org.quetzaco.experts.boot.ExpertsApplicationTests;
import org.quetzaco.experts.model.Udmajor;
import org.quetzaco.experts.model.UdmajorExample;
import org.quetzaco.experts.util.excel.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class MajorServiceTest extends ExpertsApplicationTests{
	@Autowired
	MajorService service;
	
	@Autowired
    ExcelUtils excelUtils;
	
	@Autowired
	UdmajorMapper mapper;
	
	@Test
	@Rollback(false)
	public void set() throws Exception {
		List<String> bankListByExcel = ExcelUtils.getBankListByExcel("E:/1.xls",(2-1), new ExcelUtils.ExcelRunner<String>() {
            @Override
            public String construct(Row row) {
            	String code = ExcelUtils.getCellValue(row.getCell(0));
                System.out.println(code);
                int len = code.length()/2;
                for(int i=0;i<len;i++) {
                	System.out.println(i*2+":  "+(i*2+2));
                	String miniCode=code.substring(i*2,i*2+2);
                	System.out.println(miniCode);
                	
                	UdmajorExample exmaple = new UdmajorExample();
                	exmaple.createCriteria().andMajorCodeEqualTo(miniCode);
                	List<Udmajor> list = mapper.selectByExample(exmaple);
                	if(list == null||list.size()==0) {
                		Udmajor record = new Udmajor();
                		record.setMajorCode(miniCode);
                		record.setMajorName(ExcelUtils.getCellValue(row.getCell(i+1)));
                		record.setMajorDesc(ExcelUtils.getCellValue(row.getCell(6)));
                		mapper.insertSelective(record);
                	}
                	
                }
                
                
                return "";
            }
        });
	}
}
