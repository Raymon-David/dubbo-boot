package com.raymon.consumer.controller.premission;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.core.mybatis.page.Pagination;
import com.raymon.api.pojo.premission.URolePojo;
import com.raymon.api.pojo.premission.UserRoleAllocationPojo;
import com.raymon.api.service.permission.PermissionService;
import com.raymon.api.service.user.IUserService;
import com.raymon.consumer.controller.common.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 
 * <p>
 * 
 * 用户角色分配
 * 
 * <p>
 *
 * 
 */
@RestController
@Scope(value="prototype")
@RequestMapping("role")
public class UserRoleAllocationController extends BaseController {

	@Reference(version = "${demo.service.version}",
			application = "${dubbo.application.id}",
			url = "dubbo://localhost:20880")
	private IUserService userService;

	@Reference(version = "${demo.service.version}",
			application = "${dubbo.application.id}",
			url = "dubbo://localhost:20880")
	private PermissionService permissionService;
	/**
	 * 用户角色权限分配
	 * @param modelMap
	 * @param pageNo
	 * @param findContent
	 * @return
	 */
	@RequestMapping(value="allocation")
	public ModelAndView allocation(ModelMap modelMap,Integer pageNo,String findContent){
		modelMap.put("findContent", findContent);
		Pagination<UserRoleAllocationPojo> boPage = userService.findUserAndRole(modelMap,pageNo,pageSize);
		modelMap.put("page", boPage);
		return new ModelAndView("role/allocation");
	}
	
	/**
	 * 根据用户ID查询权限
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectRoleByUserId")
	@ResponseBody
	public List<URolePojo> selectRoleByUserId(Long id){
		List<URolePojo> bos = userService.selectRoleByUserId(id);
		return bos;
	}
	/**
	 * 操作用户的角色
	 * @param userId 	用户ID
	 * @param ids		角色ID，以‘,’间隔
	 * @return
	 */
	@RequestMapping(value="addRole2User")
	@ResponseBody
	public Map<String,Object> addRole2User(Long userId,String ids){
		return userService.addRole2User(userId,ids);
	}
	/**
	 * 根据用户id清空角色。
	 * @param userIds	用户ID ，以‘,’间隔
	 * @return
	 */
	@RequestMapping(value="clearRoleByUserIds")
	@ResponseBody
	public Map<String,Object> clearRoleByUserIds(String userIds){
		return userService.deleteRoleByUserIds(userIds);
	}
}