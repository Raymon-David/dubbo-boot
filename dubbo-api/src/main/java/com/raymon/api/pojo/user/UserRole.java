package com.raymon.api.pojo.user;

import java.io.Serializable;

import net.sf.json.JSONObject;
/**
 *
 * <p>
 * 
 * 用户{@link User} 和角色 {@link URole} 中间表
 * 
 * <p>
 * <p>
 * *******
 * <p>
 * 
 */
public class UserRole implements Serializable{
	private static final long serialVersionUID = 1L;
	 /**{@link User.id}*/
    private Long uid;
    /**{@link URole.id}*/
    private Long rid;

    public UserRole(Long uid, Long rid) {
    	this.uid = uid;
    	this.rid = rid;
	}
    public UserRole() {
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}