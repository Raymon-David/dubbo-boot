package com.raymon.api.pojo;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;

public class Role extends BaseDataModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String roleCode; // 角色编码
    private String roleName; // 角色名称
    private String roleType; // 角色类型


    private User user;		// 根据用户ID查询角色列表

    private List<Menu> menuList = Lists.newArrayList(); // 拥有角色列表


    public Role() {
        super();
    }
    public Role(User user) {
        this();
        this.user = user;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoleType() {
        return roleType;
    }
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    public List<Menu> getMenuList() {
        return menuList;
    }
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public String getMenuIds() {
        return StringUtils.join(getMenuIdList(), ",");
    }

    public void setMenuIds(String menuIds) {
        menuList = Lists.newArrayList();
        if (menuIds != null){
            String[] ids = StringUtils.split(menuIds, ",");
            List<Long> list = Lists.newArrayList();
            for(String id:ids){
                list.add(Long.valueOf(id));
            }
            setMenuIdList(list);
        }
    }

    public List<Long> getMenuIdList() {
        List<Long> menuIdList = Lists.newArrayList();
        for (Menu menu : menuList) {
            menuIdList.add(menu.getId());
        }
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        menuList = Lists.newArrayList();
        for (Long menuId : menuIdList) {
            Menu menu = new Menu();
            menu.setId(menuId);
            menuList.add(menu);
        }
    }

}
