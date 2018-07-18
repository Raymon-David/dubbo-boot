package com.raymon.provider.dao;


import com.raymon.api.pojo.DubboUser;
import com.raymon.api.pojo.UserKey;
import com.raymon.api.pojo.UserWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

//@MapperScan("UserMapper")
@Component
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(DubboUser record);
}