package com.raymon.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.dao.UserMapper;
import com.raymon.pojo.DubboUser;
import com.raymon.pojo.UserKey;
import com.raymon.pojo.UserWithBLOBs;
import com.raymon.service.UserService;

import javax.annotation.Resource;

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public DubboUser getUser(UserKey uk) {

        UserWithBLOBs us = userMapper.selectByPrimaryKey(uk);
        return us;
    }
}
