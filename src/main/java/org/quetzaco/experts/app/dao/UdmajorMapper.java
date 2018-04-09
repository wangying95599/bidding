package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udmajor;
import org.quetzaco.experts.model.UdmajorExample;

public interface UdmajorMapper {
    long countByExample(UdmajorExample example);

    int deleteByExample(UdmajorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Udmajor record);

    int insertSelective(Udmajor record);

    List<Udmajor> selectByExample(UdmajorExample example);

    Udmajor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Udmajor record, @Param("example") UdmajorExample example);

    int updateByExample(@Param("record") Udmajor record, @Param("example") UdmajorExample example);

    int updateByPrimaryKeySelective(Udmajor record);

    int updateByPrimaryKey(Udmajor record);
    
    List<Udmajor> selectMajorCodeTree(@Param("majorCode") String majorCode);
}