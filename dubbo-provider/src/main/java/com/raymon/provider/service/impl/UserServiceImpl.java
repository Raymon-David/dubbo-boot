package com.raymon.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.provider.dao.UserMapper;
import com.raymon.api.pojo.DubboUser;
import com.raymon.api.pojo.UserKey;
import com.raymon.api.pojo.UserWithBLOBs;
import com.raymon.api.service.UserService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;

//@Service(interfaceClass = UserService.class)
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class UserServiceImpl implements UserService {

    private static final Logger log =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public DubboUser getUser(UserKey uk) {

        UserWithBLOBs us = userMapper.selectByPrimaryKey(uk);
        return us;
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
