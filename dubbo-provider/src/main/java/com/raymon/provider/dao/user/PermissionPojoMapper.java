package com.raymon.provider.dao.user;

import java.util.List;
import java.util.Set;

import com.raymon.api.pojo.permission.UPermissionBo;
import com.raymon.api.pojo.user.UPermissionPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PermissionPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UPermissionPojo record);

    int insertSelective(UPermissionPojo record);

    UPermissionPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UPermissionPojo record);

    int updateByPrimaryKey(UPermissionPojo record);

	List<UPermissionBo> selectPermissionById(Long id);
	//根据用户ID获取权限的Set集合
	Set<String> findPermissionByUserId(Long id);
}