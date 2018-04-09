package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.UdexpertRegion;
import org.quetzaco.experts.model.UdexpertRegionExample;

public interface UdexpertRegionMapper {
    long countByExample(UdexpertRegionExample example);

    int deleteByExample(UdexpertRegionExample example);

    int insert(UdexpertRegion record);

    int insertSelective(UdexpertRegion record);

    List<UdexpertRegion> selectByExample(UdexpertRegionExample example);

    int updateByExampleSelective(@Param("record") UdexpertRegion record, @Param("example") UdexpertRegionExample example);

    int updateByExample(@Param("record") UdexpertRegion record, @Param("example") UdexpertRegionExample example);
}