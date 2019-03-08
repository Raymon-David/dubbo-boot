package com.raymon.api.pojo.user;
import net.sf.json.JSONObject;

import java.io.Serializable;

public class URolePermissionPojo implements Serializable{

    private static final long serialVersionUID = 1L;
    /**{@link URolePojo.id}*/
    private Long rid;
    /**{@link UPermissionPojo.id}*/
    private Long pid;

    public URolePermissionPojo() {
    }
    public URolePermissionPojo(Long rid, Long pid) {
        this.rid = rid;
        this.pid = pid;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String toString(){
        return JSONObject.fromObject(this).toString();
    }
}
