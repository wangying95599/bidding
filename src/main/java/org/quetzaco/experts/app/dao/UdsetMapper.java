package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udset;
import org.quetzaco.experts.model.UdsetExample;

public interface UdsetMapper {
    long countByExample(UdsetExample example);

    int deleteByExample(UdsetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Udset record);

    int insertSelective(Udset record);

    List<Udset> selectByExample(UdsetExample example);

    Udset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Udset record, @Param("example") UdsetExample example);

    int updateByExample(@Param("record") Udset record, @Param("example") UdsetExample example);

    int updateByPrimaryKeySelective(Udset record);

    int updateByPrimaryKey(Udset record);
}