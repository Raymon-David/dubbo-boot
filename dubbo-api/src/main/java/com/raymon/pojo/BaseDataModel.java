package com.raymon.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class BaseDataModel extends BaseModel implements Serializable {
    protected Long id; // 主键 id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected Long creator; // 创建者id
    protected Long updater; // 修改者id

    protected Timestamp createtime; // 创建时间
    protected Timestamp updatetime; // 更改时间


    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
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


    /**
     * 插入之前执行方法，需要手动调用
     */

    public void preInsert(){
//		User user = UserUtils.getUser();
//		if (user.getId()!=null){
//			this.updater = user.getId();
//			this.creator= user.getId();
//		}
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        this.createtime = nousedate;
        this.updatetime = this.createtime;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */

    public void preUpdate(){
        //User user = UserUtils.getUser();
//		if (StringUtils.isNotBlank(user.getId())){
//			this.updateBy = user;
//		}
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        this.updatetime =nousedate;
    }
}
