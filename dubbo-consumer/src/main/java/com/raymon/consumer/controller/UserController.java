package com.raymon.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.pojo.User;
import com.raymon.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);

    @Reference(version = "${dubbo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private UserService userService;


    /**
     * 测试调用后台数据
     *
     * */
    @RequestMapping(value ="/user/hello")
    public User hello() {
        User user = new User();
        user.setPhone("17600808516");
        return userService.getUser(user);
    }

    /**
     * 测试传参，调用service
     *
     * */
    @RequestMapping(value ="/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        log.debug("name" + name);
        return userService.sayHello(name);
    }


    /**
     * 测试返回页面，用controller返回渲染HTML
     *
     * */
    @RequestMapping(value ="/user/login")
    public ModelAndView hello (ModelAndView mv) {
        mv.setViewName("logon");
        return mv;
    }

}
