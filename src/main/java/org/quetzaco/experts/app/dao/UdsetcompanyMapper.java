package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udsetcompany;
import org.quetzaco.experts.model.UdsetcompanyExample;

public interface UdsetcompanyMapper {
    long countByExample(UdsetcompanyExample example);

    int deleteByExample(UdsetcompanyExample example);

    int insert(Udsetcompany record);

    int insertSelective(Udsetcompany record);

    List<Udsetcompany> selectByExample(UdsetcompanyExample example);

    int updateByExampleSelective(@Param("record") Udsetcompany record, @Param("example") UdsetcompanyExample example);

    int updateByExample(@Param("record") Udsetcompany record, @Param("example") UdsetcompanyExample example);
}