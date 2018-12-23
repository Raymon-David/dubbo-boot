package com.raymon.consumer.aop;

import com.raymon.api.pojo.AdminUser;
import com.raymon.api.pojo.WebResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 安全认证的aop拦截器
 * Created by raymon on 2017/3/29.
 */
@Aspect
@Component
public class SecurityAspect {
    /** 登录的地址，不对登录进行拦截*/
    private static final String LOGINURL = "/admin/login";
    /** 注销的地址，不对注销进行拦截*/
    private static final String LOGINOUTURL = "/admin/loginout";
//    @Pointcut("execution(public * com.raymon.consumer.controller..*.*(..))")
//    public void verification() {
//    }

//    @Around("verification()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();


        String uri = request.getRequestURI();
        if(uri.lastIndexOf("/") == uri.length()-1){
            uri = uri.substring(0,uri.length()-1);
        }
        System.out.println("进入拦截器:"+uri);
        if(LOGINURL.equals(uri)){
            //不拦截的
            return pjp.proceed();
        }
        if((session.getAttribute("loginUser") == null || session.getAttribute("authorities") == null) ){
            Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
            if(returnType == String.class || returnType == ModelAndView.class){
                //返回到登录页面
                return "/nologin";
            }else{
                //返回没有权限的json
                return WebResult.noLogin();
            }

        }
        AdminUser user = (AdminUser) session.getAttribute("loginUser");
        //判断是否有权限
        List<String> authorities = (List<String>) session.getAttribute("authorities");
        if(authorities.contains(uri) || -1 == user.getId() || LOGINOUTURL.equals(uri)) {
            return pjp.proceed();
        }else{
            Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
            if(returnType == String.class || returnType == ModelAndView.class){
                //返回到登录页面
                return "/303";
            }else{
                //返回没有权限的json
                return WebResult.noAuthority();
            }
        }

    }
}