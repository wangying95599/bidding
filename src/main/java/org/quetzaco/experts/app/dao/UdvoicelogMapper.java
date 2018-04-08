package org.quetzaco.experts.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.quetzaco.experts.model.Udvoicelog;
import org.quetzaco.experts.model.UdvoicelogExample;

public interface UdvoicelogMapper {
    long countByExample(UdvoicelogExample example);

    int deleteByExample(UdvoicelogExample example);

    int insert(Udvoicelog record);

    int insertSelective(Udvoicelog record);

    List<Udvoicelog> selectByExample(UdvoicelogExample example);

    int updateByExampleSelective(@Param("record") Udvoicelog record, @Param("example") UdvoicelogExample example);

    int updateByExample(@Param("record") Udvoicelog record, @Param("example") UdvoicelogExample example);
}