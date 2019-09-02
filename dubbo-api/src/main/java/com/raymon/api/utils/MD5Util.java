package com.raymon.api.utils;

import org.apache.log4j.Logger;

import java.security.MessageDigest;

/**
 * @author ：raymon
 * @date ：Created in 2019/8/30 14:57
 * @description：MD5Util
 * @modified By：
 * @version: 1.0$
 */
public class MD5Util {
    private static final Logger logger = Logger.getLogger(MD5Util.class);

    public final static char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    /**
     * 生成MD5加密信息
     * @Title: getMD5Str
     * @Description: TODO
     * @param @param encryptStr  ：加密原信息
     * @return String    加密后信息
     */
    public static String getMD5Str(String encryptStr) {

        try {
            byte[] btInput = encryptStr.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return null;
        }
    }
    /**
     * 生成MD5加密信息
     * @Title: getMD5Str
     * @Description: TODO
     * @param @param encryptStr  ：加密原信息
     * @return String    加密后信息
     */
    public static String getMD5Str(String encryptStr, String key) {

        return getMD5Str(encryptStr+key);
    }


    /**
     * MD5验证
     * @Title: validate
     * @Description: TODO
     * @param @param encryptStr ：待验证信息
     * @param @param StrMD5   ：原MD5信息
     * @return boolean      是否相同
     */
    public static boolean validate(String encryptStr, String StrMD5) {

        String newMD5Str = MD5Util.getMD5Str(encryptStr);
        return newMD5Str.equals(StrMD5);

    }
}
