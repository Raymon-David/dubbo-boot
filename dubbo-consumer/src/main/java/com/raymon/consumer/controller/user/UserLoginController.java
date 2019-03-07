package com.raymon.consumer.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserLoginController {

    private static final Logger log =  LoggerFactory.getLogger(UserLoginController.class);

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value ="/user/login" ,method = RequestMethod.GET)
    public ModelAndView hello (Model model) {
        model.addAttribute("msg", "后台传的数据...");
        return new ModelAndView("/user/login");
    }
}
