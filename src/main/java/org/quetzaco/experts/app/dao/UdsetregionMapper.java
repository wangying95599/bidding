package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udsetregion;
import org.quetzaco.experts.model.UdsetregionExample;

public interface UdsetregionMapper {
    long countByExample(UdsetregionExample example);

    int deleteByExample(UdsetregionExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Udsetregion record);

    int insertSelective(Udsetregion record);

    List<Udsetregion> selectByExample(UdsetregionExample example);

    Udsetregion selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") Udsetregion record, @Param("example") UdsetregionExample example);

    int updateByExample(@Param("record") Udsetregion record, @Param("example") UdsetregionExample example);

    int updateByPrimaryKeySelective(Udsetregion record);

    int updateByPrimaryKey(Udsetregion record);
}