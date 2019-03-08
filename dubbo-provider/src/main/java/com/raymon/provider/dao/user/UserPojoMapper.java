package com.raymon.provider.dao.user;

import java.util.List;
import java.util.Map;

import com.raymon.api.pojo.permission.URoleBo;
import com.raymon.api.pojo.user.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);

    UserPojo login(Map<String, Object> map);

    UserPojo findUserByEmail(String email);

	List<URoleBo> selectRoleByUserId(Long id);

}