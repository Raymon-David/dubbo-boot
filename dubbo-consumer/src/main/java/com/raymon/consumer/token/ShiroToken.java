package com.raymon.consumer.token;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class ShiroToken extends UsernamePasswordToken implements Serializable{

    private static final Logger log =  LoggerFactory.getLogger(ShiroToken.class);
    private static final long serialVersionUID = -6451794657814516274L;

    public ShiroToken(String username, String pswd) {
        super(username,pswd);
        this.pswd = pswd ;
    }


    /** 登录密码[字符串类型] 因为父类是char[] ] **/
    private String pswd ;

    public String getPswd() {
        return pswd;
    }


    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
