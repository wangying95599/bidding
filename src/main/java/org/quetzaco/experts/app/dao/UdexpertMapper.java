package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udexpert;
import org.quetzaco.experts.model.UdexpertExample;

public interface UdexpertMapper {
    long countByExample(UdexpertExample example);

    int deleteByExample(UdexpertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Udexpert record);

    int insertSelective(Udexpert record);

    List<Udexpert> selectByExample(UdexpertExample example);

    Udexpert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Udexpert record, @Param("example") UdexpertExample example);

    int updateByExample(@Param("record") Udexpert record, @Param("example") UdexpertExample example);

    int updateByPrimaryKeySelective(Udexpert record);

    int updateByPrimaryKey(Udexpert record);
    
    
    //自定义mapper方法
    List<Udexpert> extractExpert(Integer id);
}