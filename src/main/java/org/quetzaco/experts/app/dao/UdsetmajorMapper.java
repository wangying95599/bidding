package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udsetmajor;
import org.quetzaco.experts.model.UdsetmajorExample;

public interface UdsetmajorMapper {
    long countByExample(UdsetmajorExample example);

    int deleteByExample(UdsetmajorExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Udsetmajor record);

    int insertSelective(Udsetmajor record);

    List<Udsetmajor> selectByExample(UdsetmajorExample example);

    Udsetmajor selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") Udsetmajor record, @Param("example") UdsetmajorExample example);

    int updateByExample(@Param("record") Udsetmajor record, @Param("example") UdsetmajorExample example);

    int updateByPrimaryKeySelective(Udsetmajor record);

    int updateByPrimaryKey(Udsetmajor record);
    
    List<Udsetmajor> selectById(@Param("projectId") Integer projectId);
}