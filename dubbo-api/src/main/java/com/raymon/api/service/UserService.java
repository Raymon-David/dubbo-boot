package com.raymon.api.service;

import com.raymon.api.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface UserService {

    static final Logger log =  LoggerFactory.getLogger(UserService.class);

    User getUser(User record);

    String sayHello(String name);
}
