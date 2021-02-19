package com.springboot.mybatis.controller;

import com.springboot.mybatis.domain.Company;
import com.springboot.mybatis.domain.base.Result;
import com.springboot.mybatis.enums.ResultCode;
import com.springboot.mybatis.service.CompanyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    CompanyService companyService;
    /**通用返回测试**/
    @RequestMapping("/success")
    public Result success(){
        List<Company> list = companyService.selectAllStaff();
        return new Result().success(list);
    };

    /**通用返回测试**/
    @RequestMapping("/fail")
    public Result fail(@RequestParam int id){
        List<Company> list = companyService.selectAllStaffById(id);
        if(list.isEmpty()){
            return new Result().result(ResultCode.NO_DATA.getCode(),ResultCode.NO_DATA.getMsg(),list);
        }
        return new Result().success(list);
    };
}
