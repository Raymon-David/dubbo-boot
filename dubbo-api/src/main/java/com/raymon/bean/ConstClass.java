package com.raymon.bean;

public class ConstClass {
    // 程序代码控制的渠道类型－－微信
    public static final String CHANNEL_WEIXIN = "22";
    // 程序代码控制的渠道类型－－IOS
    public static final String CHANNEL_IOS = "21";
    // 程序代码控制的渠道类型－－Android
    public static final String CHANNEL_ANDROID = "23";
    // 程序代码控制的渠道类型－－WAP
    public static final String CHANNEL_WAP = "24";
    // 程序代码控制的渠道类型－－前端web
    public static final String CHANNEL_FWEB = "01";
    // 程序代码控制的渠道类型－－后端web
    public static final String CHANNEL_OWEB = "02";
    //柜员系统渠道
    public static final String CHANNEL_COUNTER = "02";
    //客服系统渠道
    public static final String CHANNEL_SERVICE = "02";
    // 线上
    public static final String CHANNEL_ONLINE = "1";
    // 线下
    public static final String CHANNEL_OFFLINE = "0";
    // 11-线下收银台（渠道不再区分金力多边，使用商户号区分）；
    public static final String CHANNEL_BELOWLIN = "11";
    // 存金戴业务系统
    public static final String CHANNEL_DESPOSIT = "12";
    /**
     * 渠道code，黄金币在线支付
     */
    public final static String DEFAULT_CHANNEL_CODE="31";
    // 分隔符
    public static final String SEP_DX = "_";
    public static final String SEP_DOT = ".";
    public static final String SEP_SEMICOLON = ";";
    // 支付方式分隔符
    public static final String SEP_PAYTYPE = "#";
    public static final String SEP_PAYSUM = ":";
    public static final String SEPARATOR_SYSTEMSOURCEID_BIZID_NEW = "@@"; // 系统源ID+业务订单号分隔符(最新)

    // 封闭式理财产品类型
    public static final String LC_PRD_TYPE_CLOSE = "0";
    // 开放式理财产品类型
    public static final String LC_PRD_TYPE_OPEN = "1";

    // 配置验证码常量
    public static final String VERCODE = "vercode";
    // 配置用户Session 对象信息
    public static final String SESSION_USER = "multi_gold_session_user";
    public static final String SESSION_PHONE = "multi_gold_session_phone";
    public static final String SESSION_LOGIN = "multi_gold_session_login";

    // 空字符串
    public static final String BLANK_STRING = "";

    // xml与bean之间转换的类型
    public static final String XMLTOBEAN = "1";
    public static final String BEANTOXML = "0";

    // 是否有效 针对大部分表的有效状态
    public static final String ACTIVE_STATUS = "1";
    public static final String INACTIVE_STATUS = "0";

    public static final String USER_FLAG_Y = "Y";
    public static final String USER_FLAG_N = "N";

    // 是否有效 针对大部分表的有效状态
    public static final String STRING_ONE = "1";
    public static final String STRING_ZERO = "0";

    public static final String USERTYPE_USER = "01";
    public static final String USERTYPE_COMMERCIA = "02";
    public static final String USERTYPE_PLAT = "08";

    public static final String GM_Login_SecTyep = "03";

    public static final String CLIENT_TYPE_PERSON = "1";
    public static final String CLIENT_TYPE_COMMERCIA = "2";
    public static final String CLIENT_TYPE_PLAT = "8";
    // 会员状态
    public static final int MEMBER_STATUS_INIT = 0;// 初始状态
    public static final int MEMBER_STATUS_LIVE = 1;// 活动状态
    public static final int MEMBER_STATUS_LOCK = 2;// 锁定状态
    public static final int MEMBER_STATUS_DELETE = 3;// 删除状态
    public static final int MEMBER_STATUS_LOCK_2HOUR = 4;// 校验密码失败，锁定2小时

    // 提现状态
    public static final Integer DRAW_WAIT = 0;// 待审
    public static final Integer DRAW_SUCCESS = 1;// 等待财务审核
    public static final Integer DRAW_FAILURE = 2;// 驳回

    // 提金单据状态
    public static final String DRAWGOLD_0 = "0";// 未支付
    public static final String DRAWGOLD_1 = "1";// 已支付
    public static final String DRAWGOLD_2 = "2";// 已发货
    public static final String DRAWGOLD_3 = "3";// 异常
    public static final String DRAWGOLD_4 = "4";// 撤回

    //理财金解约状态
    public static final String RELEASE_STATUS_0 = "0";//待审核
    public static final String RELEASE_STATUS_1 = "1";//一审通过
    public static final String RELEASE_STATUS_2 = "2";//解约中
    public static final String RELEASE_STATUS_3 = "3";//拒绝
    public static final String RELEASE_STATUS_4 = "4";//成功
    public static final String RELEASE_STATUS_5 = "5";//失败

    // 贷款状态
    public static final String POLOAN_0 = "0";//待审
    public static final String POLOAN_1 = "1";//一审通过
    public static final String POLOAN_2 = "2";//放款中
    public static final String POLOAN_3 = "3";//拒绝
    public static final String POLOAN_4 = "4";//放款成功

    public static final String POLOAN_9 = "9";//初始
    public static final String POLOAN_10 = "10";//申请失败
    public static final String POLOAN_11 = "11";//异常

    //限额限次更新规则
    public static final String limit_person = "per";
    public static final String limit_product = "pro";
    public static final String limit_both = "both";

    // 订单状态
    public static final Integer ORDER_STATUS_NORMAL = 0;// 正常
    public static final Integer ORDER_STATUS_SYS_CANCEL = 1;// 取消
    public static final Integer ORDER_STATUS_DIY_CANCEL = 2;// 人工取消
    public static final Integer ORDER_INVALID = 3;// 失效
    // public static final Integer order_failed = 4;//失败

    // 订单类型
    public static final String ORDER_TYPE_MULTIGOLDCASHIER = "0001";// 多边收银台
    public static final String ORDER_TYPE_DEPOSITGOLD = "0002";// 存金戴

    // 业务编码
    public static final String BIZ_CODE_CURRENT = "FM001";// 活期存金
    public static final String BIZ_CODE_TERM = "FM015";// 定期存金
    public static final String BIZ_CODE_MVALUE = "HD001";// 保值存金
    public static final String BIZ_CODE_CURRENT2TERM = "FM002";// 活转定
    public static final String BIZ_CODE_TERM2CURRENT = "FM003";// 定转活

    public static final String BIZ_CODE_WITHDRAW_APPLY ="FM010"; //提现申请
    public static final String BIZ_CODE_WITHDRAW = "FM011";// 现金账户提现成功
    public static final String BIZ_CODE_WITHDRAW_REFUSED ="FM402";  //提现拒绝
    public static final String BIZ_CODE_WITHDRAW_RETURN_ACCOUNT ="FM403";  //返回客户账户
    public static final String BIZ_CODE_WITHDRAW_BY_HAND = "FM013";  //手工打款
    public static final String BIZ_CODE_BUSWITHDRAW_BY_HAND = "FM012";  //企业客户提现手工打款


    public static final String BIZ_CODE_SELL_GOLD_CURRENT = "FM004";// 活期账户卖金
    public static final String BIZ_CODE_SELL_GOLD_PROTECT = "HD002";// 保值账户卖金
    public static final String BIZ_CODE_CJD = "FM006";// 存金戴
    public static final String BIZ_CODE_INTEGRAL2Gold = "FM014";// 金豆兑换黄金
    public static final String BIZ_CODE_GOLDCARDBUYUNDO = "FM408";// 黄金购物撤销
    public static final String BIZ_CODE_UNIONCARD = "FM028";// 银行卡鉴权
    public static final String BIZ_CODE_UNIONCARD_YB = "FM029";// 银行卡易宝鉴权
    public static final String BIZ_CODE_UNIONCARD_CONFIRM_YB = "FM030";// 银行卡易宝鉴权确认
    public static final String BIZ_CODE_UNIONCARD_UNBIND_YB = "FM031"; //银行卡易宝解绑
    public static final String BIZ_CODE_UNIONCARD_REPAIR_YB = "FM032"; //银行卡易宝补偿

    public static final String BIZ_CODE_CONSUMPTION = "FM008";// 消费（黄金购物）
    public static final String BIZ_CODE_RNTGOODS = "FM009";// 黄金退货
    public static final String BIZ_CODE_LOANREPAYMENT = "CL004";// 贷款还款
    public static final String BIZ_CODE_LOANPASS = "CL002";// 贷款放款
    public static final String BIZ_CODE_LOANAPPLY= "CL001";// 贷款申请
    public static final String BIZ_CODE_LOANREFUSE = "CL401";//贷款拒绝
    public static final String BIZ_CODE_LOANFIRPASS = "CL005";//贷款一审通过

    public static final String BIZ_CODE_LCGOLD = "FM017";// 普通理财金
    public static final String BIZ_CODE_LCGOLD_NO_RISK = "FM020";// 保值理财金

    public static final String BIZ_CODE_FULL_GIVE = "CX002";// 满赠
    public static final String BIZ_CODE_FULL_GIVE_HB = "CX003";// 红包满赠
    public static final String BIZ_CODE_HB_LC = "CX006";// 红包理财
    public static final String BIZ_CODE_HB_LC_BZ = "CX007";// 红包保值理财

    public static final String BIZ_CODE_CASH_RECHARGE = "CZ001";// 现金充值
    public static final String BIZ_CODE_CASH_RECHARGE_CORRECT = "CZ401"; //充值冲正
    public static final String BIZ_CODE_CASH_RECHARGE_CONFIRM = "CZ201"; //充值确认


    public static final String BIZ_CODE_SELL_GOLD_CURRENT_CORRECT ="FM401";  //积存金冲正
    public static final String BIZ_CODE_SELL_GOLD_CURRENT_CONFIRM ="FM201";  //积存金确认

    public static final String BIZ_CODE_SELL_GOLD_CONSUMPTION_CORRECT ="FM408";  //消费冲正
    public static final String BIZ_CODE_SELL_GOLD_CONSUMPTION_CONFIRM ="FM208";  //消费确认

    public static final String BIZ_CODE_TERM_CORRECT ="FM415";  //金生金冲正
    public static final String BIZ_CODE_TERM_CONFIRM ="FM215";  //金生金确认

    public static final String BIZ_CODE_LCGOLD_CORRECT ="FM417";  //普通理财金冲正
    public static final String BIZ_CODE_LCGOLD_CONFIRM ="FM217";  //普通理财金确认

    public static final String BIZ_CODE_LCGOLD_NO_RISK_CORRECT ="FM420";  //保值理财金冲正
    public static final String BIZ_CODE_LCGOLD_NO_RISK_CONFIRM ="FM220";  //保值理财金确认

    public static final String BIZ_CODE_CURRENT_TO_LCGOLD ="FM024";  //积存金买普通理财金
    public static final String BIZ_CODE_CURRENT_TO_LCGOLD_NO_RISK ="FM025";  //积存金买保值理财金



    /**
     * 2015-07-26 范吉锋调整订单的支付状态 参与者 于树圣 李京京 李博伟 订单状态暂时作废，后期使用在进行相关的调整
     */
    // 订单支付状态
    public static final int PAY_NO = 0;// 未支付
    public static final int PAY_PART = 1;// 部分支付（线下收银台）
    public static final int PAY_ALL = 2;// 全额支付（线下收银）
    public static final int PAY_ERROR = 3;// 已失败（OLTP处理失败、线上支付失败）
    public static final int PAY_SUCCESS = 4;// 已成功（OLTP返回成功）
    public static final int PAY_ACC_ERROR = 5;// 入账失败（账户入账失败）
    public static final int PAY_ACC_UNKNOWN = 6;// 入账未明（账户未响应）
    public static final int PAY_EXCEPTION = 7;// 系统异常（OLTP无响应）
    public static final int PAY_DELETE = 8;// 已作废
    public static final int PAY_UNDO_NO = 9;// 未冲正
    public static final int PAY_REFUND_NO = 10;// 未退货
    public static final int PAY_UNDO = 11;// 已冲正
    public static final int PAY_REFUND = 12;// 已退货
    public static final int TIMEOUT = 13;// 超时失效
    public static final int WINDOUT = 14;// 风险失效
    public static final int ADJUSTSUCCESS = 15;// 手工调整成功
    public static final int ADJUSTFAIL = 16;// 手工调整失败
    public static final int PAY_REFUND_PART = 20;// 部分退款
    // 鉴权用
    public static final int USERINFOISBIND = 17;// 实名信息已被别的用户绑定
    public static final String USERINFOISBINDMSG = "该证件已被其它账号绑定，请重新进行实名验证";

    // 订单支付状态(payStatusNew)
    public static final int PAY_STATUS_NO = 0;// 未支付
    public static final int PAY_STATUS_PART = 1;// 部分支付（线下收银台）
    public static final int PAY_STATUS_SUCCESS = 2;// 支付成功
    public static final int PAY_STATUS_ERROR = 3;// 支付失败
    public static final int PAY_STATUS_UNKNOWN = 4;// 支付未明
    public static final int PAY_STATUS_REFUND_PART = 5;// 退款中
    public static final int PAY_STATUS_REFUND = 6;// 已退款

    // 支付方式
    public static final int MODE_OF_PAYMENT_CASH = 001;// 现金
    public static final int MODE_OF_PAYMENT_UNIONPOS = 002;// 银联POS
    public static final int MODE_OF_PAYMENT_ICBCPOS = 003;// 工行POS
    public static final int MODE_OF_PAYMENT_OLDCARD = 004;// 以旧换新卡
    public static final int MODE_OF_PAYMENT_CASHACCOUNT = 201;// 会员现金账户
    public static final int MODE_OF_PAYMENT_UNIONPAY = 102;// 银联快捷支付
    public static final int MODE_OF_PAYMENT_PAPER = 103;// 黄金券
    public static final int MODE_OF_PAYMENT_ALIPAY = 101;// 支付宝
    public static final int MODE_OF_PAYMENT_GOLDCARD = 104;// 黄金卡
    public static final int MODE_OF_PAYMENT_YEEPAY = 105;// 易宝支付
    public static final int MODE_OF_PAYMENT_TRANSFER = 106;// 大客户转账
    public static final int MODE_OF_PAYMENT_TELEGRAPHICTRANSFER = 107;// 电汇
    public static final int MODE_OF_PAYMENT_CHECK = 108;// 支票

    public static final int MODE_OF_PAYMENT_MALING = 999;// 抹零
    public static final int MODE_OF_PAYMENT_MANZENG = 998;// 满赠
    public static final int MODE_OF_PAYMENT_MANJIAN = 997;// 保值补贴(满减优惠券)
    public static final int MODE_OF_PAYMENT_HONGBAO = 996;// 红包
    // 此处添加为了多边收银台
    public static final int MODE_OF_PAYMENT_FU = 121;// 福卡
    public static final int MODE_OF_PAYMENT_ZHONGXIN = 122;// 中欣卡
    public static final int MODE_OF_PAYMENT_AOSI = 123;// 奥斯卡

    // 多边收银台前台页面的显示支付方式
    public static final int MODE_OF_PAYMENT_CASHIER = 6;// 多边收银台

    // 多边收银台支付方式
    public static final int MODE_OF_PAYMENT_MULTIGOLD_UNIONPAY = 10;// 银联卡
    public static final int MODE_OF_PAYMENT_MULTIGOLD_TRANSFER = 16;// 大客户转账
    public static final int MODE_OF_PAYMENT_MULTIGOLD_TELEGRAPHICTRANSFER = 17;// 电汇
    public static final int MODE_OF_PAYMENT_MULTIGOLD_CHECK = 18;// 支票
    public static final int MODE_OF_PAYMENT_MULTIGOLD_FU = 21;// 福卡
    public static final int MODE_OF_PAYMENT_MULTIGOLD_ZHONGXIN = 22;// 中欣卡
    public static final int MODE_OF_PAYMENT_MULTIGOLD_AOSI = 23;// 奥斯卡
    public static final int MODE_OF_PAYMENT_MULTIGOLD_OLD2NEWCARD = 31;// 以旧换新卡
    public static final int MODE_OF_PAYMENT_MULTIGOLD_PAPER = 41;// 黄金券
    public static final int MODE_OF_PAYMENT_MULTIGOLD_CASH = 99;// 现金

    // 存金账户账户类型
    public static final int BUY_GOLD_ACCOUNT_TYPE_CURRENT = 0;// 活期
    public static final int BUY_GOLD_ACCOUNT_TYPE_TERM = 1;// 定期
    public static final int BUY_GOLD_ACCOUNT_TYPE_PROTECT = 2;// 保值
    public static final int BUY_GOLD_ACCOUNT_TYPE_LCGOLD = 3;// 理财金
    public static final int BUY_GOLD_ACCOUNT_TYPE_CASH_RECHARGE = 4;// 现金充值

    // 卖金账户账户类型
    public static final String SELL_GOLD_ACCOUNT_TYPE_CURRENT = "0";// 活期
    public static final String SELL_GOLD_ACCOUNT_TYPE_PROTECT = "1";// 保值

    public static final int CURRENT_TO_TERM = 0;// 活转定
    public static final int TERM_TO_CURRENT = 1;// 定转活

    public static final String LoanAud01 = "0104"; // 审核角色 一审
    public static final String LoanAud02 = "0105"; // 审核角色 二审
    public static final String LoanCASH01 = "0104"; // 审核角色 一审
    public static final String LoanCASH02 = "0105"; // 审核角色二审

    // 贷款批复角色
    public static final String LOAN_FIRST_INSTANCE = "1";// 一审
    public static final String LOAN_SECOND_INSTANCE = "2";// 二审

    // 贷款批复类型
    public static final String LOAN_APPRROVAL_AGREE = "0";// 同意
    public static final String LOAN_APPRROVAL_REJECT = "1";// 拒绝

    public static final String CURRENCY_GOLD = "GOLD";// 货币-黄金
    public static final String CURRENCY_CNY = "CNY";// 货币-人民币
    public static final String CURRENCY_CREDIT = "CREDIT";// 金豆

    // 保值活动是否开启，保值最低克重
    public static final int MVALUE_STATUS = 0;// 保值活动：开启0，未开启1
    public static final String MVALUE_GRAM = "100";// 保值活动最低克重

    public static final int VER_PASSWORD = 1;// 验证密码
    public static final int VER_PAY_PASSWORD = 2;// 验证支付密码

    public static final String PAY_INFO = "102:";//

    public static final String PSD_SEC_LOGIN = "01";
    public static final String PSD_PAY_PASSWD = "02";

    // 支付密码验证参数表字段
    public static final String PAY_TIMES = "pay.times";
    public static final String PAY_LOCK_SECOND = "pay.lock.second";

    // 调oltp体现使用
    public static final String WITHDRAW = "TX";

    // 风险提示
    public static final String OUT_OF_RISK = "当前牌价波动过大，请重新下单";

    // 黄金卡状态
    public static final String GCARD_STATUS_ACT = "1";// 已激活
    public static final String GCARD_STATUS_LOSS = "2";// 挂失
    public static final String GCARD_STATUS_NOLOSS = "4";// 解挂
    public static final String GCARD_STATUS_CANCEL = "9";// 销户

    // 订单是否调用oltp
    public static final String OLTP_STATUS_NO = "0";// 未调用oltp
    public static final String OLTP_STATUS_YES = "1";// 已调用oltp

    public static final String COOKIE_REFERER = "cookie_referer";

    // 用户类型
    public static final String USER_TYPE = "01";

    // 柜员
    public static final String ROLE_TYPE = "0101";

    // B2统一orgCode0001
    public static final String ORGCODE_B2 = "0001";

    // app图片验证码session——key
    public static final String APP_RANDOMCODE_KEY = "app_dbjb_VC";
    public static final String APP_RANDOMCODE_OVERDUETIME = "app_dbjb_ODT";

    // 登录方式
    public static final String LOGIN_TYPE_PHONE = "LT01";// 手机号登陆
    public static final String LOGIN_TYPE_GCARDNO = "LT02";// 黄金卡号登陆
    public static final String LOGIN_TYPE_WEIXIN = "LT03";// 微信登陆
    public static final String LOGIN_TYPE_USERNAME = "LT04";// 网页用户名登录
    public static final String LOGIN_TYPE_GM = "LT05";// 国美联合登陆

    // 优惠活动
    public static final String ENTRY_TYPE_CHANNEL = "01"; // 渠道类型
    public static final String ENTRY_TYPE_ORG = "02"; // 机构类型
    public static final String ENTRY_TYPE_COMM = "03"; // 商户类型

    public static final String FAVORABLE_SUCCESS = "0000";
    public static final String DUPLICATE_ENTRYCODE = "entryCodeduplicate";// 同一时间内渠道有一个以上优惠活动

    public static final String STATUS_USELESS = "0";// 入口可用
    public static final String STATUS_USE = "1";// 用户不可用

    /**
     * 活动类型编码
     */
    /** 满减活动 */
    public static final String ACT_CONSUM = "01";
    /** 保值活动 */
    public static final String ACT_MVALUE = "02";
    /** 签到活动 */
    public static final String ACT_SIGN = "03";
    /** 注册活动 */
    public static final String ACT_REGISTER = "04";
    /** 理财金满赠活动 */
    public static final String ACT_MZ = "05";
    /** 理财金送券活动 */
    public static final String ACT_SQ = "06";
    /** 实名认证活动 */
    public static final String ACT_VERIFY_REALNAME = "07";
    /** 送豆游戏 */
    public static final String ACT_GAME = "08";
    /** 推荐注册 */
    public static final String ACT_RECOMMEND = "09";
    /** 注册送礼包活动 */
    public static final String ACT_GIFT_REGISTER = "10";
    /** 随机送礼包游戏 */
    public static final String ACT_GIFT_RANDOM = "11";
    /** 推广推荐人 */
    public static final String ACT_REFEREE_PROMOTION = "12";
    /** 推荐购金送礼包 */
    public static final String ACT_RECOMMEND_BUY_SENDGIFT = "13";

    /**
     * 资金池存储类型
     */
    public static final String PROMOTION_CREDIT = "01";// 金豆
    public static final String PROMOTION_CONSUM_RMB = "02";// 促销费用人民币
    public static final String PROMOTION_CONSUM_GOLD = "03";// 促销费用黄金
    public static final String PROMOTION_MVALUE_GOLD = "04";// 保值费用黄金

    public static final String CASH_POOL_RECHANGE = "0";//充值
    public static final String CASH_POOL_TRANSFERIN = "1";//转入
    public static final String CASH_POOL_TRANSFEROUT = "2";//转出

    public static final String GIFT_CONTENT_TYPE_CREDIT = "0";
    public static final String GIFT_CONTENT_TYPE_COUPON = "1";

    // 限购限次---统计周期类型
    public static final String STAT_PERIOD_NONE = "1";//无周期
    public static final String STAT_PERIOD_DAY = "2";// 天
    public static final String STAT_PERIOD_WEEK = "3";// 周
    public static final String STAT_PERIOD_MONTH = "4";// 月
    public static final String STAT_PERIOD_YEAR = "5";//年

    // 理财金查询标识
    public static final String REGULAR = "regular";// 金生金
    public static final String FINANCE = "finance";// 理财金

    /**
     * 短信立即发送01
     */
    public static final String SHORT_MESSAGE_IMMEDIATELY = "01";
    /**
     * 短信排队发送02
     */
    public static final String SHORT_MESSAGE_QUEUING = "02";
    /**
     * 短信定时发送03
     */
    public static final String SHORT_MESSAGE_TIMING = "03";

    // 按金额满赠金
    public static final String MZ_BY_AMOUNT = "0";

    // 按克重满赠金
    public static final String MZ_BY_GRAM = "1";

    // 按金额满赠金豆
    public static final String MZ_CREDIT_BY_AMOUNT = "2";

    // 按克重满赠金豆
    public static final String MZ_CREDIT_BY_GRAM = "3";

    // B3抹零限次模拟产品号
    public static final String B3_ML_PRDCODE = "buygoldm2";

    // 黄金卡刷卡限次
    public static final String GOLD_CARD_PRDCODE = "goldcardNo";

    // 保值理财金
    public static final String PRODUCT_RISK_LEVEL_MVLUE = "1";
    // 理财金渠道
    public static final String CHANNELSUIT_LEVEL = "0";

    // 优惠券
    public static final String COUPON_Q_MZ = "801";// 满减券
    public static final String COUPON_H_JZ = "802";// 积存红包券
    public static final String COUPON_H_JD = "803";// 金豆红包券
    public static final String COUPON_H_LCJ = "804";// 理财金红包券
    public static final String COUPON_TYG = "996";// 理财金体验金
    // 优惠券生效时间类型
    public static final String EFFECT_DATE_TYPE_GET = "01";// 01-顾客领取时生效（默认值为当前时间）
    public static final String EFFECT_DATE_TYPE_STATIC = "02";// 02- 固定生效时间
    public static final String EFFECT_DATE_TYPE_MANY = "03";// 03-
    // 多人触发生效（多人点击生效）
    public static final String EFFECT_DATE_TYPE_MANY_FISSION = "04";// 04-
    // 多人触发裂变（需要多人点击生效，奠基人获得等额红包）
    // 红包状态
    public static final String COUPON_STATUS_USE = "0";// 0- 未使用
    public static final String COUPON_STATUS_USED = "1";// 1- 已使用
    public static final String COUPON_STATUS_LOCK = "2";// 2- 锁定状态--仅锁定表使用，红包并无此状态
    public static final String COUPON_STATUS_DELETE = "3";// 3- 已删除状态
    public static final String COUPON_STATUS_ERROR = "9";// 9- 异常状态－此状态仅在批量执行异常时使用
    // ROOT orgcode
    public static final String ROOT_ORGCODE = "0001";// ROOT orgcode

    public static final String REDIS_ORGKEY = "org_parent.";//将机构存放redis的key值前置

    //退款限制
    public static final String REFUND_LIMIT_NEED = "1";//需要退款限额限次
    public static final String REFUND_LIMIT_NOT_NEED = "0";//不需要退款限额限次

    //各种交易限额限次
    public static final String REFUND_LIMIT = "TH";//退款

    public static final String COUPON_LCJ = "红包理财金";//红包理财金

    //优惠券可用不可用
    public static final String CAN_USE = "1";//可用
    public static final String CAN_NOUSE = "0";//不可用

    //理财金风险等级
    public static final String LCJ_RISK_LEVEL_COMMON = "0";//普通
    public static final String LCJ_RISK_LEVEL_MVALUE = "1";//保值
    public static final String LCJ_RISK_LEVEL_NORMAL_RISK = "2";//中等风险
    public static final String LCJ_RISK_LEVEL_HIGH_RISK = "3";//高风险


    //促销赠送
    public static final String MZ_GOLD = "0";
    public static final String MZ_CREDIT = "1";

    //客户阀值设置(刘宪伟)
    public static final String UPDATE_THRESHOLD = "1";//更新操作
    public static final String MORE_THAN_THRESHOLD = "2";//大于阀值
    public static final String LESS_THAN_THRESHOLD = "3";//小于阀值

    public static final String[] YEEPAY_CODESENDER = new String[]{"MERCHANT"};

    //客户等级操作类型
    public static final String OPERATE_ZHUCHE = "1";  // 注册
    public static final String OPERATE_SHANGCHUAN = "2";  // 上传头像
    public static final String OPERATE_SHIMING = "3";  // 实名认证
    public static final String OPERATE_ADDRESS = "4";  //邮寄地址
    public static final String OPERATE_FUND = "5";  //账户资产

    // 大客户充值审批角色
    public static final String RECHARGE_FIRST_INSTANCE = "1";// 一审
    public static final String RECHARGE_SECOND_INSTANCE = "2";// 二审

    // 大客户充值批复类型
    public static final String RECHARGE_APPRROVAL_AGREE = "1";// 同意
    public static final String RECHARGE_APPRROVAL_REJECT = "0";// 拒绝

    // 大客户充值 审批状态
    public static final String RECHARGE_PENDING = "0";//待审
    public static final String RECHARGE_ONEPASS = "1";//一审通过
    public static final String RECHARGE_SUCCESS = "2";//充值成功
    public static final String RECHARGE_REFUSE = "3";//拒绝
    public static final String RECHARGE_EXCEPTION = "4";//异常
    //礼包种类
    public static final String GIFT_QUOTA = "0";//定额
    public static final String GIFT_RANDOM = "1";//随机

    public static final String GIFT_SEQ_TYPE = "gift_seq_type";//礼包seqType
    public static final String GIFT_SEQ_KEY = "gigt_Key";
    public static final int MAX_GIFTPOOL_NUM = 100000000;//礼包池最大seq



    public static final String JLCreateCode="90000001";//金力系统业务标示
    public static final String JLOperator="金力系统";//金力系统

    public static final String YEEPAYSYSTEM = "90000002";  //易宝支付

    public static final String COMPANY_FLAG_USE = "02";//企业用户
    public static final String COMPANY_FLAG_UNUSE = "01";//非企业用户

    public static final String LC_REGULAR_FLAG = "01";//理财金定额牌价标识


    // 企业用户认证 审批状态
    public static final String COMUSER_PENDING = "0";//待审
    public static final String COMUSER_ONEPASS = "1";//一审通过
    public static final String COMUSER_SUCCESS = "2";//充值成功
    public static final String COMUSER_REFUSE  = "3";//拒绝

    // 企业用户认证批复类型
    public static final String COMUSER_APPRROVAL_AGREE = "1";// 同意
    public static final String COMUSER_APPRROVAL_REJECT = "0";// 拒绝

    //客户理财金到期短息通知标识
    public static final String smsControl = "Sms.reguProduct.remind.control";
    public static final String smsDay = "Sms.reguProduct.remind.day";


    //可用理财金列表显示
    public static final String LC_ISVIEW_FALSE = "false";//不显示
    public static final String LC_ISVIEW_TRUE = "true";//显示

    //客服系统常量
    public static final String CS_EVENT_CREATE="新建工单";
    public static final String CS_EVENT_ADDREMARK="添加工单备注：";
    public static final String CS_EVENT_STATUS="状态：";
    public static final String CS_EVENT_BRACKETS="==>>";
    public static final String CS_SEQ_TYPE = "cs_remark_seqtype";//礼包seqType
    public static final String CS_SEQ_KEY = "cs_remark_Key";
    public static final String CS_STATUS_1 = "1";//新建
    public static final String CS_STATUS_2 = "2";//处理中
    public static final String CS_STATUS_3 = "3";//处理完成
    public static final String CS_STATUS_4 = "4";//重新打开
    public static final String CS_STATUS_5 = "5";//关闭

    public static final String CS_CREATE_TYPE1 = "1";//手工录入
    public static final String CS_CREATE_TYPE2 = "2";//推送

    public static final String CS_PRIORITY_1 = "1";//一般优先级
    public static final String CS_PRIORITY_2 = "2";//立即解决

    public static final String DEFAULT_TN = "DEFAULT_TN";


    public static final String SECRETKEY_REDIS_KEY = "SYSTEM.SECRETKEY.";
    public static final String SECRETKEY_POS_QRCODE_ORDERQUERY = "pos.order.query";
    public static final String SECRETKEY_POS_QRCODE_ORDERPAY = "pos.order.pay";

    public static final String CLIENT_STATUS_FREEZE = "0";//冻结
    public static final String CLIENT_STATUS_NORMAL = "1";//正常
    public static final String CLIENT_STATUS_LOGOUT = "2";//注销

    /** 定时任务初始化 */
    public static final String TIMING_STATUS_INIT = "1";
    /** 定时任务该记录已发送 */
    public static final String TIMING_STATUS_SEND = "2";
    /** 定时任务该记录返回成功 */
    public static final String TIMING_STATUS_SUCCESS = "3";
    /** 定时任务该记录返回失败 */
    public static final String TIMING_STATUS_FAIL = "4";

    //黄金卡状态
    public static final String GCARDSTATUS = "2";  //已分配状态

    //B1 判断到期／未到期
    public static final String TYPE_DUE = "2";  //已到期
    public static final String TYPE_NODUE = "1";  //未到期

    //B1 判断prdCode
    public static final String PRDCODE_GOLDANDGOLD = "1005";  //金生金
    public static final String PRDCODE_LCGOLD = "1006";  	//理财金
    public static final String PRDCODE_BZLCGOLD = "1008";  //保值理财金

    //B1 游戏或签到 设置到缓存中的key(安全性)
    public static final String GAME_SIGN_KEY = "app_random_token_code"; //8位数随机数字字母 的key值
    public static final int Game_Sign_TimeOut = 1200; //8位数随机数字字母 放入缓存中的超时时间
    /**当前随机送礼包的总的当日交易次数*/
    public static final String GAME_RANDOM_TIMES = "game.random.date.sum.times";

    public static final String BIGCUSTOMER = "02"; //代表大客户


    /**推广推荐人，实名认证*/
    public static final String REFEREE_RECOMM_VERIFYNAME = "1";
    /**推广推荐人，购买活期*/
    public static final String REFEREE_RECOMM_CURRENT = "2";
    /**推广推荐人，购买理财金*/
    public static final String REFEREE_RECOMM_LCPRD = "3";

    public static final String UNbINDYEEPAYCARD = "0";

    //提金认证
    public static final String AUTHSTATUS_ZERO = "0";  //待审核

    public static final String AUTHSTATUS_ONE = "1";   //一审通过

    public static final String AUTHSTATUS_TWO = "2";   //二审通过

    public static final String AUTHSTATUS_THREE = "3";  //审核拒绝

    //柜员二维码推荐购金 缓存key值
    public static final String COUNTER_USER_RELATION_KEY = "counter_user_relationship";

    //柜员二维码推荐购金 设置缓存的超时时间
    public static final int JEDIS_COUNTER_USER_RELATION_TIMEOUT = 24 * 60 * 60;
}
