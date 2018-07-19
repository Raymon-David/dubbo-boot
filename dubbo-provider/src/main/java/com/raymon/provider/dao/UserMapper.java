package com.raymon.provider.dao;

import com.raymon.api.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User queryInfo(User record);
}