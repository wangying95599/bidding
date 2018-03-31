package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udsetresult;
import org.quetzaco.experts.model.UdsetresultExample;

public interface UdsetresultMapper {
    long countByExample(UdsetresultExample example);

    int deleteByExample(UdsetresultExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Udsetresult record);

    int insertSelective(Udsetresult record);

    List<Udsetresult> selectByExample(UdsetresultExample example);

    Udsetresult selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") Udsetresult record, @Param("example") UdsetresultExample example);

    int updateByExample(@Param("record") Udsetresult record, @Param("example") UdsetresultExample example);

    int updateByPrimaryKeySelective(Udsetresult record);

    int updateByPrimaryKey(Udsetresult record);
}