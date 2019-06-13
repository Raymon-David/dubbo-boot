package com.raymon.consumer.process.common;

import com.alibaba.fastjson.JSONObject;
import com.raymon.api.bean.ErrorBean;
import com.raymon.api.bean.error.ErrorDesc;
import com.raymon.api.bean.error.ErrorInfo;
import com.raymon.api.constant.StatusCode;
import com.raymon.api.utils.JsonTools;
import com.raymon.api.utils.PatternUtil;
import com.raymon.api.utils.StringUtil;
import com.raymon.api.utils.URLDecoderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Author: raymon
 * Date: 2019/6/13
 * Description:通用process顶级父类
 */
public class BaseProcess implements ICommonProcess {
    private static final Logger log = LoggerFactory.getLogger(BaseProcess.class);
    /**
     * 通用响应客户端方法
     * @param response
     * @param obj
     * @param callback
     */
    @Override
    public void writeClientJson(HttpServletResponse response, Object obj, String callback) {
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            StringBuilder resultJson = new StringBuilder("");
            if(callback != null && !"".equals(callback)) {
                resultJson.append(callback).append('(').append(JSONObject.toJSON(obj).toString()).append(')');
            } else {
                resultJson.append(JSONObject.toJSON(obj).toString());
            }
            pw.write(resultJson.toString());
        } catch (IOException e) {
            log.error("返回客户端json出错:"+JSONObject.toJSON(obj).toString(),e);
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }

    @Override
    public void writeClientText(HttpServletResponse response, String res,
                                String callback) {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            StringBuilder result = new StringBuilder("");
            if(callback != null && !"".equals(callback)) {
                result.append(callback).append('(').append(res).append(')');
            } else {
                result.append(res);
            }
            pw.write(result.toString());
        } catch (IOException e) {
            log.error("返回客户端text出错:"+res,e);
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }

    /**
     * 入口参数验证方法
     */
    @Override
    public ErrorBean validate(ErrorBean error, String json, Map<String, Map<String, String>> validateMap, HttpServletRequest request) {
        ErrorInfo info = new ErrorInfo();
        ErrorDesc desc = new ErrorDesc();
        Enumeration e =request.getHeaders("Referer");
        String referer="";
        if(e.hasMoreElements()){
            referer=(String)e.nextElement();
        }else{
            referer="";
        }
        json = URLDecoderUtil.decode(json, DEFAULT_ENCODE);
        if(StringUtil.isEmpty(json) && validateMap.isEmpty()){
            return error;
        }
        Map<String, Object> resultmap = JsonTools.jsonToMap(json);
        //传过来的参数值为空或参数不符合json规范
        if(null==resultmap|| resultmap.isEmpty()){
            info.setType("" + StatusCode.RequestParamsNotValid.getValue());
            desc.setCode("" + StatusCode.RequestParamsNotValid.getValue());
            desc.setMessage(StatusCode.RequestParamsNotValid.GetDescription());
            info.setErrDesc(desc);
            error.setError(info);
            return error;
        }
        /**
         * 所有参数值验证,验证通过后才可进行参数本身规则验证
         */
        boolean flag = true;
        Set<String> resultKeySet = resultmap.keySet();
        Iterator<String> resultKeyIt = resultKeySet.iterator();
        while(resultKeyIt.hasNext()){
            String key = resultKeyIt.next();
            Object obj = resultmap.get(key);
            /**
             * 登录跳转url不验证
             */
            if(key.equalsIgnoreCase(ICommonProcess.DEFAULT_TO_URL)){
                continue;
            }
            if(obj instanceof String){
                if(((String) obj).equalsIgnoreCase("undefined")){
                    log.info("参数内容包含有undefined注入内容:key="+key+" content="+obj.toString());
                    /**
                     * 参数中有undefined
                     */
                    flag= false;
                    break;
                }
                /**
                 * 参数名和参数值都进行过滤
                 */
                if(!PatternUtil.validateParamByRegex(obj.toString()+key)){
                    log.info("参数内容包含有注入内容:key="+key+" content="+obj.toString());
                    //有不符合的直接终止
                    flag= false;
                    break;
                }
                //不允许出现负数
            }else if(obj instanceof Integer){
                if(((Integer) obj).intValue()<0){
                    log.info("参数不合法出现负数:key="+key+" content="+obj.toString());
                    flag= false;
                    break;
                }
            }else if(obj instanceof Long){
                if(((Long) obj).longValue()<0){
                    log.info("参数不合法出现负数:key="+key+" content="+obj.toString());
                    flag= false;
                    break;
                }
            }else if(obj instanceof Double){
                if(((Double) obj).doubleValue()<0){
                    log.info("参数不合法出现负数:key="+key+" content="+obj.toString());
                    flag= false;
                    break;
                }
            }else if(obj instanceof Float){
                if(((Float) obj).floatValue()<0){
                    log.info("参数不合法出现负数:key="+key+" content="+obj.toString());
                    flag= false;
                    break;
                }
            }
        }
        //参数防注入字符过滤是否成功
        if(!flag){
            info.setType("" + StatusCode.RequestParamsNotValid.getValue());
            desc.setCode("" + StatusCode.RequestParamsNotValid.getValue());
            desc.setMessage(StatusCode.RequestParamsNotValid.GetDescription());
            info.setErrDesc(desc);
            error.setError(info);
            return error;
        }
        Set<String> fieldSet = validateMap.keySet();
        Iterator<String> it = fieldSet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Map<String, String> fieldMap = validateMap.get(key);
            // 指定参数是否可空
            if (fieldMap.get(ICommonProcess.DEFAULT_MUST).equals(	ICommonProcess.DEFAULT_TRUE)) {
                if (!resultmap.containsKey(key)) {
                    log.info("必须参数不存在:key="+key+" "+resultmap);
                    info.setType(""+ fieldMap.get(ICommonProcess.DEFAULT_ERROR));
                    desc.setCode(""+ fieldMap.get(ICommonProcess.DEFAULT_ERROR));
                    desc.setMessage(fieldMap.get(ICommonProcess.DEFAULT_DESC));
                    info.setErrDesc(desc);
                    error.setError(info);
                    return error;
                    // 处理值存在的情况
                } else {
                    // 不符合请返回错误
                    if (!PatternUtil.validateDataByRegex(resultmap.get(key)	.toString(), fieldMap.get(ICommonProcess.DEFAULT_REGEX))) {
                        log.info("不符合数据要求格式:key="+key+" regex="+fieldMap.get(ICommonProcess.DEFAULT_REGEX)+ "  "+resultmap);
                        info.setType(""+ fieldMap.get(ICommonProcess.DEFAULT_ERROR));
                        desc.setCode(""+ fieldMap.get(ICommonProcess.DEFAULT_ERROR));
                        desc.setMessage(fieldMap	.get(ICommonProcess.DEFAULT_DESC));
                        info.setErrDesc(desc);
                        error.setError(info);
                        return error;
                    }
                }
            } else {
                /**
                 * 字段非必须输入,但要保证内容合法性
                 */
                if (resultmap.containsKey(key)) {
                    Object o = resultmap.get(key);
                    // 不符合请返回错误
                    if (null!=o && !"".equals(o.toString()) && !PatternUtil.validateDataByRegex(resultmap.get(key).toString(), fieldMap.get(ICommonProcess.DEFAULT_REGEX))) {
                        log.info("不符合数据要求格式:key="+key+" content="+resultmap.get(key)	.toString()+ " "+resultmap);
                        info.setType(""+ fieldMap.get(ICommonProcess.DEFAULT_ERROR));
                        desc.setCode(""+ fieldMap.get(ICommonProcess.DEFAULT_ERROR));
                        desc.setMessage(fieldMap	.get(ICommonProcess.DEFAULT_DESC));
                        info.setErrDesc(desc);
                        error.setError(info);
                        return error;
                    }
                }
            }
        }
        return error;
    }
}
