package com.raymon.provider.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.pojo.DubboUser;
import com.raymon.api.pojo.UserKey;
import com.raymon.api.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;

//@RequestMapping(value ="/user")
@RestController
public class UserController {

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private UserService userService;

    @RequestMapping(value ="/user/hello")
    public DubboUser hello() {
        UserKey user = new UserKey();
        user.setHost("localhost");
        return userService.getUser(user);
    }

    @RequestMapping(value ="/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        log.debug("name" + name);
        return userService.sayHello(name);
    }

}
