package com.raymon.api.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author ：raymon
 * @date ：Created in 2019/8/29 10:58
 * @description：PropertiesUtil
 * @modified By：
 * @version: 1.0$
 */
public class PropertiesUtil {
    public static Map<String, String> loadPropertiesMap = new HashMap<String, String>();

    private static final Log log = LogFactory.getLog(PropertiesUtil.class);
    public static void loadFile(String filePath) {

        if (null == filePath || "".equals(filePath.trim())) {
            log.info("The file path is null,return");
            return;
        }
        filePath = filePath.trim();
        // 获取资源文件
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath);
        // 属性列表
        Properties prop = new Properties();
        try {
            // 从输入流中读取属性列表
            prop.load(is);
        } catch (IOException e) {
            log.info("load file faile." + e);
            return;
        } catch (Exception e) {
            log.info("load file faile." + e);
            return;
        }

        // 返回Properties中包含的key-value的Set视图
        Set<Map.Entry<Object, Object>> set = prop.entrySet();
        // 返回在此Set中的元素上进行迭代的迭代器
        Iterator<Map.Entry<Object, Object>> it = set.iterator();
        String key = null, value = null;
        // 循环取出key-value
        while (it.hasNext()) {

            Map.Entry<Object, Object> entry = it.next();

            key = String.valueOf(entry.getKey());
            value = String.valueOf(entry.getValue());

            key = key == null ? key : key.trim();
            value = value == null ? value : value.trim();
            // 将key-value放入map中
            loadPropertiesMap.put(key, value);
        }
    }

    public static String getPropertiesValue(String key){
        return loadPropertiesMap.get(key);
    }
    /**
     * 返回对应的
     *
     * @param strKey
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getValByKey(String strKey) {
        String value = null;
        try {
            value = JedisUtil.get(strKey, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
        return value;
    }
}
