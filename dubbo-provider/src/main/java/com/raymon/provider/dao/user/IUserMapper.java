package com.raymon.provider.dao.user;

import com.raymon.api.pojo.premission.URolePojo;
import com.raymon.api.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface IUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User login(Map<String, Object> map);

	User findUserByEmail(String email);

	List<URolePojo> selectRoleByUserId(Long id);

}