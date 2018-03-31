package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udsetexpert;
import org.quetzaco.experts.model.UdsetexpertExample;

public interface UdsetexpertMapper {
    long countByExample(UdsetexpertExample example);

    int deleteByExample(UdsetexpertExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Udsetexpert record);

    int insertSelective(Udsetexpert record);

    List<Udsetexpert> selectByExample(UdsetexpertExample example);

    Udsetexpert selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") Udsetexpert record, @Param("example") UdsetexpertExample example);

    int updateByExample(@Param("record") Udsetexpert record, @Param("example") UdsetexpertExample example);

    int updateByPrimaryKeySelective(Udsetexpert record);

    int updateByPrimaryKey(Udsetexpert record);
}