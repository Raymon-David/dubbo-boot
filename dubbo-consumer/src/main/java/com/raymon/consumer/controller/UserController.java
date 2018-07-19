package com.raymon.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.pojo.User;
import com.raymon.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private UserService userService;

    @RequestMapping(value ="/user/hello")
    public User hello() {
        User user = new User();
        user.setPhone("17600808516");
        return userService.getUser(user);
    }

    @RequestMapping(value ="/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        log.debug("name" + name);
        return userService.sayHello(name);
    }

}
