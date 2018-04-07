package org.quetzaco.experts.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.Udsetwhite;
import org.quetzaco.experts.model.UdsetwhiteExample;

public interface UdsetwhiteMapper {
    long countByExample(UdsetwhiteExample example);

    int deleteByExample(UdsetwhiteExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Udsetwhite record);

    int insertSelective(Udsetwhite record);

    List<Udsetwhite> selectByExample(UdsetwhiteExample example);

    Udsetwhite selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") Udsetwhite record, @Param("example") UdsetwhiteExample example);

    int updateByExample(@Param("record") Udsetwhite record, @Param("example") UdsetwhiteExample example);

    int updateByPrimaryKeySelective(Udsetwhite record);

    int updateByPrimaryKey(Udsetwhite record);
    
    /**
     * 自定义
     */
    List<Udexpert> selectByProjectId(@Param("projectId") Integer projectId);
}