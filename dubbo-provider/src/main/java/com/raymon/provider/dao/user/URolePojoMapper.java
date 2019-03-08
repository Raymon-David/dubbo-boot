package com.raymon.provider.dao.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.raymon.api.pojo.user.URolePojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface URolePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(URolePojo record);

    int insertSelective(URolePojo record);

    URolePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(URolePojo record);

    int updateByPrimaryKey(URolePojo record);

	Set<String> findRoleByUserId(Long id);

	List<URolePojo> findNowAllPermission(Map<String, Object> map);
	
	void initData();
}