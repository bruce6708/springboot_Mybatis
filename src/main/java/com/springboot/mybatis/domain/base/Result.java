package com.springboot.mybatis.domain.base;

import com.springboot.mybatis.enums.ResultCode;
import lombok.Data;

/**
 * 通用返回类
 */
@Data
public class Result<T> {
    /*返回体*/
    private  Integer code;
    private String msg;
    private T data;

    /**成功**/
    public  Result success(Object object){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**失败**/
    public  Result fail(Object object){
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMsg(ResultCode.FAIL.getMsg());
        result.setData(object);
        return result;
    }
    public  Result result(Integer code, String msg, Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
}
