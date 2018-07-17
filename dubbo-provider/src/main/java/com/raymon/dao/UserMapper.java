package com.raymon.dao;


import com.raymon.api.pojo.DubboUser;
import com.raymon.api.pojo.UserKey;
import com.raymon.api.pojo.UserWithBLOBs;

//@MapperScan("com.raymon.dao.UserMapper")
public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(DubboUser record);
}