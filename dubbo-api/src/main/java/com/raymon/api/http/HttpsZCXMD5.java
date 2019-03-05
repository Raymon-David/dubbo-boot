package com.raymon.api.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsZCXMD5 extends DefaultHttpClient{

    public static void main(String args[]){

        try{
            String sy = "0c95ab2ec86a4a018f77eb56d7ed26e7";
            String account = URLEncoder.encode("DCFL0011", "utf-8");
            String custIdNumber = "152728198612023613";
            String custNm = "袭利惠";
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
            String url = "https://api.ccxcredit.com/data-service/identity/auth?account=" + account;
            url = url + "&cid=" + custIdNumber;
            url = url + "&name=" + URLEncoder.encode(custNm,"UTF-8");
            url = url + "&sign=" + sign;

            System.out.println("url is : " + url);
            String httpOrgCreateTestRtn = doPost(url, "utf-8");
            System.out.println(httpOrgCreateTestRtn);

        }catch (Exception e){

        }
    }

    /**
     * 利用HttpClient进行post请求的工具类
     * @ClassName: HttpClientUtil
     * @Description: TODO
     *
     */
    public static String doPost(String url, String charset){
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try{
            httpClient = new DefaultHttpClient();
            //信任所有主机-对于任何证书都不做检查
            X509TrustManager tm = new X509TrustManager() {
                // 不作任何校验
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                // 不作任何校验
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                // 返回null
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[] { tm }, null);
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            org.apache.http.conn.ssl.SSLSocketFactory socketFactory = new org.apache.http.conn.ssl.SSLSocketFactory(sslcontext);
            //关闭host验证，允许和所有的host建立SSL通信
            socketFactory.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            Scheme sch = new Scheme("https", 443, socketFactory);
            httpClient.getConnectionManager().getSchemeRegistry().register(sch);

            httpGet = new HttpGet(url);
            httpGet.addHeader("Content-Type", "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            //关闭请求
            httpClient.getConnectionManager().shutdown();
        }
        return result;
    }

}
