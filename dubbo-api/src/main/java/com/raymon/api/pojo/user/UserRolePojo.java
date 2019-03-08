package com.raymon.api.pojo.user;

import net.sf.json.JSONObject;

import java.io.Serializable;

public class UserRolePojo implements Serializable{

    private static final long serialVersionUID = 1L;
    /**{@link UserPojo.id}*/
    private Long uid;
    /**{@link URolePojo.id}*/
    private Long rid;

    public UserRolePojo(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }
    public UserRolePojo() {
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
