package com.raymon.pojo;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

public class User extends BaseDataModel {

    private static final long serialVersionUID = 1L;

    private String username; // 用户名

    private String password; // 密码`

    private String phonenum; // 手机号

    private String email; // 邮箱

    private String realname; // 真实姓名

    private String activestatus; // 激活状态 1:已激活 2:未激活BIGDECIMAL

    private String userType; // 用户类型

    private String userCode; // 用户编码

    private Date lastUpdatePwd;

    private Date lockEndTime;

    private String fromChannelCode;// 列支渠道

    private String clientCode;

    private String payPasswd; // 支付密码

    private Organ org; // 组织机构

    private Role role; // 根据用户ID查询角色列表

    private String lockPayPasswd;

    private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表

    private String thdOrgCode;

    private String thdOrgName;

    private String orgParent;


    public String getThdOrgCode() {
        return thdOrgCode;
    }

    public void setThdOrgCode(String thdOrgCode) {
        this.thdOrgCode = thdOrgCode;
    }

    public String getThdOrgName() {
        return thdOrgName;
    }

    public void setThdOrgName(String thdOrgName) {
        this.thdOrgName = thdOrgName;
    }

    public String getOrgParent() {
        return orgParent;
    }

    public void setOrgParent(String orgParent) {
        this.orgParent = orgParent;
    }

    public User() {
        super();
    }

    public User(Role role) {
        super();
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(String activestatus) {
        this.activestatus = activestatus;
    }

    public Date getLastUpdatePwd() {
        return lastUpdatePwd;
    }

    public void setLastUpdatePwd(Date lastUpdatePwd) {
        this.lastUpdatePwd = lastUpdatePwd;
    }

    public Date getLockEndTime() {
        return lockEndTime;
    }

    public void setLockEndTime(Date lockEndTime) {
        this.lockEndTime = lockEndTime;
    }

    public String getFromChannelCode() {
        return fromChannelCode;
    }

    public void setFromChannelCode(String fromChannelCode) {
        this.fromChannelCode = fromChannelCode == null ? null : fromChannelCode
                .trim();
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode == null ? null : clientCode.trim();
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public String getPayPasswd() {
        return payPasswd;
    }

    public void setPayPasswd(String payPasswd) {
        this.payPasswd = payPasswd == null ? null : payPasswd.trim();
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Long> getRoleIdList() {
        List<Long> roleIdList = Lists.newArrayList();
        for (Role role : roleList) {
            roleIdList.add(role.getId());
        }
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        roleList = Lists.newArrayList();
        for (Long roleId : roleIdList) {
            Role role = new Role();
            role.setId(roleId);
            roleList.add(role);
        }
    }

    /**
     * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
     */
    public String getRoleNames() {
        return "";
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Organ getOrg() {
        return org;
    }

    public void setOrg(Organ org) {
        this.org = org;
    }

    public String getLockPayPasswd() {
        return lockPayPasswd;
    }

    public void setLockPayPasswd(String lockPayPasswd) {
        this.lockPayPasswd = lockPayPasswd;
    }
}
