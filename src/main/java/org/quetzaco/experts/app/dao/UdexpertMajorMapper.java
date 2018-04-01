package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.UdexpertMajor;
import org.quetzaco.experts.model.UdexpertMajorExample;

public interface UdexpertMajorMapper {
    long countByExample(UdexpertMajorExample example);

    int deleteByExample(UdexpertMajorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UdexpertMajor record);

    int insertSelective(UdexpertMajor record);

    List<UdexpertMajor> selectByExample(UdexpertMajorExample example);

    UdexpertMajor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UdexpertMajor record, @Param("example") UdexpertMajorExample example);

    int updateByExample(@Param("record") UdexpertMajor record, @Param("example") UdexpertMajorExample example);

    int updateByPrimaryKeySelective(UdexpertMajor record);

    int updateByPrimaryKey(UdexpertMajor record);
}