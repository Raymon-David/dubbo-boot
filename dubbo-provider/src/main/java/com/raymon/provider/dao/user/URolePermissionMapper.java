package com.raymon.provider.dao.user;

import java.util.List;
import java.util.Map;

import com.raymon.api.pojo.user.URolePermissionPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface URolePermissionMapper {
    int insert(URolePermissionPojo record);

    int insertSelective(URolePermissionPojo record);

	List<URolePermissionPojo> findRolePermissionByPid(Long id);
	
	List<URolePermissionPojo> findRolePermissionByRid(Long id);
	
	List<URolePermissionPojo> find(URolePermissionPojo entity);
	
	int deleteByPid(Long id);
	int deleteByRid(Long id);
	int delete(URolePermissionPojo entity);

	int deleteByRids(Map<String, Object> resultMap);
}