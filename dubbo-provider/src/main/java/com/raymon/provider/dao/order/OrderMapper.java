package com.raymon.provider.dao.order;

import com.raymon.api.pojo.order.OrderPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {
    int insert(OrderPojo record);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(OrderPojo record);
    OrderPojo selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(OrderPojo record);
    int updateByPrimaryKey(OrderPojo record);
}
