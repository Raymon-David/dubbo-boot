package com.raymon.api.core.shiro.cache.impl;

import com.foryou.core.shiro.cache.JedisManager;
import com.foryou.core.shiro.cache.JedisShiroCache;
import com.foryou.core.shiro.cache.ShiroCacheManager;
import org.apache.shiro.cache.Cache;

/**
 * 
 * 开发公司：foryou在线工具 <p>
 * 版权所有：© www.foryou.com<p>
 * 博客地址：http://www.foryou.com/blog/  <p>
 * <p>
 * 
 * JRedis管理
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@foryou.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
