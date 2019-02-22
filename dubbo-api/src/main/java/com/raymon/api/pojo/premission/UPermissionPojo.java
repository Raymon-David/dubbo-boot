package com.raymon.api.pojo.premission;

import java.io.Serializable;

import com.raymon.api.pojo.user.UPermission;

/**
 * 
 * 权限选择
 * @author zhou-baicheng
 *
 */
public class UPermissionPojo extends UPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 是否勾选
	 */
	private String marker;
	/**
	 * role Id
	 */
	private String roleId;

	public boolean isCheck(){
		return org.apache.commons.lang.StringUtils.equals(roleId,marker);
	}
	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
