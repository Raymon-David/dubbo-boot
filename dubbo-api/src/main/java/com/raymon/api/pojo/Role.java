package com.raymon.api.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatorUser() {
		return creatorUser;
	}
	public void setCreatorUser(String creatorUser) {
		this.creatorUser = creatorUser;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	private Integer id;

    private String name;

    private Date createTime;

    private Integer creator;

    private Date updateTime;

    private Integer updateUser;

    private String description;
    private String creatorUser;
    /** 页面中使用*/
    private int userid;

}