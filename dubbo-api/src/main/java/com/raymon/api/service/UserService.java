package com.raymon.api.service;

import com.raymon.api.pojo.DubboUser;
import com.raymon.api.pojo.UserKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface UserService {

    static final Logger log =  LoggerFactory.getLogger(UserService.class);

    public DubboUser getUser(UserKey uk);

    public String sayHello(String name);
}
