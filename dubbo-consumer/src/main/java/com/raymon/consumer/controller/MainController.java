package com.raymon.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.pojo.AdminUser;
import com.raymon.api.pojo.Menu;
import com.raymon.api.service.AdminUserService;
import com.raymon.api.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private static final Logger log =  LoggerFactory.getLogger(MainController.class);

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private MenuService menuService;

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private AdminUserService adminUserService;

    /**
     * 进入系统管理首页
     * @param map
     * @return
     */
//    @RequestMapping("index")
//    public String index(ModelMap map, HttpSession session){
//        AdminUser user = (AdminUser) session.getAttribute("loginUser");
//        List<Menu> menus = menuService.selectByUser(user.getId());
//
//        map.put("treeMenu",menus);
//        return "index";
//    }

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping(value ="/admin/login" ,method = RequestMethod.GET)
    public String login(@RequestParam(defaultValue = "0") int type,  ModelAndView mv){

        if(type == 1){
            return "nologin";
        }
        return "login";
    }

    @RequestMapping(value ="/admin/login", method = RequestMethod.POST)
    public String login(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "")  String pass,
                        ModelMap map, HttpSession session){
        AdminUser user = adminUserService.login(name,pass);
        if(user == null){
            map.put("error","用户名或密码错误");
            return "login";
        }
        session.setAttribute("loginUser",user);
        session.setAttribute("authorities",menuService.selectAuthorities(user.getId()));
        return "redirect:/admin/index";
    }

    /**
     * 注销登录
     * @param session
     * @return
     */
    @RequestMapping("loginout")
    public String loginOut(HttpSession session){
        session.setAttribute("loginUser",null);
        session.setAttribute("authorities",null);
        return "login";
    }
}
