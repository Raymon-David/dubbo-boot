package com.raymon.api.utils;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：raymon
 * @date ：Created in 2019/8/29 9:35
 * @description：jedis util
 * @modified By：
 * @version: 1.0$
 */
public class JedisUtil {
    private static final Logger logger = Logger.getLogger(JedisUtil.class);


    /**
     * 私有构造器.
     */
    public JedisUtil() {
    }
    private static Map<String,JedisPool> maps  = new HashMap<String,JedisPool>();

    private static void init(){
        if(PropertiesUtil.getPropertiesValue("redis.host")==null){
            PropertiesUtil.loadFile("redis.properties");
        }
    }

    public static JedisPool getPool(){
        init();
        String ip="";
        int port=0;
        ip = PropertiesUtil.getPropertiesValue("redis.host");
        port=Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.port"));
        return getPool(ip,port);

    }
    public static JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool pool = null;
        //这里为了提供大多数情况下线程池Map里面已经有对应ip的线程池直接返回，提高效率
        if(maps.containsKey(key)){
            pool = maps.get(key);
            return pool;
        }
        //这里的同步代码块防止多个线程同时产生多个相同的ip线程池
        synchronized (JedisUtil.class) {
            if (!maps.containsKey(key)) {
                JedisPoolConfig config = new JedisPoolConfig();

                //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
                config.setBlockWhenExhausted(false);
                //设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
                config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
                //是否启用pool的jmx管理功能, 默认true
                config.setJmxEnabled(true);
                //MBean ObjectName = new ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" + "pool" + i); 默 认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
                config.setJmxNamePrefix("pool");
                //是否启用后进先出, 默认true
                config.setLifo(true);
                //最大空闲连接数, 默认8个
                config.setMaxIdle(Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.maxIdle")));
                //最大连接数, 默认8个   -1不做相关的限制
                config.setMaxTotal(Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.maxTotal")));
                //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
                config.setMaxWaitMillis(Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.maxWaitMillis")));
                //逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
                config.setMinEvictableIdleTimeMillis(1800000);
                //最小空闲连接数, 默认0
                config.setMinIdle(Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.minIdle")));
                //每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
                config.setNumTestsPerEvictionRun(3);
                //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
                config.setSoftMinEvictableIdleTimeMillis(1800000);
                //在获取连接的时候检查有效性, 默认false
                config.setTestOnBorrow(true);
                config.setTestOnReturn(true);
                //在空闲时检查有效性, 默认false
                config.setTestWhileIdle(false);
                //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
                config.setTimeBetweenEvictionRunsMillis(-1);

                try {
                    /**
                     * 如果你遇到 java.net.SocketTimeoutException: Read timed out
                     * exception的异常信息 请尝试在构造JedisPool的时候设置自己的超时值.
                     * JedisPool默认的超时时间是2秒(单位毫秒)
                     */
                    pool = new JedisPool(config, ip, port, 2000);
                    maps.put(key, pool);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage(),e);
                }
            }else {
                pool = maps.get(key);
            }
        }
        return pool;
    }

    /**
     *类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class RedisUtilHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static JedisUtil instance = new JedisUtil();
    }

    /**
     *当getInstance方法第一次被调用的时候，它第一次读取
     *RedisUtilHolder.instance，导致RedisUtilHolder类得到初始化；而这个类在装载并被初始化的时候，会初始化它的静
     *态域，从而创建RedisUtil的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。
     *这个模式的优势在于，getInstance方法并没有被同步，并且只是执行一个域的访问，因此延迟初始化并没有增加任何访问成本。
     */
    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    /**
     * 获取Redis实例.
     * @return Redis工具类实例
     */
    public static Jedis getJedis(String ip, int port) {
        Jedis jedis  = null;
        int count =0;
        try {
            do{
                try{
                    jedis = getPool(ip,port).getResource();
                    //log.info("get redis master1!");
                } catch (Exception e) {
                    logger.error("get redis master1 failed!", e);
                    // 销毁对象
                    getPool(ip,port).returnBrokenResource(jedis);
                }
                count++;
            }while(jedis==null&&count<Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.pool.retryNum")));
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return jedis;
    }


    public static Jedis getJedis() {
        String ip="";
        int port= 0;
        ip = PropertiesUtil.getPropertiesValue("redis.host");
        port=Integer.parseInt(PropertiesUtil.getPropertiesValue("redis.port"));

        return getJedis(ip,port);
    }

    /**
     * 释放redis实例到连接池.
     * @param jedis redis实例
     */
    public void closeJedis(Jedis jedis,String ip,int port) {
        if(jedis != null) {
            getPool(ip,port).returnResource(jedis);
        }
    }
    public static void closeJedis(Jedis jedis) {
        if(jedis != null) {
            getPool().returnResource(jedis);
        }
    }



    /**
     * 向缓存中设置字符串内容
     * @param key key
     * @param value value
     * @return
     * @throws Exception
     */
    public static boolean  set(String key,String value) throws Exception{
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    public static boolean  set(String key,int seconds,String value,String str){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            jedis.setex(key, seconds, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }
    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    public static boolean  set(String key,Object value){
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = getPool().getResource();
            jedis.set(key, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    public static boolean  set(String key,int seconds,Object value){
        Jedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = getPool().getResource();
            jedis.setex(key, seconds, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    /**
     * 删除缓存中得对象，根据key
     * @param key
     * @return
     */
    public static boolean del(String key){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            jedis.del(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }
        finally{
            getPool().returnResource(jedis);
        }
    }

    /**
     * 根据key 获取内容
     * @param key
     * @return
     */
    public static Object get(String key){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            Object value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }


    /**
     * 根据key 获取对象
     * @param key
     * @return
     */
    public static <T> T get(String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            String value = jedis.get(key);
            return JSON.parseObject(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return null;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    //设置锁
    public static boolean setlock(String key){
        Jedis jedis = null;
        int seconds = 300;//默认超时时间
        try {
            String lockkey = "lock.redis."+key;
            long value = System.currentTimeMillis() + seconds + 1;
            jedis = getPool().getResource();
            logger.debug("*******【开始设置redis并发锁】********");
            Long jresult = jedis.setnx(lockkey, String.valueOf(value));
            if(jresult.longValue() == 1){
                logger.debug("*******【redis并发锁设置成功】******");
                jedis.expire(lockkey, seconds);
                return true;
            }
            else{
                if(Long.valueOf(jedis.get(lockkey)) < System.currentTimeMillis()){
                    logger.info("*******【redis并发锁时间到期】******");
                    jedis.del(lockkey);
                }
                logger.error("*******【redis并发锁时间为到期】******");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }
    //删除锁
    public static boolean dellock(String key){
        Jedis jedis = null;
        try {
            String lockkey = "lock.redis."+key;
            jedis = getPool().getResource();
            jedis.del(lockkey);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean  setByte(byte[] key,byte[] value){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    /**
     * 从缓存中获取对象
     * @param key
     * @param
     * @return
     */
    public static Object getByte(byte[] key){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            Object value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }

    public static boolean checkOrder(String OrderNum){
        Jedis jedis = null;
        int seconds = 1;//保证1秒内无重复订单
        try {
            String lockorder = "unique.order."+OrderNum;
            jedis = getPool().getResource();
            Long jresult = jedis.setnx(lockorder, String.valueOf(lockorder));
            if(jresult.longValue() == 1){
                logger.info("*******【order未重复】******"+OrderNum);
                jedis.expire(lockorder, seconds);
                return true;
            }
            else{
                logger.info("*******【order已重复，需要重新生成】******"+OrderNum);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            getPool().returnResource(jedis);
        }

    }

    //设置不存在的redis值，并指定超时时间
    public static boolean setNxAndExpire(String key, String value,int seconds){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            logger.info("*******setNxAndExpire:开始设置：********" + key + ":" + value);
            Long jresult = jedis.setnx(key, String.valueOf(value));
            if(jresult.longValue() == 1){
                logger.debug("*******setNxAndExpire设置成功******");
                jedis.expire(key, seconds);
                return true;
            }
            else{
                logger.info("*******setNxAndExpire设置失败*******");
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
    }


    //设置不存在的redis值，并指定超时时间
    public static Long setnx(String key, String value){
        Jedis jedis = null;
        Long jresult = null;
        try {
            jedis = getPool().getResource();
            jresult = jedis.setnx(key, String.valueOf(value));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }finally{
            getPool().returnResource(jedis);
        }
        return jresult;
    }

    //设置不存在的redis值，并指定超时时间
    public static String getSet(String key, String value){
        Jedis jedis = null;
        String originStr = null;
        try {
            jedis = getPool().getResource();
            originStr = jedis.getSet(key, String.valueOf(value));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }finally{
            getPool().returnResource(jedis);
        }
        return originStr;
    }

    //判断键值是否存在
    public static boolean exists(String key){
        Jedis jedis = null;
        boolean exists= false;
        try {
            jedis = getPool().getResource();
            exists = jedis.exists(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }finally{
            getPool().returnResource(jedis);
        }
        return exists;
    }
}
