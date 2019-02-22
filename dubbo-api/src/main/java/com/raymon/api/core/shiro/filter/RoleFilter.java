package com.raymon.api.core.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 开发公司：raymon.api在线工具 <p>
 * 版权所有：© www.raymon.api.com<p>
 * 博客地址：http://www.raymon.api.com/blog/  <p>
 * <p>
 * 
 * 角色判断校验
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　raymon　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@raymon.api.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class RoleFilter extends AccessControlFilter {

	static final String LOGIN_URL = "http://www.raymon.api.com/user/open/toLogin.shtml";
	static final String UNAUTHORIZED_URL = "http://www.raymon.api.com/unauthorized.html";
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {
		String[] arra = (String[])mappedValue;
		
		Subject subject = getSubject(request, response);
		for (String role : arra) {
			if(subject.hasRole("role:" + role)){
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		
			Subject subject = getSubject(request, response);  
	        if (subject.getPrincipal() == null) {//表示没有登录，重定向到登录页面  
	            saveRequest(request);  
	            WebUtils.issueRedirect(request, response, LOGIN_URL);  
	        } else {  
	            if (StringUtils.hasText(UNAUTHORIZED_URL)) {//如果有未授权页面跳转过去  
	                WebUtils.issueRedirect(request, response, UNAUTHORIZED_URL);  
	            } else {//否则返回401未授权状态码  
	                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
	            }  
	        }  
		return false;
	}

}
