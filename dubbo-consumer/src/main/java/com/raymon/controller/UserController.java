package com.raymon.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.pojo.DubboUser;
import com.raymon.pojo.UserKey;
import com.raymon.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Reference(url = "dubbo://127.0.0.1:20880")
    private UserService userService;

    @RequestMapping(value ="/hello")
    public DubboUser hello() {
        UserKey user = new UserKey();
        user.setHost("localhost");
        return userService.getUser(user);
    }

}
