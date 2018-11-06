package com.raymon.provider.dao;

import com.raymon.api.pojo.Menu;
import com.raymon.api.pojo.MenuCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MenuMapper {
    List<Menu> selectByExample(MenuCriteria example);

    /**
     *查询超级用户的所有权限，超级用户拥有所有权限
     * @return
     */
    List<String> selectAuthoritiesByRoot();

    /**
     *查询用户有权限的菜单列表,0是所有用户的默认权限
     * @param userid
     * @return
     */
    List<String> selectAuthorities(int userid);
}
