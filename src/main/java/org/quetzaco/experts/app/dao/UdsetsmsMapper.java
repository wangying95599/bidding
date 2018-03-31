package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udsetsms;
import org.quetzaco.experts.model.UdsetsmsExample;

public interface UdsetsmsMapper {
    long countByExample(UdsetsmsExample example);

    int deleteByExample(UdsetsmsExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(Udsetsms record);

    int insertSelective(Udsetsms record);

    List<Udsetsms> selectByExample(UdsetsmsExample example);

    Udsetsms selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") Udsetsms record, @Param("example") UdsetsmsExample example);

    int updateByExample(@Param("record") Udsetsms record, @Param("example") UdsetsmsExample example);

    int updateByPrimaryKeySelective(Udsetsms record);

    int updateByPrimaryKey(Udsetsms record);
}