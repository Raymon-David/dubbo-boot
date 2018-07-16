package com.raymon.constent;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public enum StatusCode {
    @CodeAnnot("正确处理") OK(1),//
    @CodeAnnot("系统错误") SystemError(9999),//
    @CodeAnnot("系统繁忙,请稍后再试") SystemBusy(9998),//
    @CodeAnnot("MD5验证失败") Md5ValidEroor(9997),//
    @CodeAnnot("应用程序错误") AppError(2), //
    @CodeAnnot("数据库错误") DBException(3), //
    
    @CodeAnnot("参数错误") RequestParamsNotValid(9001), //
    @CodeAnnot("邮箱格式不正确") EmailValid(10001), //
    @CodeAnnot("用户名长度必须为5-13") NickNameLengthValid(10002),//
    @CodeAnnot("接口错误") ItfcError(999),//
    @CodeAnnot("已存在") Exists(1111),//
    @CodeAnnot("记录不存在") NotExists(0000),//
//  @CodeAnnot("该账户已还款,请勿重复还款") Repayed(20001),
//  @CodeAnnot("该申请已审核或审核越级") ReAuditing(20002),
//  @CodeAnnot("当前牌价波动太大，审核不通") LoanWarn(20003),
//  @CodeAnnot("当前日期不支持此交易！") CANNTDO(20006),
//  
//  @CodeAnnot("超过申请次数限制") WithcashOverTime(20003),
//  @CodeAnnot("该账户未到最短还款日期,不能还款") UnRepay(20003),
    @CodeAnnot("申请成功，请等待平台审核!") WaitApply(11110),
    @CodeAnnot("一审通过") FirstAdopt(11111),
    @CodeAnnot("二审通过") Adopt(11112),
    @CodeAnnot("打款未明") Unsure(11114),//
    @CodeAnnot("打款成功") WithcashSuccess(11115),//
    @CodeAnnot("打款失败") WithcashDefult(11116),//
    @CodeAnnot("手工打款") WithcashByHand(11117),//
    @CodeAnnot("提现退款") WithcashReturn(11118),//
    @CodeAnnot("申请驳回") ApplyReject(11113),//
    @CodeAnnot("日切快照异常") CUTOFFSNAPSHOTINSERTFAIL(11120),//
    @CodeAnnot("日切快照重复") CUTOFFSNAPSHOTINSERTREPEAT(11121),//
    @CodeAnnot("已提交银行处理") Handling(11131),
    @CodeAnnot("暂时不支持此银行") BankErr(11141),
    @CodeAnnot("注册失败") RegisterError(11142),
    @CodeAnnot("登陆失败") LoginError(11143),
    
    @CodeAnnot("客户状态失效") clientStatusInActive(800001),
    @CodeAnnot("未提取到牌价") GoldPriceNotExist(800002),
    
    @CodeAnnot("文件找不到") UploadFileNotFound(9002),//
    @CodeAnnot("该用户已存在") UserNameHasExits(10001),//
    @CodeAnnot("邮箱格式错误") EmailFormatError(10002),
    @CodeAnnot("用户名为空") UserNameIsEmpty(10003),
    @CodeAnnot("用户名和邮箱绑定关系不存在,或者存在多个绑定关系") EmailAndUserNameBindError(10004),
    @CodeAnnot("邮箱地址未注册") EmailNotExsits(10005),
    @CodeAnnot("用户名或密码错误") UserOrPwdError(10006),
    @CodeAnnot("用户账号不唯一") UserNotUnique(10007),
    @CodeAnnot("用户账号不存在") UserAccountNotExit(10008),
    @CodeAnnot("原密码输入错误") OriginalPasswordError(10009),
    @CodeAnnot("会员信息不存在") MemberNotExitsError(10010),
    @CodeAnnot("该邮箱账号已经存在") UserEmailHasExits(10011),
    @CodeAnnot("账号未激活") UserNotActivite(10012),
    @CodeAnnot("账号激活码不存在") AccountCodeNotExits(10013),
    @CodeAnnot("账号激活码已过期") AccountCodeExpire (10014),
    @CodeAnnot("用户证件编号为空") UserIdCodeIsEmpty(10015),
    @CodeAnnot("用户手机号为空") UserPhoneIsEmpty(10016),
//  @CodeAnnot("支付密码为空") UserPayPasswordIsEmpty(10017),
//  @CodeAnnot("支付密码必须为6位") UserPayPasswordOutOfBounds(10018),
//  @CodeAnnot("支付密码错误") UserPayPasswordVaildateFailure(10019),
    @CodeAnnot("账户余额不足") NotSufficientFunds(10020),
    @CodeAnnot("登录次数过多，账户已锁定") LockUser(10021),
    @CodeAnnot("用户类型") UserTypeIsEmpty(10022),
    @CodeAnnot("当前版本过低，请您升级至最新版本") ANDROID_UPDATE(10999),
//  @CodeAnnot("密码错误") PwdError(10023),
    @CodeAnnot("账号状态异常") UserStatusError(10024),
    @CodeAnnot("设置默认异常") SetUnionCardDefError(10025),
    @CodeAnnot("身份证验证失败") IdCardVerifyFail(10026),
    @CodeAnnot("手机号认证失败") PhoneVerifyFail(10027),
    @CodeAnnot("支付密码已存在，不能设置支付密码") pwdIsExists(10028),
    @CodeAnnot("两次密码输入不匹配") pwdNotMatch(10029),
    @CodeAnnot("修改密码失败") pwdUpdateFail(10030),
    @CodeAnnot("重置支付密码失败") resetPayPasswdFail(10032),
    @CodeAnnot("证件号码为空") idNoIsEmpty(10031),
//  @CodeAnnot("用户没有设置支付密码") noPassword(10032),
//  @CodeAnnot("用户没有设置登录密码") noLoginPassword(10035),
    @CodeAnnot("没有实名认证！若要完成此业务需实名认证,请绑定银行卡。") NoCertification(10036),
    
    @CodeAnnot("otp动态令牌号错误") otpFail(10034),
//  @CodeAnnot("银行卡已绑定") UnionCardExsits(10033),

    @CodeAnnot("手机号格式错误") PhoneModelError(10037),
    //@CodeAnnot("密码输入错误达到3次，需要验证码！") PasswordThereError(10038),
    @CodeAnnot("密码错误或验证码超时!") PasswordThereError(10038),
    
    @CodeAnnot("客户已冻结") UserIsFreezed(10038),
    @CodeAnnot("解除默认异常") SetUnionCardNoDefError(10039),
    @CodeAnnot("手机号不是11位") PhoneaIsNotEleven(10040),
    @CodeAnnot("用户已签到") SignExist(10041),
    @CodeAnnot("签到失败") SignError(10042),
    @CodeAnnot("未实名认证") NoRealName(10044),
    @CodeAnnot("客户已注销") UserIsCloseAccount(10045),
    @CodeAnnot("此黄金卡号已解绑") UserCardUnbind(10046),
    @CodeAnnot("此黄金卡号已挂失") UserCardLoss(10047),
    
//  @CodeAnnot("该证件号已被绑定") IdCodeIsExsits(10043),
    
    @CodeAnnot("密码为空") PasswordIsEmpty(30003),
    @CodeAnnot("渠道为空") ChannelCodeIsEmpty(30004),
    @CodeAnnot("验证码为空") VerifyCodeIsEmpty(30005),
//  @CodeAnnot("验证码错误或已超时") VerifyCodeError(30006),
    @CodeAnnot("Token为空") TokenIsEmpty(30007),
    @CodeAnnot("没有查到数据") DataIsEmpty(30008),
    @CodeAnnot("期限不能为空") TimeLimitIsEmpty(30009),
    @CodeAnnot("验证码发送失败") VerifyCodeFail(30010),
    @CodeAnnot("请输入反馈内容") AdviceIsEmpty(30011),
    
    @CodeAnnot("业务编号为空")BizCodeIsEmpty(300013),
//  @CodeAnnot("克重为空")GramIsEmpty(300014),
    @CodeAnnot("支付方式为空")PayTypeIsEmpty(300015),
    @CodeAnnot("交易类型为空")TranCodeIsEmpty(300016),
    @CodeAnnot("黄金牌价为空")GoldPriceIsEmpty(300016),
    @CodeAnnot("利率牌价为空")InrateIsEmpty(300017),
    @CodeAnnot("订单号为空")OrgTraceNoIsEmpty(300018),
    @CodeAnnot("用户不存在") UserNotExit(300019),
    @CodeAnnot("订单来源系统为空")FromSysTemIsEmpty(300020),
    @CodeAnnot("商户编号为空")MerchIdIsEmpty(300021),
    @CodeAnnot("账户类型为空")UserIdIsEmpty(300022),
    @CodeAnnot("获取利率时系统异常")GetInrateError(300023),
    @CodeAnnot("获取黄金牌价时系统异常")GetGolePriceError(300024),
    @CodeAnnot("账户类型为空")DtrIdTpIsEmpty(300025),
    @CodeAnnot("用户未登录")UserNotLogin(300026),
    @CodeAnnot("用户注销异常")UserLogOutError(300027),
    @CodeAnnot("新密码为空")NewPasswordIsEmpty(300028),
    @CodeAnnot("修改数据异常")ModifyDataError(300029),
    @CodeAnnot("订单金额异常")OrderAmountError(300030),
    @CodeAnnot("创建订单失败")OrderCreateError(300031),
    @CodeAnnot("用户编号为空")UserCodeEmpty(300032),
    @CodeAnnot("渠道ID为空")ChannelIdEmpty(300034),
    @CodeAnnot("支付方式错误")ModeOfPaymentError(300032),
    @CodeAnnot("存金方式错误")AccountTypeError(300033),
    @CodeAnnot("活转定，定转活方式选择错误")ChangeTypeError(300034),
    @CodeAnnot("提现金额为空")WithDrawAmountEmpty(300035),
    @CodeAnnot("业务编号错误")BizCodeIsError(300016),
    @CodeAnnot("贷款账号错误")LoanCodeError(300017),
    @CodeAnnot("支付异常")PayError(300036),
    @CodeAnnot("克重错误")GramIsError(300037),
    @CodeAnnot("黄金券已使用")GoldOnPaperUsed(300038),
    @CodeAnnot("订单超时失效")TimeOut(300039),
    @CodeAnnot("订单风险过大")WindOut(300040),
    @CodeAnnot("交易失败")TranError(300041),
    @CodeAnnot("交易部分成功")TranSuccessPart(300042),
    @CodeAnnot("OLTP成功")OltpSuccess(300043),
    @CodeAnnot("OLTP失败")OltpFail(300044),
    @CodeAnnot("金额为空")AmountEmpty(300045),
    @CodeAnnot("金豆获取错误")InrateError(300046),
    @CodeAnnot("更新订单失败")OrderUpdateError(300047),
    @CodeAnnot("贷款未过最低期限，不能还款")LoanReplayError(300048),
    @CodeAnnot("暂无保值活动")MvalueNoActive(300049),
    @CodeAnnot("贷款金额最低一元")LoanAmountLimitOne(300050),
    @CodeAnnot("贷款金额为空")LoanAmountIsEmpty(300050),
    @CodeAnnot("密码未设置") PasswordNoSet(300051),
    @CodeAnnot("金豆不能为低于1")InrateLZero(300052),
    @CodeAnnot("交易超时")TranTimeOut(300053),
    @CodeAnnot("定转活失败，请刷新重试")TTOCError(300054),
    @CodeAnnot("您已在别的设备上登录，如果不是本人操作，请更改密码")UserOtherLogin(300055),
    @CodeAnnot("买金克重低于最小克重，请重新输入买金克重")GramIsTooLow(300054),
    @CodeAnnot("金额异常")AmountError(300055),
    @CodeAnnot("订单所属人与当前登录人不符")UserCodeNotEqual(300056),
    @CodeAnnot("输入金豆数必须是10的整数倍，请重新输入！")InrateTen(300057),
    @CodeAnnot("抹零失败！")MolingError(300058),
    @CodeAnnot("原订单正在处理！")OrderIsProcessing(300059),
    @CodeAnnot("原订单已被撤销！")OrderHasCancel(300060),
    @CodeAnnot("原订单不存在")SourceOrderNotExist(300070),
    @CodeAnnot("更新原订单账务状态失败")SourceOrderUpdateFail(300080),
    @CodeAnnot("原订单业务要素不一致")SourceOrderNotConsistent(300090),
    @CodeAnnot("原订单号为空")SourceOrderIsEmpty(300400),
    @CodeAnnot("现金充值低于最小金额，请重新输入充值金额")AmountIsTooLow(3000401),
    @CodeAnnot("实付金额不一致")RealAmountIsNotSame(3000402),
    @CodeAnnot("订单所有者与付款者不一致")OrderPersonNotSame(3000403),
    @CodeAnnot("订单重复开启,请关闭重开")OrderRepeatOpen(3000404),
    @CodeAnnot("优惠次数达到上限,请重新下单支付")DiscountUpperToLimit(3000405),
    @CodeAnnot("订单已被处理，请勿重复提交")ORDERISPROCESSING(3000406),
    @CodeAnnot("该订单不支持此种支付方式")ORDERISNOTSUPPORT(3000406),
    
    
    @CodeAnnot("机构号错误") ORGERROR(60001),
    @CodeAnnot("机构号为空") ORGIsEmpty(60002),
    @CodeAnnot("客户号为空") ClientCodeIsEmpty(60101),
    @CodeAnnot("客户姓名为空") ClientNameIsEmpty(60102),
    @CodeAnnot("关联卡号为空") CardNoIsEmpty(60201),
    @CodeAnnot("此银行卡号未绑定") CardNoIsNotBind(60202),
    @CodeAnnot("鉴权错误") CertError(60203),
    @CodeAnnot("鉴权失败") CertFail(60204),
    @CodeAnnot("获取绑定银行卡信息失败") GetBindCardInfoError(60205),
    @CodeAnnot("获取银行卡鉴权订单失败") GetCertOrderError(60206),
    @CodeAnnot("银行卡绑定失败") UnionCardBindFail(60207),
    @CodeAnnot("每个用户只可绑定一张易宝卡") YeePayCardIsBind(60208),
    @CodeAnnot("易宝卡不允许解绑") YPCardNoUnwrap(60209),
    @CodeAnnot("银行卡升级失败") UnionCardUpFail(60210),
    @CodeAnnot("无绑定的易宝卡") NoYeePayCardBind(60211),
    @CodeAnnot("该易宝卡您已绑定") YeePayCardExist(60212),
    
    @CodeAnnot("未找到对应的机构渠道产品状态") OrgChannlPrdStatusIsEmpty(60301),
    @CodeAnnot("机构渠道产品状态") OrgChannlPrdStatusUseless(60302),
    @CodeAnnot("用户的组织机构不存在") UserOrgNotExist(61301),
    

    
    @CodeAnnot("记账失败") ChargeUpFail(100000),
    
    @CodeAnnot("参数错误") DepositGoldIsEmpty(70000),
    @CodeAnnot("输入错误") InvalidInput(70001),
    @CodeAnnot("保值购买错误") MvalueError(70002),
    @CodeAnnot("商户打款金额总和为负") InvalidMerAmount(70003),
    @CodeAnnot("卖金失败，请刷新后重试") SellMvalueError(70004),
    //@CodeAnnot("保值账户不存在") MvalueNotFound(70005),
    @CodeAnnot("保值入库失败") MvalueInsertError(70005),
    @CodeAnnot("未找到对应的服务") NotFoundService(1000001),
    @CodeAnnot("转定克重不能为空") GoldIsEmpet(1000002),
    
    
    @CodeAnnot("重置密码成功") pwdResetSuccess(1000009),
    @CodeAnnot("重置密码失败") pwdResetFail(1000010),
    
    @CodeAnnot("当前时段不支持此业务办理") notSupportBiz(1000011),
    @CodeAnnot("ip地址有误")IPError(1000012),
    @CodeAnnot("获取ip地址异常")GetIPError(1000013),
    @CodeAnnot("登录日志添加失败")LoginLogInsertError(1000014),
    
    @CodeAnnot("成功") accountSumSuccess(1000015),
    @CodeAnnot("失败") accountSumFail(1000016),
    
    @CodeAnnot("黄金券校验失败") GoldOnPaperVerifyFail(1000017),
    
    @CodeAnnot("您的银行卡与手机号不符，请核对后再试。") UnionPhoneNoSame(1000018),
    
    //交易状态控制错误码
    @CodeAnnot("交易状态名称重复") bizDuplicateStatusName(1000),
    @CodeAnnot("交易列表不能为空") bizTransNotBlank(1001),
    @CodeAnnot("交易列表不能重复") bizTransNotDuplicate(1002),
    @CodeAnnot("交易列表入库失败") bizTransInsertFail(1003),
    @CodeAnnot("该交易已经关闭") bizTransNotUsess(1004),
    @CodeAnnot("理财金产品校验参数失败") LCGoldParamInvalid(1000019),
    @CodeAnnot("理财金产品校验参数失败") LCGUnexpired(1000020),
    @CodeAnnot("您不在该产品对应的客户等级内!") LCGoldClientLevelError(1000021),
    @CodeAnnot("该产品为大客户专享") LCGoldCustomerTypeError(1000022),
    @CodeAnnot("该产品为企业客户专享") LCGoldCompanyType01Error(1000023),
    @CodeAnnot("该产品为普通客户专享") LCGoldCompanyType02Error(1000024),

    //风控校验错误码
    @CodeAnnot("已达个人最高限制") PersonValidateFail(50001),//个性规则校验不通过
    @CodeAnnot("已达产品最高限制") ProductValidateFail(50002),//个性规则校验不通过
    
    
    
    //退款校验错误码
    @CodeAnnot("退款金额过大") RefundAmountMoreBig(50003),//个性规则校验不通过
    @CodeAnnot("订单已超过可退款的天数限制") RefundDaysTimeOut(50004),//退款天数限制
    
    
    //满赠活动错误码
    @CodeAnnot("客户满赠金额已满") MzAmountIsOver(50005),//FeeCalError
    @CodeAnnot("活动满赠克重已满") MzGramIsOver(50006),//
    @CodeAnnot("没达到满赠金额") NoArrivaledMzAmount(50007),//
    @CodeAnnot("没达到满赠克重") NoArrivaledMzGram(50008),//
    @CodeAnnot("目前没有满赠克重") NoMZActivity(50009),//
    @CodeAnnot("已超过个人最大满赠次数") MzNumberIsOver(50010),//
    @CodeAnnot("满赠克重获取失败") MzCalError(50011),
    
    //账户oltp校验
//  @CodeAnnot("订单入账时间超时") OderToAccountOverTime(55510),
//  @CodeAnnot("账户已限制,不允许做此交易") AccountStatusNoByBiz(55520),
//  @CodeAnnot("账户并发处理异常") AccountConcurrentException(55530),
//  @CodeAnnot("登记账户业务流水表异常") RegisterAccBizLogException(55540),
//  @CodeAnnot("原交易登记账户流水表表异常") RegisterOriAccBizLogException(55550),
    //手续费
    @CodeAnnot("手续费获取失败") FeeCalError(65566),//
    @CodeAnnot("无手续费信息") NoFee(65566),
    
    
    @CodeAnnot("客户账户不存在") AccountIsNoExit(9990022),
    @CodeAnnot("暂不支持此银行,请重新选取银行进行提现") CardIsNoSupport(9990023),
    
    
    //提金单据错误码
    @CodeAnnot("提金单据不存在") withdrawGoldIsNotFound(9990026),
    @CodeAnnot("提金单号为空") withdrawGoldIsEmpty(9990027),
    @CodeAnnot("提金申请异常,请等待人工处理") withdrawGoldException(9990028),
    @CodeAnnot("实物金不足") PhysicalGoldNotSuffFunds(9990029),
    @CodeAnnot("自提日期小于最短自提期限") withdrawGoldNotYet(9990030),
    @CodeAnnot("提金撤回异常，等待人工处理！") withdrawReturnException(9990031),
    @CodeAnnot("该提金单据不能冲回，请查看提金单据状态后再试！") withdrawCantReturn(9990032),
    @CodeAnnot("收货人必须为用户自己！") NameMustBeYourSelf(9990033),
    @CodeAnnot("实物金份数不足！") GoldNumNotSuffFunds(9990034),
    @CodeAnnot("原交易不存在！") OrigTransactionNotExist(9990035),
    @CodeAnnot("原提金单已冲回！") OrigTransIsReturn(9990036),
    
    //补录
    @CodeAnnot("补录失败") BackTrackError(70001),//
    @CodeAnnot("入账调整失败") EntryAdjustFail(70002),//
    

    //优惠券
    @CodeAnnot("红包已失效") COUPON_INVALID_YET(88001),
    @CodeAnnot("红包无效") COUPON_INVALID(88002),
    @CodeAnnot("红包已经发光了") COUPON_USEOVER(88003),
    @CodeAnnot("红包已过期") COUPON_OVERDUE(88004),
    @CodeAnnot("使用优惠券失败") COUPON_USE_FAIL(88005),
    @CodeAnnot("没有查到优惠券信息") COUPON_SELECT_NULL(88006),
    @CodeAnnot("没有查到红包信息") COUPON_SELECT_HB_NULL(88007),
    @CodeAnnot("红包领取失败") COUPON_GET_FAIL(88008),
    @CodeAnnot("你已经帮他分享过了") COUPON_FISSION_REPEAT(88009),
    @CodeAnnot("红包信息错误") COUPON_FISSION_HB_ERROR(88010),
    @CodeAnnot("红包尚未达到领取条件") COUPON_FISSION_HB_RULE_ERROR(88011),
    @CodeAnnot("理财金优惠券参数错误") LCJ_COUPON_PARAMERROR(88012),
    @CodeAnnot("理财金优惠券重复使用") LCJ_COUPON_REPEAT(88013),
    @CodeAnnot("您已领取过此优惠券") COUPON_GET_REPEAT(88014),
    @CodeAnnot("锁定优惠券失败") COUPON_LOCK_FAIL(88015),
    @CodeAnnot("优惠券编码为空") COUPON_CODE_EMPTY(88016),
    @CodeAnnot("优惠券已领完") COUPON_NO_RECEIVE(88017),
    @CodeAnnot("已过期优惠券删除失败") COUPON_DELETE_NO_SUCCESS(88018),
    
    //活动
    @CodeAnnot("无活动") NO_ACTIVE(88014),
    @CodeAnnot("活动详情信息不存在") NO_ACTIVE_DETAIL(88015),

    //头像上传
    @CodeAnnot("头像上传失败") UPDATE_USERPHOTO_FAIL(88016),
    @CodeAnnot("无优惠券可用") NO_COUPON(88015),
    
    
    @CodeAnnot("验签失败") SIGN_CHECK_FAILURE(90001),
    @CodeAnnot("订单已支付，请勿重复支付") ORDER_PAYED(90002),
    
    //游戏活动
    @CodeAnnot("您的提交过于频繁，请稍后再试") TimeIntervalError(90003),
    @CodeAnnot("很遗憾，本次未中奖") GameFail(90004),
    @CodeAnnot("游戏金豆不足") OverGameCredit(90006),
    @CodeAnnot("中奖") GameSuccess(90009),
    @CodeAnnot("游戏失败") GameError(90010),
    @CodeAnnot("您的提交过于频繁，请稍后再试") TimeRedislock(90011),
    @CodeAnnot("分享成功") SharedSuccess(90012),
    @CodeAnnot("您已分享过此活动") SharedHasUsed(90013),
    @CodeAnnot("今日游戏次数已用完") GameTimesUsed(90014),
    
    //积存金购物
    @CodeAnnot("积存金购买理财失败") CurrentToLcGoldFailure(90007),
    @CodeAnnot("积存金账户余额不足") CurrentNotSufficientFunds(90008),
    
    
    
    //调账新增
    @CodeAnnot("订单号不能为空") OrderIdIsNull(90005),
    
    
    
    
    
    
    
    
    //B3系统相关级别错误--02开头
    @CodeAnnot("交易失败,订单超时") OrderIsInvalid(20001),
    @CodeAnnot("卖金部分成功") PartSuccSellGOld(20002),
    @CodeAnnot("卖金失败") FailureSellGold(20003),
    @CodeAnnot("交易失败,当前牌价波动较大，请重新下单")WindBig(20004),
    @CodeAnnot("现金账户余额不足")CashAccountNoMoney(20005),
    @CodeAnnot("系统错误")B3SystemError(20006),
    @CodeAnnot("支付失败")PayFailure(20007),
    @CodeAnnot("支付成功,但是修改订单状态失败")UpdateStatusFail(20008),
    @CodeAnnot("订单与用户不一致")OrderIsNotAgreedUser(20009),
    @CodeAnnot("理财金购买成功")FinancSuccess(20010),
    @CodeAnnot("申请成功")ApplySuccess(20011),
    @CodeAnnot("已成功提交申请,等待后台审核")WaitExamine(20012),
    
    
    
    //B3系统对应调账错误
    @CodeAnnot("平台账户为空，不能进行调账") platFormAccountIsEmpty(20013),
    @CodeAnnot("调账失败") adjustmentFail(20014),
    @CodeAnnot("关闭保值失败") closeHedgeFail(20015),
    @CodeAnnot("关闭定期失败") closeRegularFail(20016),
    @CodeAnnot("新增保值失败") openHedgeFail(20017),
    @CodeAnnot("新增定期失败") openRegularFail(20018),
    @CodeAnnot("关闭理财金失败") closeLcGoldFail(20019),
    @CodeAnnot("新增理财金成功") openLcGoldFail(20020),
    @CodeAnnot("保值到期日期应大于当前日期") hedgeEndTime(20021),
    @CodeAnnot("定期到期日期应大于当前日期") regularEndTime(20022),
    

    @CodeAnnot("该账户已还款,请勿重复还款") Repayed(20023),
    @CodeAnnot("该申请已审核或审核越级") ReAuditing(20024),
    @CodeAnnot("当前牌价波动太大，审核不通") LoanWarn(20025),
    @CodeAnnot("当前日期不支持此交易！") CANNTDO(20026),
    
    @CodeAnnot("超过申请次数限制") WithcashOverTime(20027),
    @CodeAnnot("该账户未到最短还款日期,不能还款") UnRepay(20028),
    
    //B3系统黄金卡错误
    @CodeAnnot("绑定成功!") GCardBindSuccess(20029),
    @CodeAnnot("黄金卡状态错误!") GCardStatusError(20030),
    @CodeAnnot("黄金卡信息存入失败!") GCardInsertFail(20031),
    @CodeAnnot("客户已绑定黄金卡,请勿重复绑定！") GCardBindMore(20032),
    @CodeAnnot("黄金卡号为空!") GCardNull(20033),
    @CodeAnnot("黄金卡解绑成功!") GCardUnwrapSuccess(20034),
    @CodeAnnot("黄金卡解绑失败!") GCardUnwrapFail(20035),
    //B3系统更新手机号
    @CodeAnnot("手机号已存在,修改失败!") UserPhoneExsits(20036),
    @CodeAnnot("手机号修改失败!") UserPhoneUpdateError(20037),
    @CodeAnnot("此用户没有绑定的银行卡！") NoBindBankCards(20038),
    
    

    @CodeAnnot("该订单不存在") OrderIsNotExists(20039),
    @CodeAnnot("订单已作废！") OrderIsNoUsed(20040),
    @CodeAnnot("不支持此支付卡种！") NotSupportCardType(20041),
    @CodeAnnot("支付总金额超出订单金额！") TotalAmountIsOver(20042),
    @CodeAnnot("入账失败！") EntryAccountFail(20043),
    @CodeAnnot("入账未明，请联系运营人员！") EntryAccountUnCleared(20044),
    
    
    
    @CodeAnnot("企业用户信息不存在 ") ComUserInfoNotExit(20045),
    @CodeAnnot("用户角色为空 ") RoleTypeIsEmpty(20046),
    @CodeAnnot("该客户已经完成实名认证，无法进行企业认证 ") ClientIsNotApproval(20047),
    @CodeAnnot("用户没有柜员角色权限 ") UserCounterRoleTypeIsEmpty(20048),
    @CodeAnnot("用户没有客服角色权限 ") UserServiceRoleTypeIsEmpty(20049),
    
    
    
    @CodeAnnot("企业电话信息验证失败 ") ComUserPhoneInfoFail(980008),
    @CodeAnnot("公司紧急联系人电话信息验证失败") ComEmerPhoneInfoFail(980009),
    @CodeAnnot("营业执照号验证失败") BusiLicenseFail(980010),
    
    
    @CodeAnnot("克重为空")GramIsEmpty(300014),
    //客户信息相关级别错误--99开头
    @CodeAnnot("支付密码错误") PayPasswordVaildateFailure(990001),
    @CodeAnnot("支付密码为空") UserPayPasswordIsEmpty(990002),
    @CodeAnnot("支付密码必须为6位") UserPayPasswordOutOfBounds(990003),
    @CodeAnnot("支付密码错误") UserPayPasswordVaildateFailure(990004),
    @CodeAnnot("验证码错误或已超时") VerifyCodeError(990005),
    @CodeAnnot("密码错误") PwdError(990006),
    @CodeAnnot("用户没有设置登录密码") noLoginPassword(990007),
    @CodeAnnot("用户没有设置支付密码") noPassword(990008),
    @CodeAnnot("银行卡已绑定") UnionCardExsits(990009),
    @CodeAnnot("该证件号已被绑定") IdCodeIsExsits(990010),
    @CodeAnnot("客户被注销") UserIsLogout(990010),
    
    
    
    
    
    //po处相关返回码定义--以91开头
    @CodeAnnot("获取利率时系统异常")PoGetInrateError(910001),
    @CodeAnnot("获取黄金牌价时系统异常")PoGetGolePriceError(910002),
    @CodeAnnot("克重错误")PoGramIsError(910003),
    @CodeAnnot("订单金额异常")PoOrderAmountError(910004),
    @CodeAnnot("创建订单失败")PoOrderCreateError(910005),
    
    @CodeAnnot("参数错误") PoRequestParamsNotValid(910006),
    @CodeAnnot("系统错误") PoSystemError(910007),
    
    @CodeAnnot("买金类型不对") PoBuyGoldTypeIsNotValid(910008),
    @CodeAnnot("抹零金额不符和规则") PoMLIsNotValid(910009),
    @CodeAnnot("理财金产品校验参数失败") PoLCGoldParamInvalid(910010),
    @CodeAnnot("订单为空") PoOrderIsNull(910011),
    @CodeAnnot("订单超时失效")PoTimeOut(910012),
    @CodeAnnot("订单风险过大")PoWindOut(910013),
    @CodeAnnot("订单支付方式错误")PoModeOfPaymentError(910014),
    
    @CodeAnnot("发送联机交易系统异常")OrderToOltpEXCEPTION(910015),
    
    
    @CodeAnnot("卖金金额不能小于手续费，请重新下单")PoAmountLessThanFee(910016),
    
    @CodeAnnot("账号状态异常") PoUserStatusError(910017),
    @CodeAnnot("未找到对应的活期账户号") PoCurrAccountNotFound(910018),
    @CodeAnnot("活期账户余额不足") PoCurrAccountNotSuffFunds(910019),
    @CodeAnnot("应用程序错误") PoAppError(910020), //
    @CodeAnnot("贷款记录不存在") PoloanIsNoExit(910021),
    @CodeAnnot("贷款申请单号为空") PoApplyLoanCodeIsEmpty(910022),
    @CodeAnnot("当前日期不支持此交易！") PoCANNTDO(910023),    
    @CodeAnnot("超过申请次数限制") PoWithcashOverTime(910024),
    @CodeAnnot("现金账户余额不足") PoPCashAccountNotSuffFunds(910025),
    @CodeAnnot("手续费获取失败") PoFeeCalError(910026),//
    @CodeAnnot("暂不支持此银行,请重新选取银行进行提现") PoCardIsNoSupport(910027),
    @CodeAnnot("客户账户不存在") PoAccountIsNoExit(910028),
    @CodeAnnot("错误处理") withdrawError(910029),
    @CodeAnnot("黄金券校验失败") PoGoldOnPaperVerifyFail(910030),

    @CodeAnnot("订单金额异常")OrderAmountEXCEPTION(910031),
    @CodeAnnot("联机交易系统处理超时")OLTPEXCEPTION(910032),
    @CodeAnnot("暂不支持此银行，请重新选取银行进行提现！")NotSupportBank(910033),
    
    

    @CodeAnnot("用户编号为空")PoUserCodeEmpty(910034),
    @CodeAnnot("渠道为空") PoChannelCodeIsEmpty(910035),
    @CodeAnnot("贷款金额为空")PoLoanAmountIsEmpty(910036),
    @CodeAnnot("提现记录不存在") PoWithDrawIsNoExit(910037),
    @CodeAnnot("提现申请单号为空") PoWithDrawIsEmpty(910038),
    @CodeAnnot("抹零失败！")PoMolingError(910039),
    @CodeAnnot("无返回")NoReturn(910040),
    @CodeAnnot("您的提交过于频繁，请10秒后再试") PoTimeIntervalError(910041),
    @CodeAnnot("该笔订单已退款，不能再次退款") PoOrderIsRefund(910042),
    @CodeAnnot("该订单不能退款") PoOrderIsNotSupportRefund(910043),
    @CodeAnnot("退款失败") RefundFail(910044),
    @CodeAnnot("未实名支付，不能进行银联支付") CanNotUPOP(910045),
    @CodeAnnot("您尚未绑定银行卡，请绑定银行卡后进行操作") BankCardIsNotBind(910046),
    
    
    
        //账户系统的返回码定义 以93开头
        @CodeAnnot("未定义的错误返回码") AccountUnknownError(930001),
        @CodeAnnot("处理失败") AccountError(930002),
        @CodeAnnot("没有该账户状态") NoThisStatus(930003),
        @CodeAnnot("开户失败") OpenAccountFail(930004),
        @CodeAnnot("账户为空") AccountIsEmpty(930005),
        @CodeAnnot("对应基础账户非活动") BaseAccountUNActive(930006),
        @CodeAnnot("活期账户已销户") BaseAccountClose(930007),
        @CodeAnnot("基础账户入库失败") BaseAccountNotFound(930008),
        @CodeAnnot("活期账户已冻结") CurAccountFreeze(930009),
        @CodeAnnot("活期账户只收不付") CurAccountPayNo(930010),
        @CodeAnnot("活期账户只付不收") CurAccountPayNoCharge(930011),
        @CodeAnnot("活期账户已结清") CurAccountSettle(930012),
        @CodeAnnot("活期账户已销户") CurAccountClose(930013),
        @CodeAnnot("活期账户余额不足") CurrAccountNotSuffFunds(930014),
        @CodeAnnot("未找到对应的活期账户号") CurrAccountNotFound(930015),
        @CodeAnnot("活期账户入库失败") CurrAccInsertFail(930016),
        @CodeAnnot("活期账户明细入库失败") CurrAccDetailInsertFail(930017),
        @CodeAnnot("活期账户验密失败") CurrAccValSignFail(930018),
        
        @CodeAnnot("现金账户已冻结") PCashAccountFreeze(930028),
        @CodeAnnot("现金账户只收不付") PCashAccountPayNo(930029),
        @CodeAnnot("现金账户只付不收") PCashAccountPayNoCharge(930030),
        @CodeAnnot("现金账户已结清") PCashAccountSettle(930031),
        @CodeAnnot("现金账户已销户") PCashAccountClose(930032),
        @CodeAnnot("现金账户余额不足") PCashAccountNotSuffFunds(930033),
        @CodeAnnot("未找到对应现金账户号") PCashAccountNotFound(930034),
        @CodeAnnot("现金账户入库失败") PCashAccInsertFail(930035),
        @CodeAnnot("现金账户明细入库失败") PCashAccDetailInsertFail(930036),
        @CodeAnnot("现金账户还款失败") PCashAccRePayFail(930037),
        @CodeAnnot("现金账户验密失败") PCashAccValSignFail(930038),
        @CodeAnnot("提现申请冻结入库失败") ApplyWithdrawFreezedInsertFail(930039),
        @CodeAnnot("未找到对应申请冻结记录") ApplyWithdrawFreezedNotFound(930040),
        @CodeAnnot("申请冻结状态错误") ApplyWithdrawFreezedStatusError(930041),
        @CodeAnnot("申请冻结记录更新失败") ApplyWithdrawFreezedUpdateFail(930042),
        
        @CodeAnnot("金豆账户已冻结") CreditAccountFreeze(930053),
        @CodeAnnot("金豆账户只收不付") CreditAccountPayNo(930054),
        @CodeAnnot("金豆账户只付不收") CreditAccountPayNoCharge(930055),
        @CodeAnnot("金豆账户余额不足") CreditAccountNotSuffFunds(930056),
        @CodeAnnot("金豆账户已销户") CreditAccountClosed(930057),
        @CodeAnnot("未找到对应的金豆账户") CreditInAccountNotFound(930058),
        @CodeAnnot("金豆账户入库失败") CreditAccInsertFail(930059),
        @CodeAnnot("金豆账户明细入库失败") CreditAccDetailInsertFail(930060),
        @CodeAnnot("金豆账户验密失败") CreditAccValSignFail(930061),
        
        @CodeAnnot("商户账户已冻结") CommAccountFreeze(930072),
        @CodeAnnot("商户账户只收不付") CommAccountPayNo(930073),
        @CodeAnnot("商户账户只付不收") CommAccountPayNoCharge(930074),
        @CodeAnnot("商户账户已结清") CommAccountSettle(930075),
        @CodeAnnot("商户账户已销户") CommAccountClose(930076),
        @CodeAnnot("商户现金账户调账金额为空") merchatMoneyIsEmpty(930077),
        @CodeAnnot("用户账户调账输入参数为空") userMoneyIsEmpty(930078),
        @CodeAnnot("商户账户已销户") CommAccountNotFound(930079),
        @CodeAnnot("商户账户不存在") CommAccountNotExist(930080),
        @CodeAnnot("商户账户验密失败") CommAccountValSignFail(930081),
        
        @CodeAnnot("保值账户不存在") MvalueNotFound(930091),
        @CodeAnnot("定期账户销户失败") RegularAccountcloseFail(930092),
        @CodeAnnot("定期账户已冻结") RegularAccountFreeze(930093),
        @CodeAnnot("定期账户定期账户提前支取") RegularAccountDRAWALADVANCE(930094),
        @CodeAnnot("定期账户已销户") RegularAccountLATEDRAWAL(930095),
        @CodeAnnot("定期账户不存在") RegularAccountNotFound(930096),
        @CodeAnnot("定期账户余额不足") RegularAccountNotSuffFunds(930097),
        @CodeAnnot("创建定期账户失败") RegularAccountFailed(930098),
        @CodeAnnot("创建定期账户明细失败") RegularAccountDetailFailed(930099),
        @CodeAnnot("定期账户验密失败") RegularAccountValSignFail(930100),
        @CodeAnnot("贷款账户已冻结") LoanAccountFreeze(930101),
        @CodeAnnot("贷款账户已销户") LoanAccountClose(930102),
        @CodeAnnot("未找到对应的贷款账户") LoanAccountNotFound(930103),
        @CodeAnnot("贷款账户还款失败") LoanAccountNotSuffFunds(930104),
        @CodeAnnot("创建贷款账户失败") LoanAccountFailed(930105),
        @CodeAnnot("创建贷款账户明细失败") LoanAccountDetailFailed(930106),
        @CodeAnnot("贷款解冻失败") LoanUnFreeFailed(930107),
        @CodeAnnot("贷款变更状态失败") LoanStatusFailed(930108),
        @CodeAnnot("增加贷款还款记录失败") LoanRepayAddFailed(930109),
        @CodeAnnot("贷款账户验密失败") LoanAccountValSignFail(930110),
        @CodeAnnot("贷款冻结验密失败") LoanFreezeValSignFail(930111),
        @CodeAnnot("提现冻结验密失败") WithdrawFreezeValSignFail(930112),
        @CodeAnnot("该账户不能提前解约") RegularAccountNotRelease(930113),
        
        @CodeAnnot("原子交易积存金账户加失败") AtomCurAccountAddFail(930123),
        @CodeAnnot("原子交易积存金账户减失败") AtomCurAccountSubFail(930124),
        @CodeAnnot("原子交易现金账户加失败") AtomCashAccountAddFail(930125),
        @CodeAnnot("原子交易现金账户减失败") AtomCashAccountSubFail(930126),
        @CodeAnnot("原子交易金豆账户加失败") AtomPointAccountAddFail(930127),
        @CodeAnnot("原子交易金豆账户减失败") AtomPointAccountSubFail(930128),
        @CodeAnnot("原子交易保值账户加失败") AtomMvlAccountAddFail(930129),
        @CodeAnnot("原子交易保值账户减失败") AtomMvlAccountSubFail(930130),
        @CodeAnnot("原子交易定期账户加失败") AtomRegAccountAddFail(930131),
        @CodeAnnot("原子交易定期账户减失败") AtomRegAccountSubFail(930132),
        @CodeAnnot("原子交易贷款账户加失败") AtomLoanAccountAddFail(930133),
        @CodeAnnot("原子交易贷款账户减失败") AtomLoanAccountSubFail(930134),
        @CodeAnnot("原子交易商户账户加失败") AtomCommAccountAddFail(930135),
        @CodeAnnot("原子交易商户账户减失败") AtomCommAccountSubFail(930136),
        @CodeAnnot("原子交易提现申请冻结失败") AtomApplyWithdrawAddFail(930137),
        @CodeAnnot("原子交易提现申请解冻失败") AtomApplyWithdrawSubFail(930138),
        @CodeAnnot("原子交易平台现金账户加失败") AtomCashLeAccountAddFail(930139),
        @CodeAnnot("原子交易平台现金账户减失败") AtomCashLeAccountSubFail(930140),
        @CodeAnnot("原子交易平台提现临时账户加失败") AtomCashLedgerTmpAddFail(930141),
        @CodeAnnot("原子交易平台提现临时账户减失败") AtomCashLedgerTmpSubFail(930142),
        @CodeAnnot("原子交易手续费入库失败") AtomFeeAmountInsertFail(930143),
        @CodeAnnot("原子交易待清算商户账户加失败") AtomMerchantAddFail(930144),
        @CodeAnnot("原子交易待清算商户账户减失败") AtomMerchantSubFail(930145),
        
        @CodeAnnot("业务逻辑计算失败") BizCompFail(930154),
        @CodeAnnot("提现申请单号为空") WithDrawIsEmpty(930155),
        @CodeAnnot("提现记录不存在") WithDrawIsNoExit(930156),
        @CodeAnnot("贷款申请单号为空") ApplyLoanCodeIsEmpty(930157),
        @CodeAnnot("贷款记录不存在") loanIsNoExit(930158),
        @CodeAnnot("贷款记录状态异常") loanStatusException(930159),
        @CodeAnnot("此账号已被冻结,不可以提现") Freeze(930160),
        @CodeAnnot("此客户已被冻结,只能做拒绝操作") AudFreeze(930161),
        
        //账户oltp校验
        @CodeAnnot("订单入账时间超时") OderToAccountOverTime(930099),
        @CodeAnnot("账户已限制,不允许做此交易") AccountStatusNoByBiz(930100),
        @CodeAnnot("账户并发处理异常") AccountConcurrentException(930101),
        @CodeAnnot("登记账户业务流水表异常") RegisterAccBizLogException(930102),
        @CodeAnnot("原交易登记账户流水表表异常") RegisterOriAccBizLogException(930103),
        @CodeAnnot("对应基础账户已锁定") BaseAccountLocked(930104),
        @CodeAnnot("对应基础账户锁定记录已不存在") BaseAccountNotExistsLocked(930105),
        @CodeAnnot("批量日切重复") CutOffSnapshotInsertRepeat(930106),
        @CodeAnnot("平台原子交易入库失败")  TActLedgerAtomDetailInsertFail(930107),
        @CodeAnnot("科目映射不存在") SubjectNotExists(930108),
        @CodeAnnot("不存在绑定的银行卡") BankNotgbind(930109),
        @CodeAnnot("交易重复") OrderRepeat(930110),
        @CodeAnnot("原订单账户处理未成功")OrderActStatusByNo(930111),
        @CodeAnnot("原交易已成功")OrderSucceeded(930112),
        
        //A9期货相关
        @CodeAnnot("上传文件失败") UploadError(940001),
        @CodeAnnot("上传文件成功") UploadSuccess(940002),
        @CodeAnnot("解析期货文件异常") ReadTextError(940003),
        @CodeAnnot("生成期货Excel文件异常") CreateExcelError(940004),
        @CodeAnnot("解析Excel异常") ReadExcelError(940005),
        @CodeAnnot("保存数据出现异常") SaveDataError(940006),
        @CodeAnnot("成功入库") SaveDataSuccess(940007),
        @CodeAnnot("文件上传重复") DupliFile(940008),
        
        //用户地址维护
        @CodeAnnot("地址添加失败") AddressAddFail(960000),
        @CodeAnnot("地址修改失败") AddressUpdateFail(960001),
        @CodeAnnot("地址删除失败") AddressDelFail(96000),
        
        //扫码支付(王晓炜增加)
        @CodeAnnot("本门店未开通二维码支付") MerchantNotExit(950001),
        @CodeAnnot("该客户不存在") ClientNotExit(950002),
        @CodeAnnot("客户状态异常") ClientStatusExce(950003),
        @CodeAnnot("获取客户信息异常") ClientExce(950004),
        @CodeAnnot("风险等级过高") Risktoohigh(950005),
        @CodeAnnot("最低消费不能小于1元") LowerExce(950006),
        @CodeAnnot("账户未响应") AccountException(950007),
        @CodeAnnot("系统异常") SystemException(950008),
        
        //扫码支付
        @CodeAnnot("错误") oltpError(960001),
        
        //易宝解绑银行卡
        @CodeAnnot("银行卡信息不存在") CardMessageNotExit(970001),
        @CodeAnnot("解绑银行卡失败") BankCardUnbindFail(970002),
        @CodeAnnot("客户编码为空") ClientCodeIsNull(970003),
        @CodeAnnot("银行卡号为空") BankCardIsNull(970004),
        @CodeAnnot("渠道编码为空") ChannelCodeIsNull(970005),
        @CodeAnnot("银行卡信息为空") CardIdisNull(970006),
        @CodeAnnot("客户账户信息为空") AccountCodeIsNull(970007),
        @CodeAnnot("客户资产过多,不允许解绑") AmountIStoomuch(970008),
        
        @CodeAnnot("该卡未升级，请升级后再试") CardNotUpdate(970009),
        @CodeAnnot("身份信息与银行卡不符") CardUserInfoNotMatch(970009),
        
        //易宝交易限制
        @CodeAnnot("超过单笔最大交易金额") SingleQuotaMore(971001),
        
        //推荐注册
        @CodeAnnot("推荐注册失败") RecomRegistFail(980001),
        @CodeAnnot("二维码已过期，请重新扫码") RecomCodeInvalid(980002),
        
        @CodeAnnot("输入的最大值不能小于最小值 ") MaxNotLessThanMin(980003),
        
        @CodeAnnot("大客户充值信息不存在 ") RechargeInfoNotExit(980004),
        
        //企业客户
        @CodeAnnot("企业用户更新信息失败") ComInfoUpdateError(990001),
        @CodeAnnot("企业用户审核拒绝成功") ComInfoReject(990001),
        
        //======================风控异常信息====================
        @CodeAnnot("买金笔数超限") BuygoldNumOutofrange(990001),
        @CodeAnnot("卖金笔数超限") SellgoldNumOutofrange(990002),
        @CodeAnnot("提现笔数超限") WithdrawNumOutofrange(990003),
        @CodeAnnot("支付笔数超限") PaymentNumOutofrange(990004),
        @CodeAnnot("充值次数超限") RechargeNumOutofrange(990005),
        @CodeAnnot("交易笔数超限") TransNumOutofrange(990005),
        @CodeAnnot("黑名单成员，禁止交易") NumberOfBalackList(990006),
        
        
        @CodeAnnot("提现金额过最大限额") withdrawAmountOutofrange(990008),
        
        @CodeAnnot("该产品只允许现金账户支付") LcProductOnlyCashAccount(990009),
        @CodeAnnot("该产品无效") LcProductINVALID(990010),
        @CodeAnnot("该产品不允许使用优惠券") LcProductNotCoupon(990011),
        
        //国美联合登陆
        @CodeAnnot("无关联用户") GMLoginIDNotRelation(810001),
        @CodeAnnot("联合登陆失败") GMLoginIDOpenIdCheckError(810002),
        @CodeAnnot("获取联合登陆用户信息失败") GetGMLoginUserInfoError(810003),
        @CodeAnnot("联合登陆用户账号不存在") GMUserAccountNotExit(810004),
        @CodeAnnot("联合登陆账号状态异常") GMUserStatusError(810005),
        @CodeAnnot("该国美账号已于其它用户绑定联合登陆关系") GMUserAccountISExit(810006),

        //客户查询
        @CodeAnnot("卡的客户编码与手机的客户编码不匹配") CardNoMsgNotEqualPhoneMsg(950009),   
        @CodeAnnot("卡存在手机客户不存在") CardIsExitPhoneNotExit(950010),
        @CodeAnnot("卡不存在手机客户存在") CardNotExitPhoneIsExit(950011),
        @CodeAnnot("卡不存在手机客户也不存在") CardNotExitPhoneNotExit(950012),
        @CodeAnnot("银联交易超时") UNIONTRADETIMEOUT(810007),
        
        @CodeAnnot("获取tn值失败") GETTNFAIL(810008),
        
    
        
        @CodeAnnot("请刷新后重试") RefreshTryAgain(510010),
        
        @CodeAnnot("请升级到最新版本进行游戏") UpgradeGame(510011),
        @CodeAnnot("请升级到最新版本进行签到") UpgradeSign(510012),
        
        @CodeAnnot("当前客户不是大客户") NotBigCustomer(510013),
        @CodeAnnot("此黄金卡号已挂失！") GoldCardIsMiss(510014),
        @CodeAnnot("此黄金卡号已解绑！") GoldCardIsRelieve(510015),
        
        @CodeAnnot("您的版本过低，请升级后重试!") APP_UPDATE(510016),
          //黄金卡获取验证码
        @CodeAnnot("黄金卡号为空") GCardNoIsEmpty(510001),
        @CodeAnnot("黄金卡不存在") GCardNoIsNotExit(510002),
        @CodeAnnot("黄金卡号有误，请重新输入") GCardNoStatusError(510003),
        
        //绑定黄金卡(B1)
        @CodeAnnot("随机码为空") RandomIsEmpty(510004),
        @CodeAnnot("客户编码为空") ClientCodeEmpty(510005),
        @CodeAnnot("黄金卡已经被绑定") GCardNoIsBind(510006),
        @CodeAnnot("渠道编码为空") ChannelCodeEmpty(510007),
        @CodeAnnot("客户信息不存在") ClientIsEmpty(510008),
        @CodeAnnot("验证码错误，请重新输入") RandomIsNotSuit(510009),
        
        //提金认证
        @CodeAnnot("认证申请单已经存在,请不要重复提出申请") ApplyDataIsExit(510010),
        @CodeAnnot("您已经过提金认证,请勿重复操作!") GoldCertificationIsExit(510011),
        
        @CodeAnnot("活动失败!") ActiveFail(510012),
    ;

    private final int value;
    private static final Map<String, String> hMap = new HashMap<String, String>();

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    StatusCode(int value) {
        this.value = value;
    }

    static {
        Field[] fields = StatusCode.class.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CodeAnnot.class)) {
                hMap.put(field.getName(), field.getAnnotation(CodeAnnot.class)
                        .value());
            }
        }
    }

    public int getValue() {
        return value;
    }

    public String GetDescription() {
        return hMap.get(this.toString());
    }
}
