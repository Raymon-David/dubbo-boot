package com.raymon.consumer.process.common;

import com.raymon.api.constant.StatusCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: raymon
 * Date: 2019/6/13
 * Description:通用验证库   多个正则时，需要用;;双分号隔开
 */
public class CommonValidateMap {

    private static Map<String, Map<String, String>> validateMap = new ConcurrentHashMap<String, Map<String, String>>();
    static{
        /**
         * 手机号码验证
         */
        Map<String, String> mobileMap = new HashMap<String, String>();
        mobileMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        mobileMap.put(ICommonProcess.DEFAULT_REGEX,"^((13[0-9])|(14[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
        mobileMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.PhoneModelError.getValue());
        mobileMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.PhoneModelError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_MOBILE, mobileMap);

        /**
         * 登录密码验证
         */
        Map<String, String> loginpwdMap = new HashMap<String, String>();
        loginpwdMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        loginpwdMap.put(ICommonProcess.DEFAULT_REGEX,".*?[A-Za-z]+.*?;;.*?[0-9]+.*?;;^[a-z_A-Z0-9]{8,20}$");
        loginpwdMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserOrPwdError.getValue());
        loginpwdMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserOrPwdError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_LOGINPWD, loginpwdMap);

        /**
         * 新登录密码验证
         */
        Map<String, String> newloginpwdMap = new HashMap<String, String>();
        newloginpwdMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        newloginpwdMap.put(ICommonProcess.DEFAULT_REGEX,".*?[A-Za-z]+.*?;;.*?[0-9]+.*?;;^[a-z_A-Z0-9]{8,20}$");
        newloginpwdMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserOrPwdError.getValue());
        newloginpwdMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserOrPwdError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_NEWPASSWORD, newloginpwdMap);

        /**
         * 确认登录密码验证
         */
        Map<String, String> reloginpwdMap = new HashMap<String, String>();
        reloginpwdMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        reloginpwdMap.put(ICommonProcess.DEFAULT_REGEX,".*?[A-Za-z]+.*?;;.*?[0-9]+.*?;;^[a-z_A-Z0-9]{8,20}$");
        reloginpwdMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserOrPwdError.getValue());
        reloginpwdMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserOrPwdError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_REPASSWORD, reloginpwdMap);

        /**
         * 邮箱验证
         */
        Map<String, String> emailMap = new HashMap<String, String>();
        emailMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_FALSE);
        emailMap.put(ICommonProcess.DEFAULT_REGEX,"^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        emailMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.EmailValid.getValue());
        emailMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.EmailValid.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_EMAIL, emailMap);

        /**
         * 支付密码验证
         */
        Map<String, String> paypwdMap = new HashMap<String, String>();
        paypwdMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        paypwdMap.put(ICommonProcess.DEFAULT_REGEX,"^[0-9]{6}$");
        paypwdMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserPayPasswordVaildateFailure.getValue());
        paypwdMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserPayPasswordVaildateFailure.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_PAYPWD, paypwdMap);

        /**
         * 支付新确认密码验证
         */
        Map<String, String> newpaypwdMap = new HashMap<String, String>();
        newpaypwdMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        newpaypwdMap.put(ICommonProcess.DEFAULT_REGEX,"^[0-9]{6}$");
        newpaypwdMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserPayPasswordVaildateFailure.getValue());
        newpaypwdMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserPayPasswordVaildateFailure.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_NEWPAYPWD, newpaypwdMap);

        /**
         * 支付新密码验证
         */
        Map<String, String> repaypwdMap = new HashMap<String, String>();
        repaypwdMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        repaypwdMap.put(ICommonProcess.DEFAULT_REGEX,"^[0-9]{6}$");
        repaypwdMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserPayPasswordVaildateFailure.getValue());
        repaypwdMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserPayPasswordVaildateFailure.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_REPAYPWD, repaypwdMap);

        /**
         * 图片验证码
         */
        Map<String, String> mobileCodeMap = new HashMap<String, String>();
        mobileCodeMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_FALSE);
        mobileCodeMap.put(ICommonProcess.DEFAULT_REGEX,"^[a-zA-Z0-9]{6}$");
        mobileCodeMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.VerifyCodeError.getValue());
        mobileCodeMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.VerifyCodeError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_MOBILECODE, mobileCodeMap);

        /**
         * 短信验证码
         */
        Map<String, String> chkCodeMap = new HashMap<String, String>();
        chkCodeMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        chkCodeMap.put(ICommonProcess.DEFAULT_REGEX,"^[0-9]{6}$");
        chkCodeMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.VerifyCodeError.getValue());
        chkCodeMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.VerifyCodeError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_CHKCODE, chkCodeMap);

        /**
         *身份证验证
         */
        Map<String, String> idcardMap = new HashMap<String, String>();
        idcardMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        idcardMap.put(ICommonProcess.DEFAULT_REGEX,"^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$;;^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$");
        idcardMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.IdCardVerifyFail.getValue());
        idcardMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.IdCardVerifyFail.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_IDCARD, idcardMap);

        /**
         *克重验证 保留3位小数
         */
        Map<String, String> gramMap = new HashMap<String, String>();
        gramMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        gramMap.put(ICommonProcess.DEFAULT_REGEX,"^([1-9]\\d*\\.?\\d*)|([0]\\.\\d{1,3})$");
        gramMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.GramIsError.getValue());
        gramMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.GramIsError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_GRAM, gramMap);

        /**
         *金额验证保留2位小数
         */
        Map<String, String> amountMap = new HashMap<String, String>();
        amountMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        amountMap.put(ICommonProcess.DEFAULT_REGEX,"^([1-9]\\d*\\.?\\d*)|([0]\\.\\d{1,2})$");
        amountMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.AmountError.getValue());
        amountMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.AmountError.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_AMOUNT, amountMap);

        /**
         *用户类型
         */
        Map<String, String> userTypeMap = new HashMap<String, String>();
        userTypeMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        userTypeMap.put(ICommonProcess.DEFAULT_REGEX,"^((0[1-2]){1})$");
        userTypeMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserTypeIsEmpty.getValue());
        userTypeMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserTypeIsEmpty.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_USER_TYPE, userTypeMap);

        /**
         *登录类型
         */
        Map<String, String> typeMap = new HashMap<String, String>();
        typeMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        typeMap.put(ICommonProcess.DEFAULT_REGEX,"^(([1-2]){1})$");
        typeMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserTypeIsEmpty.getValue());
        typeMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserTypeIsEmpty.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_USER_LOGIN_TYPE, typeMap);

        /**
         *用户名
         */
        Map<String, String> usernameMap = new HashMap<String, String>();
        usernameMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        usernameMap.put(ICommonProcess.DEFAULT_REGEX,"^((13[0-9])|(14[0-9])|(17[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$||^(([0-9]){19})$");
        usernameMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserAccountNotExit.getValue());
        usernameMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserAccountNotExit.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_USER_NAME, usernameMap);

        /**
         *
         */
        /**
         *登录类型
         */
        Map<String, String> busTypeMap = new HashMap<String, String>();
        busTypeMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        busTypeMap.put(ICommonProcess.DEFAULT_REGEX,"^(([1-4]){1})$");
        busTypeMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.UserTypeIsEmpty.getValue());
        busTypeMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.UserTypeIsEmpty.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_BIZ_TYPE, busTypeMap);

        /**
         * 周期
         */
        Map<String, String> cycleMap = new HashMap<String, String>();
        cycleMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        cycleMap.put(ICommonProcess.DEFAULT_REGEX,"^[1-9]{1}[0-9]{0,3}$");
        cycleMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.RequestParamsNotValid.getValue());
        cycleMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.RequestParamsNotValid.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_CYCLE, cycleMap);


        /**
         *订单编号
         */
        Map<String, String> orderMap = new HashMap<String, String>();
        orderMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        orderMap.put(ICommonProcess.DEFAULT_REGEX,"^(([0-9]){15,19})$");
        orderMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.OrderIsNotExists.getValue());
        orderMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.OrderIsNotExists.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_ORDER_NO, orderMap);

        /**
         *企业电话
         */
        Map<String, String> comPhoneMap = new HashMap<String, String>();
        comPhoneMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        comPhoneMap.put(ICommonProcess.DEFAULT_REGEX,"^(\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$");
        comPhoneMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.ComUserPhoneInfoFail.getValue());
        comPhoneMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.ComUserPhoneInfoFail.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_COMPANY_PHONE, comPhoneMap);

        /**
         *公司紧急联系人电话
         */
        Map<String, String> comEmerPhoneMap = new HashMap<String, String>();
        comEmerPhoneMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        comEmerPhoneMap.put(ICommonProcess.DEFAULT_REGEX,"^(\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$");
        comEmerPhoneMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.ComEmerPhoneInfoFail.getValue());
        comEmerPhoneMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.ComEmerPhoneInfoFail.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_COMPANY_EMER_PHONE, comEmerPhoneMap);

        /**
         * 营业执照号
         */
        Map<String, String> busiLicenseMap = new HashMap<String, String>();
        busiLicenseMap.put(ICommonProcess.DEFAULT_MUST, ICommonProcess.DEFAULT_TRUE);
        busiLicenseMap.put(ICommonProcess.DEFAULT_REGEX,"^(\\d{15})$");
        busiLicenseMap.put(ICommonProcess.DEFAULT_ERROR,"" + StatusCode.BusiLicenseFail.getValue());
        busiLicenseMap.put(ICommonProcess.DEFAULT_DESC,	"" + StatusCode.BusiLicenseFail.GetDescription());
        validateMap.put(ICommonProcess.DEFAULT_COMPANY_BUSIlICENSE, busiLicenseMap);

    }
    public static Map<String, String> getValueByKey(String key){
        return validateMap.get(key);
    }
}
