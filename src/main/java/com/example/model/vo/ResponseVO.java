package com.example.model.vo;

import com.example.utils.ResponseEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回对象
 */
@Data
public class ResponseVO {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private Map<String, Object> data = new HashMap();

    /**
     * 构造器私有
     */
    private ResponseVO(){}
    /**
     * 返回成功
     */
    public static ResponseVO ok(){
        ResponseVO r = new ResponseVO();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }
    public static ResponseVO ok(Map<String, Object> data ){
        ResponseVO r = new ResponseVO();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        r.setData(data);
        return r;
    }
    /**
     * 返回失败
     */
    public static ResponseVO error(){
        ResponseVO r = new ResponseVO();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }
    /**
     * 设置特定结果
     */
    public static ResponseVO setResult(ResponseEnum responseEnum){
        ResponseVO r = new ResponseVO();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    public ResponseVO message(String message){
        this.setMessage(message);
        return this;
    }

    public ResponseVO code(Integer code){
        this.setCode(code);
        return this;
    }
    public ResponseVO data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public ResponseVO data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}