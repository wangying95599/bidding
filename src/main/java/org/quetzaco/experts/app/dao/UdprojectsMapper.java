package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udprojects;
import org.quetzaco.experts.model.UdprojectsExample;

public interface UdprojectsMapper {
    long countByExample(UdprojectsExample example);

    int deleteByExample(UdprojectsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Udprojects record);

    int insertSelective(Udprojects record);

    List<Udprojects> selectByExample(UdprojectsExample example);

    Udprojects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Udprojects record, @Param("example") UdprojectsExample example);

    int updateByExample(@Param("record") Udprojects record, @Param("example") UdprojectsExample example);

    int updateByPrimaryKeySelective(Udprojects record);

    int updateByPrimaryKey(Udprojects record);
}