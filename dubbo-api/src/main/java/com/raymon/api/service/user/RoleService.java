package com.raymon.api.service.user;

import com.raymon.api.pojo.user.URolePojo;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService {

    int deleteByPrimaryKey(Long id);

    int insert(URolePojo record);

    int insertSelective(URolePojo record);

    URolePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(URolePojo record);

    int updateByPrimaryKey(URolePojo record);

//    Pagination<URolePojo> findPage(Map<String, Object> resultMap, Integer pageNo,
//                               Integer pageSize);

    Map<String, Object> deleteRoleById(String ids);

//    Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(
//            Map<String, Object> resultMap, Integer pageNo, Integer pageSize);

    //根据用户ID查询角色（role），放入到Authorization里。
    Set<String> findRoleByUserId(Long userId);

    List<URolePojo> findNowAllPermission();
    //初始化数据
    void initData();
}
