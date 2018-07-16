package com.raymon.pojo;

import java.util.Date;

public class Organ extends BaseDataModel {
    private static final long serialVersionUID = 1L;

    private Long id;//主键

    private String status;//状态

    private String orgCode;//机构代码

    private String orgName;//机构描述

    private String orgParent;//上级机构代码

    private String orgAttr;//机构属性

    private String orgMemo;//备注

    private Date createTime;//创建时间

    private String createUser;//创建人

    private Date updateTime;//修改时间

    private String updateUser;//修改人

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgParent() {
        return orgParent;
    }

    public void setOrgParent(String orgParent) {
        this.orgParent = orgParent;
    }

    public String getOrgAttr() {
        return orgAttr;
    }

    public void setOrgAttr(String orgAttr) {
        this.orgAttr = orgAttr;
    }

    public String getOrgMemo() {
        return orgMemo;
    }

    public void setOrgMemo(String orgMemo) {
        this.orgMemo = orgMemo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
