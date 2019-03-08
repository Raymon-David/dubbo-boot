package com.raymon.api.service.user;

import com.raymon.api.pojo.permission.URoleBo;
import com.raymon.api.pojo.user.UserPojo;

import java.util.List;
import java.util.Map;

public interface UserService {

    int deleteByPrimaryKey(Long id);

    UserPojo insert(UserPojo record);

    UserPojo insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);

    UserPojo login(String email , String pswd);

    UserPojo findUserByEmail(String email);

//    Pagination<UserPojo> findByPage(Map<String, Object> resultMap, Integer pageNo,
//                                 Integer pageSize);

    Map<String, Object> deleteUserById(String ids);

    Map<String, Object> updateForbidUserById(Long id, Long status);

//    Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
//                                                     Integer pageNo, Integer pageSize);

    List<URoleBo> selectRoleByUserId(Long id);

    Map<String, Object> addRole2User(Long userId, String ids);

    Map<String, Object> deleteRoleByUserIds(String userIds);
}
