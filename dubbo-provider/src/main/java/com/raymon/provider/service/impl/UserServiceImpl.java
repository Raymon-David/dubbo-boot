package com.raymon.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.pojo.User;
import com.raymon.api.service.UserService;
import com.raymon.provider.dao.UserMapper;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;

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
    public User getUser(User record) {
        return userMapper.queryInfo(record);
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
