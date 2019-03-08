package com.raymon.consumer.controller.user;

import com.raymon.api.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserLoginController {

    private static final Logger log =  LoggerFactory.getLogger(UserLoginController.class);

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value ="/user/login" ,method = RequestMethod.GET)
    public ModelAndView login (Model model) {
        model.addAttribute("msg", "后台传的数据...");
        return new ModelAndView("/user/login");
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value ="/user/register" ,method = RequestMethod.GET)
    public ModelAndView register (Model model) {
        model.addAttribute("msg", "后台传的数据...");
        return new ModelAndView("/user/register");
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="/user/logout",method =RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> logout(){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
//            TokenManager.logout();
            resultMap.put("status", 200);
        } catch (Exception e) {
            resultMap.put("status", 500);
            log.error("errorMessage:" + e.getMessage());
            LoggerUtils.fmtError(getClass(), e, "退出出现错误，%s。", e.getMessage());
        }
        return resultMap;
    }
}
