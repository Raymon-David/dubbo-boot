package com.raymon.consumer.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransMoneyController implements Runnable {

    //驱动程序就是之前在 classpath中配置的jdbc的驱动程序jar中
    static String drive = "oracle.jdbc.driver.OracleDriver" ;
    /**
     * 连接地址，各个厂商提供单独记住
     * jdbc:oracle:thin: @10.40.61.39:1521:iBiz localhost 是ip地址。
     */
    static String url = "jdbc:oracle:thin:@10.40.61.39:1521:iBiz" ;

    /**
     * 用户 密码
     */
    static String dbuser= "dcfl";
    static String password= "dcfl123";

    static Connection conn = null;//表示数据库连接
    static Statement stmt= null;//表示数据库的更新
    static ResultSet result = null;//查询数据库

    public static void main(String args[]){
        Thread t = new Thread(new TransMoneyController());
        t.start();
    }

    public void run() {
        try {
            //selectTransMoney
            List<Map<String, Object>> ll = selectTransMoney();

            for (int i = 0; i < ll.size(); i++) {
                String cntrt_no = ll.get(i).get("cntrt_no").toString();
                String uarv_amt = ll.get(i).get("uarv_amt").toString();
                String req_ymd = ll.get(i).get("req_ymd").toString();

                System.out.println("cntrt_no :" + cntrt_no);
                System.out.println("uarv_amt :" + uarv_amt);
                System.out.println("req_ymd :" + req_ymd);
                System.out.println("i :" + i);

                int j = insertBdm1101t(cntrt_no, uarv_amt, req_ymd);
                if (j != 0) {
                    System.out.println("'" + cntrt_no + "'转让金生成成功");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Map<String, Object>> selectTransMoney(){
        List li = new ArrayList();
        try{
            Class.forName(drive);//使用class类来加载程序
            conn = DriverManager.getConnection(url,dbuser,password); //连接数据库
            //Statement接口要通过connection接口来进行实例化操作
            stmt = conn.createStatement();
            //执行SQL语句来查询数据库
            result =stmt.executeQuery("select a.cntrt_no,\n" +
                    "\t\t   max(a.UARV_PAY_AMT2) as UARV_PAY_AMT2,\n" +
                    "\t\t\t max(b.REQ_GB) as REQ_GB,\n" +
                    "\t\t\t max(b.REPAY_CNT) as REPAY_CNT,\n" +
                    "\t\t\t max(b.REQ_YMD) as REQ_YMD\n" +
                    "from bex1000t a left join bdm1101t b\n" +
                    "on a.cntrt_no = b.cntrt_no\n" +
                    "and a.ext_cnt = b.ext_cnt\n" +
                    "where a.status = '5'\n" +
                    "and a.ext_cnt = '0001'" +
//                    "and a.cntrt_no in('218EX305740') \n" +
                    "group by a.cntrt_no\n" +
                    "having max(b.REPAY_CNT) != '900'" +
                    "");

            while(result.next()){//判断有没有下一行
                String cntrt_no = result.getString(1);
                String uarv_amt = result.getString(2);
                String req_ymd = result.getString(5);

                Map<String,Object> mp1 = new HashMap();
                mp1.put( "cntrt_no", cntrt_no);
                mp1.put( "uarv_amt", uarv_amt);
                mp1.put( "req_ymd", req_ymd);

                li.add(mp1);
            }
            result.close(); //数据库先开后关
            stmt.close();
            conn.close(); //关闭数据库
        }catch (Exception e){

        }
        return li;
    }

    public static int insertBdm1101t(String cntrt_no, String uarv_amt, String req_ymd){

        int result = 0;
        try{
            Class.forName(drive).newInstance();//使用class类来加载程序
            conn = DriverManager. getConnection(url,dbuser,password); //连接数据库
            //Statement接口要通过connection接口来进行实例化操作
            stmt = conn.createStatement();
            //执行SQL语句来查询数据库
            String sql = null;
            sql = new String("INSERT INTO BDM1101T (FIRM_CD,\n" +
                    "                      CNTRT_NO,\n" +
                    "                      EXT_CNT,\n" +
                    "                      REQ_GB,\n" +
                    "                      REQ_YMD,\n" +
                    "                      REPAY_CNT,\n" +
                    "                      REAL_PAY_YMD,\n" +
                    "                      CRE_GB,\n" +
                    "                      DLY_RAT_CD,\n" +
                    "                      CAP_REPAY_AMT,\n" +
                    "                      INT_CALC_AMT,\n" +
                    "                      STD_RAT,\n" +
                    "                      ADST_RAT,\n" +
                    "                      BSC_RAT_INT,\n" +
                    "                      REAL_STD_RAT,\n" +
                    "                      R_INT_RAT_INT,\n" +
                    "                      REQ_WON,\n" +
                    "                      REQ_INT,\n" +
                    "                      VAT,\n" +
                    "                      REQ_TOT,\n" +
                    "                      CAP_DLY_JAMT,\n" +
                    "                      INT_DLY_JAMT,\n" +
                    "                      VAT_DLY_JAMT,\n" +
                    "                      DLY_AMT_TOT,\n" +
                    "                      UNT_PRC_YN,\n" +
                    "                      DLY_CALC_YN,\n" +
                    "                      ASSU_SETOFF_YN,\n" +
                    "                      TAX_ISSUE_YN,\n" +
                    "                      CMS_REQ_YN,\n" +
                    "                      REQ_ISS_CNT,\n" +
                    "                      REQ_STTS,\n" +
                    "                      REMARK,\n" +
                    "                      INS_EMPNO,\n" +
                    "                      INS_DT)\n" +
                    "     VALUES ('A01',\n" +
                    "   		  '"+cntrt_no+"',\n" +
                    "             '0001',\n" +
                    "             'C02010',\n" +
                    "   		  '"+req_ymd+"',\n" +
                    "             '900',\n" +
                    "   		  '"+req_ymd+"',\n" +
                    "             'G',\n" +
                    "             'B54703',\n" +
                    "   		  '"+uarv_amt+"',\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "   		  '"+uarv_amt+"',\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "   		  '"+uarv_amt+"',\n" +
                    "   		  '"+uarv_amt+"',\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "   		  '"+uarv_amt+"',\n" +
                    "             'N',\n" +
                    "             'Y',\n" +
                    "             'N',\n" +
                    "             'N',\n" +
                    "             'N',\n" +
                    "             0,\n" +
                    "             0,\n" +
                    "             '转让金',\n" +
                    "             '9002',\n" +
                    "             SYSDATE)\n" +
                    "");

            System.out.println("insrt sql :" + sql);
            result =stmt.executeUpdate(sql);
            stmt.close();
            conn.close(); //关闭数据库
        }catch (Exception e){

        }
        return result;
    }

}
