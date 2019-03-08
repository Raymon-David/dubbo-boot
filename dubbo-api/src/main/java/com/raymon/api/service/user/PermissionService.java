package com.raymon.api.service.user;

import com.raymon.api.pojo.permission.UPermissionBo;
import com.raymon.api.pojo.user.UPermissionPojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PermissionService {

    int deleteByPrimaryKey(Long id);

    UPermissionPojo insert(UPermissionPojo record);

    UPermissionPojo insertSelective(UPermissionPojo record);

    UPermissionPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UPermissionPojo record);

    int updateByPrimaryKey(UPermissionPojo record);

    Map<String, Object> deletePermissionById(String ids);

//    Pagination<UPermissionPojo> findPage(Map<String,Object> resultMap, Integer pageNo,
//                                     Integer pageSize);

    List<UPermissionBo> selectPermissionById(Long id);

    Map<String, Object> addPermission2Role(Long roleId,String ids);

    Map<String, Object> deleteByRids(String roleIds);
    //根据用户ID查询权限（permission），放入到Authorization里。
    Set<String> findPermissionByUserId(Long userId);
    
}
