package com.raymon.api.service.user;

import java.util.List;
import java.util.Map;

import com.raymon.api.pojo.premission.URolePojo;
import com.raymon.api.pojo.premission.UserRoleAllocationPojo;
import com.raymon.api.pojo.user.User;
import org.springframework.ui.ModelMap;

import com.raymon.api.core.mybatis.page.Pagination;

public interface IUserService {

	int deleteByPrimaryKey(Long id);

	User insert(User record);

    User insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(String email, String pswd);

	User findUserByEmail(String email);

	Pagination<User> findByPage(Map<String, Object> resultMap, Integer pageNo,
								Integer pageSize);

	Map<String, Object> deleteUserById(String ids);

	Map<String, Object> updateForbidUserById(Long id, Long status);

	Pagination<UserRoleAllocationPojo> findUserAndRole(ModelMap modelMap,
													   Integer pageNo, Integer pageSize);

	List<URolePojo> selectRoleByUserId(Long id);

	Map<String, Object> addRole2User(Long userId, String ids);

	Map<String, Object> deleteRoleByUserIds(String userIds);
}
