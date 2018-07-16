package com.raymon.dao;


import com.raymon.pojo.DubboUser;
import com.raymon.pojo.UserKey;
import com.raymon.pojo.UserWithBLOBs;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.raymon.dao.UserMapper")
public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(DubboUser record);
}