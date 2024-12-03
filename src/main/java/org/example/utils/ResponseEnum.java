package org.example.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    ERROR(-1, "服务器内部错误"),

    //-1xx 服务器错误
    BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),
    SERVLET_ERROR(-102, "servlet请求异常"), //-2xx 参数校验
    DELETE_FILE_FAILED(103,"删除文件错误"),
    UPLOAD_ERROR(-103, "文件上传错误"),
    EXPORT_DATA_ERROR(104, "数据导出失败"),
    DATA_NOt_EXISITS(105,"数据不存在"),
    PARAM_IS_NULL_ERROR(-105,"参数不能为空"),
    IMPORT_DATA_ERROR(106, "数据导入失败"),
    FILE_IS_EMPTY(107,"上传文件内容为空"),
    DISALLOW_DELETE_DATA(108,"该数据有关联数据不能删除"),
    TOO_MANY_REQUESTS(109,"请求太频繁了"),

    //-2xx 参数校验
    USRE_ID_NULL_ERROR(-201, "用户Id不能为空"),
    MOBILE_NULL_ERROR(-202, "手机号码不能为空"),
    MOBILE_ERROR(-203, "手机号码不正确"),
    PASSWORD_NULL_ERROR(204, "密码不能为空"),
    CODE_NULL_ERROR(205, "验证码不能为空"),
    CODE_ERROR(206, "验证码错误"),
    MOBILE_EXIST_ERROR(207, "手机号已被注册"),
    LOGIN_MOBILE_ERROR(208, "用户不存在"),
    LOGIN_PASSWORD_ERROR(209, "密码错误"),
    LOGIN_LOKED_ERROR(210, "用户被锁定"),
    LOGIN_AUTH_ERROR(-211, "未登录"),
    REGISTER_FAIL(212,"注册失败"),
    USER_REPEAT(-212,"重复注册"),
    USER_PWD_ERROR(213,"用户密码错误"),
    ACCOUNT_UNREGISTER(-213,"用户未注册"),
    ACCOUNT_UNLOGIN(214,"用户未登录"),
    USER_NOT_EXIST(215,"用户不存在"),

    USER_BIND_IDCARD_EXIST_ERROR(-301, "身份证号码已绑定"),
    USER_NO_BIND_ERROR(302, "用户未绑定"),
    LEND_INVEST_ERROR(305, "当前状态无法投标"),
    LEND_FULL_SCALE_ERROR(306, "已满标，无法投标"),
    NOT_SUFFICIENT_FUNDS_ERROR(307, "余额不足，请充值"),

    PAY_UNIFIEDORDER_ERROR(401, "统一下单错误"),

    ALIYUN_SMS_LIMIT_CONTROL_ERROR(-502, "短信发送过于频繁"),//业务限流
    ALIYUN_SMS_ERROR(-503, "短信发送失败"),//其他失败

    WEIXIN_CALLBACK_PARAM_ERROR(-601, "回调参数不正确"),
    WEIXIN_FETCH_ACCESSTOKEN_ERROR(-602, "获取access_token失败"),
    WEIXIN_FETCH_USERINFO_ERROR(-603, "获取用户信息失败"),
    ;
    private final Integer code;//状态码
    private final String message;//消息
}