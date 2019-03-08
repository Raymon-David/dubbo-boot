package com.raymon.api.pojo.user;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class UserPojo implements Serializable {

    private static final long serialVersionUID = 1L;
    //0:禁止登录
    public static final Long _0 = new Long(0);
    //1:有效
    public static final Long _1 = new Long(1);
    private Long id;
    /**昵称*/
    private String nickname;
    /**邮箱 | 登录帐号*/
    private String email;
    /**密码*/
    private transient String pswd;
    /**创建时间*/
    private Date createTime;
    /**最后登录时间*/
    private Date lastLoginTime;
    /**1:有效，0:禁止登录*/
    private Long status;



    public UserPojo() {}
    public UserPojo(UserPojo userPojo) {
        this.id = userPojo.getId();
        this.nickname = userPojo.getNickname();
        this.email = userPojo.getEmail();
        this.pswd = userPojo.getPswd();
        this.createTime = userPojo.getCreateTime();
        this.lastLoginTime = userPojo.getLastLoginTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public Long getStatus() {
        return status;
    }
    public void setStatus(Long status) {
        this.status = status;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
