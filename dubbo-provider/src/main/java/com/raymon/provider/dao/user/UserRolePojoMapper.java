package com.raymon.provider.dao.user;

import java.util.List;
import java.util.Map;

import com.raymon.api.pojo.user.UserRolePojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserRolePojoMapper {
    int insert(UserRolePojo record);

    int insertSelective(UserRolePojo record);

	int deleteByUserId(Long id);

	int deleteRoleByUserIds(Map<String, Object> resultMap);

	List<Long> findUserIdByRoleId(Long id);
}