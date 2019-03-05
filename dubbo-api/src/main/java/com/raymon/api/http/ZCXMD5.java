package com.raymon.api.http;

import com.alibaba.fastjson.JSONObject;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by weiguo.zhang on 2017/6/23.
 */
public class ZCXMD5 {
    public static void main(String[] args) {
        try {
            String sy = "0c95ab2ec86a4a018f77eb56d7ed26e7";
            String account = URLEncoder.encode("DCFL0011", "utf-8");
            String custIdNumber = "341281198712082521";
            String custNm = "路三妮";
            //生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(("account" + account + "cid" + custIdNumber + "name" + custNm + sy).getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){
                    i += 256;
                }

                if (i < 16){
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }
            //32位加密
            String aa = buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);


            //String sinStr = new BigInteger(1, md.digest()).toString(16);
            String sign = URLEncoder.encode(aa.toUpperCase(), "utf-8");


            //测试119.254.66.247   正式119.254.66.233  端口不变
            String url = "http://119.254.66.233:8085/data-service/identity/auth?account=" + account;
            url = url + "&cid=" + custIdNumber;
            url = url + "&name=" + URLEncoder.encode(custNm,"UTF-8");
            url = url + "&sign=" + sign;


            URL uri = new URL(url);
            System.out.println(uri);
//            URLConnection URLconnection = uri.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) uri.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);
            httpConnection.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("accept", "*/*");
            httpConnection.setRequestProperty("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
            httpConnection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
            httpConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
            httpConnection.setRequestProperty("connection", "Keep-Alive");
            httpConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            if ("GET".equalsIgnoreCase("GET")) {
                httpConnection.connect();
            }

            int responseCode = httpConnection.getResponseCode();
            System.out.println("responseCode is : " + responseCode);
            System.out.println("responseMessage is : " + httpConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "utf-8");
                BufferedReader bufr = new BufferedReader(isr);
                String str = null;
                while ((str = bufr.readLine()) != null) {

                    JSONObject resJSON = JSONObject.parseObject(str);
                    String resMsg = resJSON.getString("resCode");
                    JSONObject resultdata = new JSONObject();
                    if (resMsg.equals("2010")) {
                        resultdata.put("result", "一致");
                    } else {
                        resultdata.put("result", "不一致");
                    }
                    System.out.println(str);
                }
                bufr.close();
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}