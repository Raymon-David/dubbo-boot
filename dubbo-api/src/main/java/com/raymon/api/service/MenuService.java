package com.raymon.api.service;

import com.raymon.api.pojo.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 查询所有菜单
     * @return
     */
    public List<Menu> selectAll();

    /**
     * 查询用户拥有的权限菜单
     * @return 格式化好了的菜单列表
     */
//    public List<Menu> selectByUser(int userId);

    /**
     * 查询用户拥有的所有权限
     * @param userId
     * @return
     */
    List<String> selectAuthorities(int userId);
    /**
     * 添加菜单
     * @return
     */
//    public boolean addMenu(Menu menu);

    /**
     * 添加菜单
     * @return
     */
//    public boolean updateMenu(Menu menu);

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
//    public boolean delete(int id);
}
